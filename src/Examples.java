import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarOutputStream;
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

  public static int sum(List<Integer> inputList) {
    return Guard.<Integer>initializeGuard()
            .guard(inputList.size() == 0, () -> 0)
            .guard(Guard.OtherwiseGuard, () -> SplitList.of(inputList).head + sum(SplitList.of(inputList).rest))
            .getValue();
  }

  public static void main(String[] args) {
    List<Integer> input = List.of(5, 12, 10, 1, 3, 15, 4, 5);
    Examples coolClass = new Examples();
    System.out.println(coolClass.sayHello(input));
    System.out.println(coolClass.getTheRightString(8));
    System.out.println(Quicksort.quickSort(List.of(5, 12, 14, 1, 10, 3)));
    System.out.println(sum(input));
  }
}
