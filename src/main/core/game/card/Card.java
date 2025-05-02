package game.card;

import java.util.UUID;

/**
 * @author { @Override } | 17:26 ; 20250218
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

public record Card(String id, String name, CardType type, CardRarity rarity, CardStyle style, int power) {

  Card isStarterPack() {
    return new Card(
        UUID.randomUUID().toString(),
        getTypeSymbol(type),
        type,
        CardRarity.getRandomRarity(),
        CardStyle.getRandomCardStyle(),
        getPower(rarity));
  }

  public String getTypeSymbol(CardType type) {
    return switch (type) {
      case OFFENSIVE -> "|⚔| Offensive |⚔|";
      case SUPPORT -> "|✝| Support |✝|";
      case WILDCARD -> "|?| Wildcard |?|";
    };
  }

  public int getPower(CardRarity rarity) {
    return switch (rarity) {
      case BEGINNER -> CardRarity.BEGINNER.getPower();
      case ROOKIE -> CardRarity.ROOKIE.getPower();
      case APPRENTICE -> CardRarity.APPRENTICE.getPower();
      case UNIQUE -> CardRarity.UNIQUE.getPower();
      case LEGENDARY -> CardRarity.LEGENDARY.getPower();
      case MYTHICAL -> CardRarity.MYTHICAL.getPower();
    };
  }

  // TODO: Create methods for the following:
  // 1) Need to implement method for when the card is in a battle { Most likely
  // will make a ActionHandler Interface }
}
