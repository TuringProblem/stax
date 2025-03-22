package game.card;

import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author { @Override } | 17:26 ; 20250218
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/
public enum CardType {
  /**
   * TODO: Come up with a system for the types (which card has benefits over the
   * other)
   * OFFENSIVE => Attack cards
   * SUPPORT => Healing cards, and other Supportive roles (buffs)
   * WILDCARD => Cards that will be CRITICAL for strategically winning
   **/

  OFFENSIVE,
  SUPPORT,
  WILDCARD;

  // Cache the result as a value
  private static final List<CardType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
  private static int SIZE = VALUES.size();
  private static final Random RAND = new Random();

  public static CardType randomType() {
    return VALUES.get(RAND.nextInt(SIZE));
  }
}
