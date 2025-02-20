
import game.card.CardChamber;
import game.login.User;

/**
 * @author { @Override } | 17:06 : 20250217
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

public record Player(String id, User user, CardChamber chamber, int ranking) {
    /**
     *
     * withRanking(int newRanking) expects that after every game (whether win or
     * lose) -> the user will have a new rank
     * This handles that new instance of {@see Player} -> with the accumulated rank.
     **/
    public Player withRanking(int newRanking) {
        return new Player(id, user, chamber, newRanking);
    }

    /**
     * @see CardChamber class: handles the inventory of cards that the user
     *      currently has on hand.
     *      withChamber(CardChamber newChamber) expects that when the user adds a
     *      new card into the inventory
     *      There will be an update via {@see Player} -> with the new updated
     *      inventory of cards.
     **/
    public Player withChamber(CardChamber newChamber) {
        return new Player(id, user, newChamber, ranking);
    }
}
