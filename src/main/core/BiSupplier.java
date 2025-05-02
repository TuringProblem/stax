
@FunctionalInterface
public interface BiSupplier<T, U, R> {
  R get(T t, U u);
}
