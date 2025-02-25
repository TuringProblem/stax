package game.card;

/**
 * @author { @Override } | 17:26 ; 20250218
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

//


public record Card(String id, String name, CardType type, CardRarity rarity, int power) {
    // Using Static Factory to create the card
    public static card createCard(String name, CardType type, int power) {
        return new Card(UUID.randomUUID(), name, type, power);
    }

    //TODO: Create methods for the following:
    //1) Need to implement method for when the card is in a battle { Most likely will make a ActionHandler Interface }
}
