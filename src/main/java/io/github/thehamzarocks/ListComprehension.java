package io.github.thehamzarocks;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/** Provides functions for easy list comprehension */
public class ListComprehension {

  /**
   * Takes an input <code>Collection</code> and lambdas to map and filter, and returns a new
   * collection with the map and filter operations applied. Applies a <i>shallow</i> copy on list
   * elements
   *
   * @param inputList
   * @param listComprehensionExpression
   * @param listComprehensionFilterExpression
   * @param <S>
   * @param <T>
   * @return
   */
  public static <S, T> List<T> apply(
      List<S> inputList,
      Function<S, T> listComprehensionExpression,
      Predicate<S> listComprehensionFilterExpression) {
    return inputList.stream()
        .filter(listComprehensionFilterExpression::test)
        .map(listComprehensionExpression::apply)
        .collect(Collectors.toList());
  }
}
