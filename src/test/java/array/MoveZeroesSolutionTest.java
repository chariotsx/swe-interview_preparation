package array;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoveZeroesSolutionTest {

  private ArrayList<MoveZeroesSolution> solutions;
  private ArrayList<int[]> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    solutions.add(
        new MoveZeroesSolution(new int[]{0, 1, 0, 3, 12}));
    expectedResults.add(new int[]{1, 3, 12, 0, 0});

    solutions.add(
        new MoveZeroesSolution(new int[]{0}));
    expectedResults.add(new int[]{0});

    solutions.add(
        new MoveZeroesSolution(new int[]{0, 0, 0, 0, 1, 1, 1, 1}));
    expectedResults.add(new int[]{1, 1, 1, 1, 0, 0, 0, 0});

    solutions.add(
        new MoveZeroesSolution(new int[]{-12, 2, 0, 3, 0, 2, 1}));
    expectedResults.add(new int[]{-12, 2, 3, 2, 1, 0, 0});

    solutions.add(
        new MoveZeroesSolution(new int[]{1, 0}));
    expectedResults.add(new int[]{1, 0});

    solutions.add(
        new MoveZeroesSolution(new int[]{0, 1}));
    expectedResults.add(new int[]{1, 0});
  }

  @Test
  void solveTest() {
    int index = 0;
    for (MoveZeroesSolution solution : this.solutions) {
      int[] resultSolution = solution.solve();
      assert this.compareSolutionResultAndExpectedValues(resultSolution,
          this.expectedResults.get(index)) :
          "Result: " + Arrays.toString(resultSolution) + " Expected: " +
              Arrays.toString(this.expectedResults.get(index));
      index++;
    }
  }

  @Test
  void solve2Test() {
    int index = 0;
    for (MoveZeroesSolution solution : this.solutions) {
      int[] resultSolution = solution.solve2();
      assert this.compareSolutionResultAndExpectedValues(resultSolution,
          this.expectedResults.get(index)) :
          "Result: " + Arrays.toString(resultSolution) + " Expected: " +
              Arrays.toString(this.expectedResults.get(index));
      index++;
    }
  }

  @ParameterizedTest
  @ValueSource(ints = {3})
    // Number of test
  void solveTest(int numTest) {
    int[] resultSolution = solutions.get(numTest).solve();
    assert this.compareSolutionResultAndExpectedValues(resultSolution,
        this.expectedResults.get(numTest)) :
        "Result: " + Arrays.toString(resultSolution) + " Expected: " +
            Arrays.toString(this.expectedResults.get(numTest));
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