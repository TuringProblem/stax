//import java.util.HashMap;
//import java.util.Map;

/**
 * @author { @Override } | @since 20250528 : @10:23
 *
 **/
public class ButtonTest {

  public static void main(String[] args) {
    ButtonTest buttonTest = new ButtonTest();
    ComponentBuilder buttonBuilder = (row, col, primary, secondary, text) -> {
      Ansi color = new Ansi(primary, secondary);
      Ansi.Color ansiColor = Ansi.Color.valueOf(primary.toUpperCase());
      System.out.println("Button created at (" + row + ", " + col + ") with text: " + text);
      System.out.println("Primary color: " + color.getPrimary());
      System.out.println("Secondary color: " + color.getSecondary());
      System.out.printf("test : %s%s%s%s\n", ansiColor.setAnsiValue(primary, true),
          ansiColor.setAnsiValue(secondary, false), primary, color.ESC);
      System.out.printf("test : %s\n", ansiColor.setForegroundAndBackground(primary, secondary, text));
      return String.format("Button at (Row: %d, Col: %d) with primary color %s, secondary color %s\nand text: '%s'",
          row, col, primary, secondary, ansiColor.setForegroundAndBackground(primary, secondary, text));
    };
    // System.out.println(builder.build(1, 1, "red", "black", "Hello, World!"));
    String build = buttonBuilder.Build(1, 1, "green", "black", "[CLICK ME]");
    System.out.printf("Button: %s\n", build);
  }
}
