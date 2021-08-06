import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListComprehension {

  static <S, T> List<T> doListComprehension(
      Function<S, T> listComprehensionExpression,
      List<S> inputList,
      Predicate<S> listComprehensionFilterExpression) {
    return inputList.stream()
        .filter(x -> listComprehensionFilterExpression.test(x))
        .map(x -> listComprehensionExpression.apply(x))
        .collect(Collectors.toList());
  }
}
