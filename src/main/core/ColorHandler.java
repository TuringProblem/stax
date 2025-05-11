import java.util.HashMap;

/**
 * @author { @Override } | @since 20250508 @22:12
 * @see <a href="https://github.com/TuringProblem/stax/"> Github Profile/Project
 *      </a>
 **/
public class ColorHandler()
{
  private final EnumMap<TUI.Foreground, List<String>> mappedValues = new EnumMap<>(TUI.Foreground.class);

  ArrayList<String> whiteForeColorSet=new ArrayList<>(){{add(TUI.WHITE.getAnsiCode()+TUI.BLACK_BACKGROUND.getAnsiCode());add(TUI.WHITE.getAnsiCode()+TUI.RED_BACKGROUND.getAnsiCode());add(TUI.WHITE.getAnsiCode()+TUI.GREEN_BACKGROUND.getAnsiCode());add(TUI.WHITE.getAnsiCode()+TUI.YELLOW_BACKGROUN.getAnsiCode());add(TUI.WHITE.getAnsiCode()+TUI.BLUE_BLACKGROUND.getAnsiCode());add(TUI.WHITE.getAnsiCode()+TUI.PURPLE_BACKGROUND.getAnsiCode());add(TUI.WHITE.getAnsiCode()+TUI.CYAN_BACKGROUND.getAnsiCode());}};

  ArrayList<String> blueForeColorSet=new ArrayList<>(){{add(TUI.BLUE.getAnsiCode()+TUI.BLACK_BACKGROUND.getAnsiCode());add(TUI.BLUE.getAnsiCode()+TUI.RED_BACKGROUND.getAnsiCode());add(TUI.BLUE.getAnsiCode()+TUI.GREEN_BACKGROUND.getAnsiCode());add(TUI.BLUE.getAnsiCode()+TUI.WHITE_BACKGROUND.getAnsiCode());add(TUI.BLUE.getAnsiCode()+TUI.YELLOW_BACKGROUN.getAnsiCode());add(TUI.BLUE.getAnsiCode()+TUI.PURPLE_BACKGROUND.getAnsiCode());add(TUI.BLUE.getAnsiCode()+TUI.CYAN_BACKGROUND.getAnsiCode());}};

  ArrayList<String> redForColorSet = new ArrayList<>() {
    {
      add(TUI.RED.getAnsiCode() + TUI.BLACK_BACKGROUND.getAnsiCode());
      add(TUI.RED.getAnsiCode() + TUI.GREEN_BACKGROUND.getAnsiCode());
      add(TUI.RED.getAnsiCode() + TUI.WHITE_BACKGROUND.getAnsiCode());
      add(TUI.RED.getAnsiCode() + TUI.YELLOW_BACKGROUN.getAnsiCode());
      add(TUI.RED.getAnsiCode() + TUI.BLUE_BLACKGROUND.getAnsiCode());
      add(TUI.RED.getAnsiCode() + TUI.PURPLE_BACKGROUND.getAnsiCode());
      add(TUI.RED.getAnsiCode() + TUI.CYAN_BACKGROUND.getAnsiCode());
    }
  };
}
