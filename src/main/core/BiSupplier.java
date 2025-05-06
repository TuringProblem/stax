/**
 * @author { @Override } | @since 04012025 : 14:50
 * @see <a href="https://github.com/TuringProblem/">GitHub Profile</a>
 **/
@FunctionalInterface
public interface BiSupplier<T, U, R> {
  R get(T t, U u);
}
