import logger.Logger;
import logger.Level;

public class Ansi {
  private String primary, secondary;
  private boolean isPrimary;
  public static final String ESC = "\033[0m";

  private static Logger log = new Logger.Builder()
      .name("\n===LOGGER===\n---------------\n")
      .message("Add method name")
      .level(Level.DEBUG)
      .timestamp(java.time.LocalDateTime.now().toString()).build();

  public Ansi(String primary, String secondary) {
    this.primary = primary;
    this.secondary = secondary;
    this.isPrimary = false;
  }

  public void setPrimary(String primary) {
    this.primary = primary;
  }

  public void setSecondary(String secondary) {
    this.secondary = secondary;
  }

  public String getPrimary() {
    return primary;
  }

  public String getSecondary() {
    return secondary;
  }

  enum Color {
    BLACK,
    BRIGHT_BLACK,
    RED,
    BRIGHT_RED,
    GREEN,
    BRIGHT_GREEN,
    YELLOW,
    BRIGHT_YELLOW,
    BLUE,
    BRIGHT_BLUE,
    MAGENTA,
    BRIGHT_MAGENTA,
    CYAN,
    BRIGHT_CYAN,
    WHITE,
    BRIGHT_WHITE,
    DEFAULT;

    public Color transferTextToAnsi(String color) {
      log.changeMessage(String.format("Method: transferTextToAnsi(%s)", color));
      System.out.println(log.getName() + log.getMessage() + "\n");
      return switch (color.toUpperCase()) {
        case "BLACK" -> BLACK;
        case "BRIGHT_BLACK" -> BRIGHT_BLACK;
        case "RED" -> RED;
        case "BRIGHT_RED" -> BRIGHT_RED;
        case "GREEN" -> GREEN;
        case "BRIGHT_GREEN" -> BRIGHT_GREEN;
        case "YELLOW" -> YELLOW;
        case "BRIGHT_YELLOW" -> BRIGHT_YELLOW;
        case "BLUE" -> BLUE;
        case "BRIGHT_BLUE" -> BRIGHT_BLUE;
        case "MAGENTA" -> MAGENTA;
        case "BRIGHT_MAGENTA" -> BRIGHT_MAGENTA;
        case "CYAN" -> CYAN;
        case "BRIGHT_CYAN" -> BRIGHT_CYAN;
        case "WHITE" -> WHITE;
        case "BRIGHT_WHITE" -> BRIGHT_WHITE;
        default -> DEFAULT;
      };

    }

    public String setAnsiValue(String color, boolean isPrimary) {
      // System.out.printf("===LOG===\ncalled: setAnsiValue(%s)\n", color);
      log.changeMessage(String.format("Method: transferTextToAnsi(%s, %b)", color, isPrimary));
      System.out.printf("%s%s\n\n", log.getName(), log.getMessage());
      if (isPrimary) {
        return switch (transferTextToAnsi(color)) {
          case BLACK -> "\033[30m";
          case BRIGHT_BLACK -> "\033[90m";
          case RED -> "\033[31m";
          case BRIGHT_RED -> "\033[91m";
          case GREEN -> "\033[32m";
          case BRIGHT_GREEN -> "\033[92m";
          case YELLOW -> "\033[33m";
          case BRIGHT_YELLOW -> "\033[93m";
          case BLUE -> "\033[34m";
          case BRIGHT_BLUE -> "\033[94m";
          case MAGENTA -> "\033[35m";
          case BRIGHT_MAGENTA -> "\033[95m";
          case CYAN -> "\033[36m";
          case BRIGHT_CYAN -> "\033[96m";
          case WHITE -> "\033[37m";
          case BRIGHT_WHITE -> "\033[97m";
          case DEFAULT -> "\033[39m";
          default -> "";
        };
      } else {
        return switch (transferTextToAnsi(color)) {
          case BLACK -> "\033[40m";
          case BRIGHT_BLACK -> "\033[100m";
          case RED -> "\033[41m";
          case BRIGHT_RED -> "\033[101m";
          case GREEN -> "\033[42m";
          case BRIGHT_GREEN -> "\033[102m";
          case YELLOW -> "\033[43m";
          case BRIGHT_YELLOW -> "\033[103m";
          case BLUE -> "\033[44m";
          case BRIGHT_BLUE -> "\033[104m";
          case MAGENTA -> "\033[45m";
          case BRIGHT_MAGENTA -> "\033[105m";
          case CYAN -> "\033[46m";
          case BRIGHT_CYAN -> "\033[106m";
          case WHITE -> "\033[47m";
          case BRIGHT_WHITE -> "\033[107m";
          case DEFAULT -> "\033[49m";
          default -> "";
        };
      }
    }

    public String setForegroundAndBackground(String fg, String bg, String text) {
      log.changeMessage(String.format("Method: setForegroundAndBackground(%s, %s)", fg, bg));
      System.out.printf("%s%s\n\n", log.getName(), log.getMessage());
      String foreground = setAnsiValue(fg, true);
      String background = setAnsiValue(bg, false);
      if (foreground.isEmpty() || background.isEmpty()) {
        return String.format("%s%s%s\n", ESC, text, ESC);
      }

      String combo = foreground + background;
      return String.format("%s%s%s\n", combo, text, ESC);
    }
  }
}
