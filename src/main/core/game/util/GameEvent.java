/**
 * @author { @Override } | 17:06 : 20250217
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/
public sealed interface GameEvent {
    /**
     * PlayerJoined Class handles the {@see Player} -> that join the match
     **/
    record PlayerJoined(Player player) implements GameEvent{}
    /**
     * MatchStarted Class checking for the {@see Player} -> that are currently in the match starting
     **/
    record MatchStarted(String matchId, Player playerOne, Player playerTwo,) implements GameEvent{}
    /**
     * MatchEnded Class Concludes the winner of the match 
     **/
    record MatchEnded(String matchId, String winnerId) implements GameEvent{}
    /**
     * CardPlayed Class handles the process of cards that are being played during the match
     **/
    record CardPlayed(String matchId, Player player, Card card) implements GameEvent{}
}
