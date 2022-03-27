package array;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoSumSolutionTest {

  private ArrayList<TwoSumSolution> solutions;
  private ArrayList<int[]> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    solutions.add(
        new TwoSumSolution(new int[]{2, 7, 11, 15}, 9));
    expectedResults.add(new int[]{0, 1});

    solutions.add(
        new TwoSumSolution(new int[]{3, 2, 4}, 6));
    expectedResults.add(new int[]{1, 2});

    solutions.add(
        new TwoSumSolution(new int[]{3, 3}, 6));
    expectedResults.add(new int[]{0, 1});
  }

  @Test
  void solveTest() {
    int index = 0;
    for (TwoSumSolution solution : this.solutions) {
      int[] resultSolution = solution.solve();
      assert this.compareSolutionResultAndExpectedValues(resultSolution,
          this.expectedResults.get(index)) :
          "Result: " + Arrays.toString(resultSolution) + " Expected: " +
              Arrays.toString(this.expectedResults.get(index));
      index++;
    }
  }

  private boolean compareSolutionResultAndExpectedValues(
      int[] solutionResult,
      int[] expectedResult) {

    boolean result = false;
    Arrays.sort(solutionResult);
    Arrays.sort(expectedResult);

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