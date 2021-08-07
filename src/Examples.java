import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Examples {

  List<String> sayHello(List<Integer> inputList) {
    return ListComprehension.apply(inputList, x -> "Hello" + x, x -> (2 * x < 12));
  }

  public String getTheRightString(int input) {
    final String result =
        Guard.<String>initializeGuard()
            .guard(input % 2 == 0, () -> "Even")
            .guard(Guard.OtherwiseGuard, () -> "Odd")
            .getValue();
    return result;
  }

  public List<Integer> sortedSmaller(SplitList<Integer> splitList) {
    return new Examples()
        .quickSort(
            ListComprehension.apply(
                    splitList.rest, x -> x, x -> x <= splitList.head));
  }

  public List<Integer> sortedLarger(SplitList<Integer> splitList) {
    return new Examples()
        .quickSort(
            ListComprehension.apply(splitList.rest, x -> x, x -> x > splitList.head));
  }

  public static <T> List<T> joinLists(List<T>... lists) {
    List<T> result = new ArrayList<>();
    Stream.of(lists).forEach(list -> result.addAll(list));
    return result;
  }

  public List<Integer> quickSort(List<Integer> inputList) {
    List<Integer> result =
        Guard.<List<Integer>>initializeGuard()
            .guard(inputList.isEmpty(), () -> new ArrayList<>())
            .guard(inputList.size() == 1, () -> List.of(inputList.get(0)))
            .guard(
                Guard.OtherwiseGuard,
                () ->
                    Examples.joinLists(
                        sortedSmaller(SplitList.of(inputList)),
                        List.of(inputList.get(0)),
                        sortedLarger(SplitList.of(inputList))))
            .getValue();
    return result;
  }

  public static void main(String[] args) {
    List<Integer> input = List.of(5, 12, 10, 1, 3, 15, 4, 5);
    Examples coolClass = new Examples();
    System.out.println(coolClass.sayHello(input));
    System.out.println(coolClass.getTheRightString(8));
    System.out.println(coolClass.quickSort(List.of(5, 12, 14, 1, 10, 3)));
  }
}
