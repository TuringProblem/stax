
@FunctionalInterface
public interface ComponentBuilder {
  String Build(int row, int col, String primary, String secondary, String text);
}

