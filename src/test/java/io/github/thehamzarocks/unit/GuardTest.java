package io.github.thehamzarocks.unit;


import io.github.thehamzarocks.Guard;
import org.junit.Assert;
import org.junit.Test;

public class GuardTest {

  @Test
  public void testGuardReturnsFirstMatchingCondition() {
    int value = Guard.<Integer>initializeGuard()
            .guard(false, () -> 0)
            .guard(5 == 7, () -> 1)
            .guard(true, () -> 2)
            .guard(true, () -> 3)
            .getValue();

    Assert.assertEquals(2, value);
  }

  @Test
  public void testOtherwiseGuardMatchesIfReached() {
    int lastConditionMatches = Guard.<Integer>initializeGuard()
            .guard(false, () -> 0)
            .guard(5 == 7, () -> 1)
            .guard(Guard.OtherwiseGuard, () -> 2)
            .getValue();

    int someConditionMatches = Guard.<Integer>initializeGuard()
            .guard(false, () -> 0)
            .guard(Guard.OtherwiseGuard, () -> 1)
            .guard(true, () -> 2)
            .getValue();
    Assert.assertEquals(lastConditionMatches, 2);
    Assert.assertEquals(someConditionMatches, 1);
  }

  @Test(expected = RuntimeException.class)
  public void testGuardThrowsExceptionIfNoConditionMatches() {
    int value = Guard.<Integer>initializeGuard()
            .guard(false, () -> 0)
            .guard(5 == 7, () -> 1)
            .guard(false, () -> 2)
            .getValue();
  }

}
