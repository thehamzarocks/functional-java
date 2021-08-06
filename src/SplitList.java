import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class SplitList<T> {
  T head;
  List<T> rest;

  public SplitList(T head, List<T> rest) {
    this.head = head;
    this.rest = rest;
  }

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
