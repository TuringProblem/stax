/**
 * @author { @Override } | 17:06 : 20250217
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

@functionalInterface
public interface GameEventHandler {
    GameState handle(GameState state, GameEvent event);
}
