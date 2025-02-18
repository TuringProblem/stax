
public class GameService {
    private final AtomicReference<GameState> state = new AtomicReference<>(GameState.initial());
}
