import java.util.function.Function;
import java.util.function.Supplier;

class Guard<T> {
  private T value;
  private boolean alreadyMatched = false;

  static final boolean OtherwiseGuard = true;

  public Guard() {
    this.value = null;
    this.alreadyMatched = false;
  }

  public static <T> Guard<T> initializeGuard() {
    return new Guard<T>();
  }

  public T getValue() {
    if(!alreadyMatched) {
      throw new RuntimeException();
    }
    return value;
  }

  public Guard<T> guard(final boolean expression, final Supplier<T> result) {
    if(!alreadyMatched && expression) {
      this.value = result.get();
      this.alreadyMatched = true;
    }
    return this;
  }
}