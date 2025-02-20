package game.card;

import java.util.Collections;
import java.util.List;

/**
 * @author { @Override } | 17:26 ; 20250218
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

public record CardChamber(List<Card> cards) {
    public CardChamber {
        if (cards.size() > 15) {
            throw new IllegalArgumentException("Chamber cannot contain more than 15 cards\n");
        }
        cards = Collections.unmodifiableList(cards);
    }
}
