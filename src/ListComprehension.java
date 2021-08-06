import java.util.List;
import java.util.stream.Collectors;

public class ListComprehension {

  public interface ListComprehensionMapExpression<S, T> {
    public T listComprehensionMapExpression(S val);
  }

  public interface ListComprehensionFilterExpression<T> {
    public boolean listComprehensionFilterExpression(T val);
  }

  static <S, T> List<T> doListComprehension(
      ListComprehensionMapExpression<S, T> listComprehensionExpression,
      List<S> inputList,
      ListComprehensionFilterExpression<S> listComprehensionFilterExpression) {
    return inputList.stream()
        .filter(x -> listComprehensionFilterExpression.listComprehensionFilterExpression(x))
        .map(x -> listComprehensionExpression.listComprehensionMapExpression((x)))
        .collect(Collectors.toList());
  }
}
