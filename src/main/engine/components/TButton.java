public class TButton implements ComponentBuilder {
  private String text;

  public TButton(String text) {
    this.text = text;
  }

  @Override
  String build(int col, int row, String primary, String secondary, String text) {
    Ansi color = new Ansi(primary, secondary);

  }
}
