import java.util.ArrayList;
import java.util.List;

/**
 * Handy for splitting lists into the first element and the rest of the list to make certain list
 * operations easier
 *
 * @param <T>
 */
public class SplitList<T> {

  /** The fist element of the split list. */
  public T head;

  /** The portion of the list excluding the first element */
  public List<T> rest;

  /**
   * Initializes a <code>SplitList</code> instance. Prefer using <code>Splitlist.of</code> to create
   * SplitList instances
   *
   * @param head
   * @param rest
   */
  public SplitList(T head, List<T> rest) {
    this.head = head;
    this.rest = rest;
  }

  /**
   * Creates a splitList instance from an input <code>List</code>. Use this instead of directly
   * creating splitListInstances using the constructor
   *
   * @param list
   * @param <T>
   * @return
   */
  public static <T> SplitList<T> of(List<T> list) {
    if (list.isEmpty()) {
      throw new RuntimeException();
    }
    T head = list.get(0);
    List<T> rest =
        Guard.<List<T>>initializeGuard()
            .guard(list.size() == 1, ArrayList::new)
            .guard(Guard.OtherwiseGuard, () -> new ArrayList<>(list).subList(1, list.size()))
            .getValue();
    return new SplitList(head, rest);
  }
}
