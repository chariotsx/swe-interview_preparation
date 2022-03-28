package array;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RotateImageSolutionTest {

  private ArrayList<RotateImageSolution> solutions;
  private ArrayList<int[][]> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    solutions.add(
        new RotateImageSolution(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }));
    expectedResults.add(new int[][]{
        {7, 4, 1},
        {8, 5, 2},
        {9, 6, 3}
    });

    solutions.add(
        new RotateImageSolution(new int[][]{
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        }));
    expectedResults.add(new int[][]{
        {15, 13, 2, 5},
        {14, 3, 4, 1},
        {12, 6, 8, 9},
        {16, 7, 10, 11}
    });

    solutions.add(
        new RotateImageSolution(new int[][]{
            {5, 1, 9, 11, 1},
            {2, 4, 8, 10, 2},
            {13, 3, 6, 7, 3},
            {15, 14, 12, 16, 4},
            {17, 18, 19, 20, 5}
        }));
    expectedResults.add(new int[][]{
        {17, 15, 13, 2, 5},
        {18, 14, 3, 4, 1},
        {19, 12, 6, 8, 9},
        {20, 16, 7, 10, 11},
        {5, 4, 3, 2, 1}
    });
  }

  @Test
  void solveTest() {
    int index = 0;
    for (RotateImageSolution solution : this.solutions) {
      solution.solve();
      assert compareSolutionResultAndExpectedValues(solution.getInput(),
          this.expectedResults.get(index)) :
          "Test[" + (index + 1) + "] " +
              "Result: " + this.matrixToString(solution.getInput()) + " Expected: " +
              this.matrixToString(this.expectedResults.get(index));
      index++;
    }
  }

  @ParameterizedTest
  @ValueSource(ints = {2})
    // Number of test
  void solve2Test(int numTest) {
    this.solutions.get(numTest - 1).solve();
    assert compareSolutionResultAndExpectedValues(this.solutions.get(numTest - 1).getInput(),
        this.expectedResults.get(numTest - 1)) :
        "Test[" + (numTest) + "] " +
            "Result: " + this.matrixToString(this.solutions.get(numTest - 1).getInput())
            + " Expected: " + this.matrixToString(this.expectedResults.get(numTest - 1));
  }

  private boolean compareSolutionResultAndExpectedValues(
      int[][] solutionResult,
      int[][] expectedResult) {

    boolean result = false;

    if (solutionResult.length == expectedResult.length &&
        solutionResult[0].length == expectedResult[0].length) {
      for (int i = 0; i < expectedResult.length; i++) {
        for (int j = 0; j < expectedResult[0].length; j++) {
          if (expectedResult[i][j] != solutionResult[i][j]) {
            return false;
          }
        }
      }
      result = true;
    }

    return result;
  }

  private String matrixToString(int[][] matrix) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('\n');

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        stringBuilder.append(" " + matrix[i][j]);
      }
      stringBuilder.append('\n');
    }

    return stringBuilder.toString();
  }
}