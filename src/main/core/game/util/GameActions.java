import java.util.Function;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * @author { @Override } | 17:06 : 20250217
 * @see <a href="https://github.com/TuringProblem">GitHub Profile</a>
 **/

public class GameActions {
    public static Function<GameState, Optional<Match>> findMatch(Player player, int rankingRange) {
        return state -> state.players().values().stream()
            .filter(p -> !p.equals(player))
            .filter(p -> Math.abs(p.ranking() - player.ranking() <= rankingRange)
            .findFirst()
            .map(opponent -> new Match(UUID.randomUUID().toString(), player, opponent));
    }

    public static Function<GameState, GameState> addPlayer(Player player) {
        return state -> new Gamestate(
            Stream.concat(state.players().entrySet().stream(), Stream.of(Map.entry(player.id(), player))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)),
            state.activeMatches(),
            state.eventLog()
        );
    }
    public static BiFunction<GameState, String, Optional<Player>> getPlayer = (state, playerId) -> Optional.ofNullable(state.players().get(playerId));
}
