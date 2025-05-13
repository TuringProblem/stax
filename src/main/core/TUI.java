public class TUI {
  enum Foreground {
    BLACK("\033[30m"),
    RED("\033[31m"),
    GREEN("\033[32m"),
    YELLOW("\033[33m"),
    BLUE("\033[34m"),
    PURPLE("\033[35m"),
    CYAN("\033[36m"),
    WHITE("\033[37m");

    private final String ansiCode;

    Foreground(String ansiCode) {
      this.ansiCode = ansiCode;
    }

    public String getAnsiCode() {
      return this.ansiCode;
    }

  }

  enum Background {
    BLACK("\033[40m"),
    RED("\033[41m"),
    GREEN("\033[42m"),
    YELLOW("\033[43m"),
    BLUE("\033[44m"),
    PURPLE("\033[45m"),
    CYAN("\033[46m"),
    WHITE("\033[47m");

    private final String ansiCode;

    Background(String ansiCode) {
      this.ansiCode = ansiCode;
    }

    public String getAnsiCode() {
      return this.ansiCode;
    }

  }

  enum Utils {
    RESET("\033[0m"),
    CLEAR_SCREEN("\033[H\033[2J");

    private String ansiCode;

    Utils(String ansiCode) {
      this.ansiCode = ansiCode;
    }

    public String getAnsiCode() {
      return this.ansiCode;
    }

  }

  enum ComboColors {
    RED_W_WHITE(TUI.Foreground.RED.getAnsiCode() + TUI.Background.WHITE.getAnsiCode()),
    RED_W_BLACK(TUI.Foreground.RED.getAnsiCode() + TUI.Background.BLACK.getAnsiCode()),
    RED_W_BLUE(TUI.Foreground.RED.getAnsiCode() + TUI.Background.BLUE.getAnsiCode()),
    WHITE_W_BLACK(TUI.Foreground.WHITE.getAnsiCode() + TUI.Background.BLACK.getAnsiCode());

    private String ansiCode;

    ComboColors(String ansiCode) {
      this.ansiCode = ansiCode;
    }

    public String getAnsiCode() {
      return this.ansiCode;
    }
  }
}
