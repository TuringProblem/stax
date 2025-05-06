enum TUI {
  RESET("\033[0m"),
  CLEAR_SCREEN("\033[H\033[2J"),
  RED("\033[31m"),
  BLUE_BACKGROUND("\033[44m"),
  MIXED("\033[31m" + "\033[41m");

  private final String ansiCode;

  TUI(String ansiCode) {
    this.ansiCode = ansiCode;
  }

  public String getAnsiCode() {
    return this.ansiCode;
  }
}
