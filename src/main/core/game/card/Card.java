package game.card;

/**
 * @author { @Override } | 17:26 ; 20250218
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

public record Card(String id, String name, CardType type, CardRarity rarity, CardStyle style, int power) {
  // Using Static Factory to create the card
  public static card createCard(String name, int power) {
    return new Card(java.util.UUID.randomUUID().toString(), name, CardType.randomType(), CardRarity., power);
  }

  public String getTypeSymbol() {
    return switch (type) {
      case OFFENSIVE -> "|⚔|";
      case SUPPORT -> "|✝|";
      case WILDCARD -> "|?|";
    };
  }

  // TODO: Create methods for the following:
  // 1) Need to implement method for when the card is in a battle { Most likely
  // will make a ActionHandler Interface }
}
