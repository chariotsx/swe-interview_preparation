package array;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntersectionOfTwoArraysIISolutionTest {

  private ArrayList<IntersectionOfTwoArraysIISolution> intersectionOfTwoArraysIISolutionArrayList;
  private ArrayList<int[]> expectedResults;

  @BeforeEach
  void setUp() {
    intersectionOfTwoArraysIISolutionArrayList = new ArrayList<>();
    expectedResults = new ArrayList<>();

    intersectionOfTwoArraysIISolutionArrayList.add(
        new IntersectionOfTwoArraysIISolution(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    expectedResults.add(new int[]{2, 2});

    intersectionOfTwoArraysIISolutionArrayList.add(
        new IntersectionOfTwoArraysIISolution(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    expectedResults.add(new int[]{9, 4});

    intersectionOfTwoArraysIISolutionArrayList.add(
        new IntersectionOfTwoArraysIISolution(new int[]{7, 6, 4, 3, 1}, new int[]{2, 2}));
    expectedResults.add(new int[] {});
  }

  @Test
  void solve() {
    int index = 0;
    for (IntersectionOfTwoArraysIISolution solution : intersectionOfTwoArraysIISolutionArrayList) {
      int[] result = solution.solve();
      assert this.compareSolutionResultAndExpectedValues(result, expectedResults.get(index)) :
          "Result: " + Arrays.toString(result) + " Expected: " +
              Arrays.toString(this.expectedResults.get(index));
      index++;
    }
  }

  private boolean compareSolutionResultAndExpectedValues(
      int[] solutionResult,
      int[] expectedResult) {

    boolean result = false;

    if (solutionResult.length == expectedResult.length) {
      for (int i = 0; i < expectedResult.length; i++) {
        if (expectedResult[i] != solutionResult[i]) {
          break;
        }
      }

      result = true;
    }

    return result;
  }
}