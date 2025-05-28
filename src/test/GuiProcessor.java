import java.lang.reflect.Field;
import java.lang.reflect.Method;
import com.example.app.App;
import ScreenContainer;
import com.example.app.annotations.Button;
import com.example.app.annotations.Position;

public class GuiProcessor {
  public static void bootstrap(App app, String basePackage) {
    for (Class<?> cls : ClasspathScanner.findAnnotated(Screen.class, basePackage)) {
      Screen meta = cls.getAnnotation(Screen.class);
      Object instance = cls.getDeclaredConstructor().newInstance();
      ScreenContainer container = new ScreenContainer(meta.id());

      for (Field f : cls.getDeclaredFields()) {
        if (f.isAnnotationPresent(Button.class)) {
          Button btnMeta = f.getAnnotation(Button.class);
          Position pos = f.getAnnotation(Position.class);
          Size sz = f.getAnnotation(Size.class);
          TextButton btn = new TextButton(btnMeta.label(), () -> {
            Method m = cls.getMethod(btnMeta.onClick());
            m.invoke(instance);
          }).style(app.getTheme().getStyle(btnMeta.style()))
              .position(pos.x(), pos.y())
              .size(sz.width(), sz.height());

          container.add(btn);
          f.setAccessible(true);
          f.set(instance, btn);
        }
        // …handle other widget types…
      }

      app.registerScreen(container);
    }
  }
}
