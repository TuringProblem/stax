package game.card;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author { @Override } | 17:26 ; 20250218
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 *
 **/

public enum CardStyle {
  NORMAL,
  HOLO,
  MATTE,
  LIMITED_EDITION;

  private static final List<CardStyle> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
  private static final int SIZE = VALUES.size();
  private static final java.util.Random RAND = new java.util.Random();

  public static CardStyle getRandomCardStyle() {
    return VALUES.get(RAND.nextInt(SIZE));
  }

}
