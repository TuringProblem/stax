package game.card;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.List;
import java.util.Random;

/**
 * @author { @Override } | 17:26 ; 20250218
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

public enum CardRarity {
  /**
   * {DESIGN} - Cards will be different "Colors based on Rarity"
   * ----------------------------------
   * BEGINNER:
   * DARK_YELLOW => { FOREGROUND: "Esc[33m" } : { BACKGROUND: "Esc[43m" }
   *
   * ROOKIE:
   * BRIGHT_YELLOW => { FOREGROUND: "Esc[93m" } : { BACKGROUND: "Esc[103m" }
   *
   * APPRENTICE:
   * WHITE => { FOREGROUND: "Esc[97m" } : { BACKGROUND: "Esc[107m" }
   *
   * UNIQUE:
   * => { FOREGROUND: "Esc[97m" } : { BACKGROUND: "Esc[107m" }
   *
   * LEGENDARY:
   * DARK_RED => { FOREGROUND: "Esc[31m" } : { BACKGROUND: "Esc[41m" }
   *
   * MYTHICAL:
   * DARK_MAGENTA => { FOREGROUND: "Esc[35m" } : { BACKGROUND: "Esc[45m" }
   *
   **/

  BEGINNER(50),
  ROOKIE(20),
  APPRENTICE(5),
  UNIQUE(1),
  LEGENDARY(0.5),
  MYTHICAL(0.01);

  private final float chance;
  private static final List<CardRarity> VALUES = Collections.unmodifiableList(Arrays.asList());
  private static final Random RAND = new Random();

  private CardRarity(float chance) {
    this.chance = chance;
  }

  public float getChance() {
    return chance;
  }

  public static CardRarity getRandomRarity() {
    return VALUES.get(RAND.nextInt());
  }

  /*
   * @Override
   * public String toString() {
   * return foregroundColor + super.toString()
   * }
   */
}
