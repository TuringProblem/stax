import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Screen {
  String id();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Button {
  String label();

  String action() default ""; // method to call on click
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Position {
  int row();

  int col();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MouseClickable {
}

// 2) The TUI primitives:
interface Widget {
  void render(String fgColor, String bgColor);

  default void click() {
  }
  default void color(String fgColor, String bgColor) {
    // This method can be used to set colors if needed
  }

  default boolean contains(int row, int col) {
    return false;
  }
}

class TextButton implements Widget {
  int row, col;
  String label;
  Runnable onClick;

  TextButton(String label, Runnable onClick) {
    this.label = label;
    this.onClick = onClick;
  }

  TextButton position(int r, int c) {
    row = r;
    col = c;
    return this;
  }

  /**
   * TextButton color(String fgColor, String bgColor) {
   * return this;
   * }
   **/

  @Override
  public void render(String fgColor, String bgColor) {

    // move + print with a cyan background
    System.out.print(String.format("\u001b[%d;%dH\u001b[%d;%dm[%s]\u001b[0m",
        row, col, colorConverter(fgColor, true), colorConverter(bgColor, false), label));
  }

  private int colorConverter(String color, boolean fg) {
    if (fg) {
      return switch (color.toLowerCase()) {
        case "red" -> 31;
        case "green" -> 32;
        case "yellow" -> 33;
        case "blue" -> 34;
        case "purple" -> 35;
        case "cyan" -> 36;
        case "white" -> 37;
        default -> 8;
      };
    } else {
      return switch (color.toLowerCase()) {
        case "red" -> 41;
        case "green" -> 42;
        case "yellow" -> 43;
        case "blue" -> 44;
        case "purple" -> 45;
        case "cyan" -> 46;
        case "white" -> 47;
        default -> 8;
      };
    }
  }

  @Override
  public void click() {
    onClick.run();
  }

  @Override
  public boolean contains(int r, int c) {
    return r == row && c >= col && c < col + label.length() + 2; //
  }
}

// 1) The screen container that holds widgets:
class ScreenContainer {
  final String id;
  final List<Widget> widgets = new ArrayList<>();
  final List<Widget> clickables = new ArrayList<>();

  ScreenContainer(String id) {
    this.id = id;
  }

  void add(Widget w, boolean clickable) {
    widgets.add(w);
  }

  void render() {
    System.out.print("\u001b[2J\u001b[H"); // clear screen and move cursor to top-left?
    System.out.println("== Screen: " + id + " ==");
    for (Widget w : widgets)
      w.render("blue", "red");

  }

  void handleClick(int r, int c) {
    clickables.stream().filter(w -> w.contains(r, c)).forEach(Widget::click);
  }
  // System.out.println("\n\n(Buttons auto-clicked for demo)");
  // for (Widget w : widgets)
  /**
   * if (!widgets.isEmpty()) {
   * widgets.get(0).click(); // auto-click the first button for demo
   * }
   **/
}

// 3) Our “framework” bootstrapper:
// Still need to figure this shit out on my own...
class GuiProcessor {
  static void bootstrap(App app, Class<?>... screens) throws Exception {
    for (Class<?> cls : screens) {
      if (!cls.isAnnotationPresent(Screen.class))
        continue;
      String id = cls.getAnnotation(Screen.class).id();
      Object instance = cls.getDeclaredConstructor().newInstance();
      ScreenContainer container = new ScreenContainer(id);

      for (Field f : cls.getDeclaredFields()) {
        if (f.isAnnotationPresent(Button.class)) {
          Button bm = f.getAnnotation(Button.class);
          Position pm = f.getAnnotation(Position.class);
          boolean clickable = f.isAnnotationPresent(MouseClickable.class);

          TextButton btn = new TextButton(bm.label(), () -> {
            try {
              Method m = cls.getMethod(bm.action());
              m.invoke(instance);
            } catch (Exception ex) {
              ex.printStackTrace();
            }
          }).position(pm.row(), pm.col());
          container.add(btn, clickable);
          f.setAccessible(true);
          f.set(instance, btn);
        }
      }

      app.registerScreen(container);
    }
  }
}

// 4) Your “App” shell:
class App {
  Map<String, ScreenContainer> screens = new HashMap<>();

  void registerScreen(ScreenContainer c) {
    screens.put(c.id, c);
  }

  void render(String id) {
    ScreenContainer c = screens.get(id);
    if (c != null)
      c.render();
  }

}

@Screen(id = "main")
class HomeScreen {
  @Button(label = "Hello World", action = "onHello")
  @Position(row = 4, col = 50)
  TextButton helloBtn;

  @Button(label = "Bye")
  @Position(row = 4, col = 1)
  TextButton byeBtn;

  public void onHello() {
    System.out.println("\n\n🥳 You clicked Hello! 🥳");
  }

  public void onBye() {
    System.out.println("\n\n👋 You clicked Bye! 👋");
  }
}

public class SimpleExample {
  public static void main(String[] args) throws Exception {
    App app = new App();
    GuiProcessor.bootstrap(app, HomeScreen.class);
    // render the “main” screen:
    app.render("main");
    System.out.println("\n\nPress ENTER to exit.");
    System.in.read();
  }
}
