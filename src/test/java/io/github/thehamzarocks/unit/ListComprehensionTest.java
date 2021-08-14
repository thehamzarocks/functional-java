package io.github.thehamzarocks.unit;

import io.github.thehamzarocks.ListComprehension;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ListComprehensionTest {

  @Test
  public void testListComprehensionMapsAndFilters() {
    List<Integer> result = ListComprehension.apply(List.of(5,6,8,9,10), x -> x * 2, x -> x % 2 == 0);
    Assert.assertEquals(3, result.size());
    Assert.assertEquals((Integer)12, result.get(0));
    Assert.assertEquals((Integer)16, result.get(1));
    Assert.assertEquals((Integer)20, result.get(2));
  }

}
