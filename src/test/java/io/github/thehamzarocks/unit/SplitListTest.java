package io.github.thehamzarocks.unit;


import io.github.thehamzarocks.SplitList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.ArrayList;
import java.util.List;

public class SplitListTest {

  @Test
  public void testSplitWorksOnListWithMultipleElements() {
    List<Integer> inputList = List.of(5, 3, 14, 10, 13, 8, 9);
    SplitList<Integer> splitList = SplitList.of(inputList);
    Assert.assertEquals((Integer)5, splitList.head);
    Assert.assertEquals(6, splitList.rest.size());
  }

  @Test
  public void testSplitWorksOnListWithOneElement() {
    List<Integer> inputList = List.of(5);
    SplitList<Integer> splitList = SplitList.of(inputList);
    Assert.assertEquals((Integer)5, splitList.head);
    Assert.assertEquals(0, splitList.rest.size());
  }

  @Test(expected = RuntimeException.class)
  public void testSplitThrowsExceptionOnEmptyList() {
    List<Integer> inputList = new ArrayList<>();
    SplitList<Integer> splitList = SplitList.of(inputList);
  }


}
