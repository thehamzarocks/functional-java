import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Quicksort {

  static <T> List<T> joinLists(List<T>... lists) {
    List<T> result = new ArrayList<>();
    Stream.of(lists).forEach(result::addAll);
    return result;
  }

  public static List<Integer> quickSort(List<Integer> inputList) {
    List<Integer> result =
        Guard.<List<Integer>>initializeGuard()
            .guard(inputList.isEmpty(), () -> new ArrayList<>())
            .guard(
                Guard.OtherwiseGuard,
                () ->
                    joinLists(
                            quickSort(ListComprehension.apply(SplitList.of(inputList).rest, x -> x, x -> x <= SplitList.of(inputList).head)), 
                            List.of(inputList.get(0)),
                            quickSort(ListComprehension.apply(SplitList.of(inputList).rest, x -> x, x -> x > SplitList.of(inputList).head))
                    ))
            .getValue();
    return result;
  }
}
