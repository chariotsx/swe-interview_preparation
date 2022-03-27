package array;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlusOneSolutionTest {

  private ArrayList<PlusOneSolution> plusOneSolutionArrayList;
  private ArrayList<int[]> expectedResults;

  @BeforeEach
  void setUp() {
    plusOneSolutionArrayList = new ArrayList<>();
    expectedResults = new ArrayList<>();

    plusOneSolutionArrayList.add(
        new PlusOneSolution(new int[]{1, 2, 2, 1}));
    expectedResults.add(new int[]{1, 2, 2, 2});

    plusOneSolutionArrayList.add(
        new PlusOneSolution(new int[]{9, 9, 9}));
    expectedResults.add(new int[]{1, 0, 0, 0});

    plusOneSolutionArrayList.add(
        new PlusOneSolution(new int[]{7, 6, 4, 3, 1}));
    expectedResults.add(new int[] {7, 6, 4, 3, 2});

    plusOneSolutionArrayList.add(
        new PlusOneSolution(new int[]{9}));
    expectedResults.add(new int[] {1, 0});
  }

  @Test
  void solveTest() {
    int index = 0;
    for (PlusOneSolution solution : plusOneSolutionArrayList) {
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
          return false;
        }
      }

      result = true;
    }

    return result;
  }
}