import java.util.function.Supplier;

/**
 * Used to implement Haskell-style guards. Guard conditions can be specified along with lambda
 * expressions. The expression corresponding to the first matching guard condition will be evaluated
 * and returned.
 *
 * @param <T>
 */
public class Guard<T> {
  private T value;
  private boolean alreadyMatched = false;

  /** Constant useful for when a default guard is needed. Always evaluates to true */
  public static final boolean OtherwiseGuard = true;

  private Guard() {
    this.value = null;
    this.alreadyMatched = false;
  }

  /**
   * Initializes an instance of the <code>Guard</code> class. Any guard-related operations happen on
   * this instance.
   *
   * @param <T> the type of the evaluated expression
   * @return an instance of <code>Guard</code>
   */
  public static <T> Guard<T> initializeGuard() {
    return new Guard<T>();
  }

  /**
   * Returns the value of the expression evaluated by a matching guard. In case no guard matches, a
   * <code>RuntimeException</code> is thrown
   *
   * @return
   */
  public T getValue() {
    if (!alreadyMatched) {
      throw new RuntimeException();
    }
    return value;
  }

  /**
   * Used on a <code>Guard</code> instance to specify a guard condition and a lambda expression that
   * will be evaluated if the condition is true. Returns a <code>Guard</code> instance on which
   * further guard conditions can be checked. Only the first expression for which the guard matches
   * will be evaluated.
   *
   * @param expression
   * @param result
   * @return an instance of the <code>Guard</code> class with existing conditions (if any) already
   *     applied
   */
  public Guard<T> guard(final boolean expression, final Supplier<T> result) {
    if (!alreadyMatched && expression) {
      this.value = result.get();
      this.alreadyMatched = true;
    }
    return this;
  }
}
