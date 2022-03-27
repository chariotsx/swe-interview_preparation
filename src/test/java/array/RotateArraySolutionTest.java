package array;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RotateArraySolutionTest {

  private ArrayList<RotateArraySolution> rotateArraySolutionArrayList;
  private ArrayList<int[]> expectedResults;

  @BeforeEach
  void setUp() {
    rotateArraySolutionArrayList = new ArrayList<>();
    expectedResults = new ArrayList<>();

    rotateArraySolutionArrayList.add(
        new RotateArraySolution(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
    expectedResults.add(new int[]{5, 6, 7, 1, 2, 3, 4});

    rotateArraySolutionArrayList.add(
        new RotateArraySolution(new int[]{-1, -100, 3, 99}, 2));
    expectedResults.add(new int[]{3, 99, -1, -100});

    rotateArraySolutionArrayList.add(
        new RotateArraySolution(new int[]{0, 1, 2, 3}, 4));
    expectedResults.add(new int[]{0, 1, 2, 3});
  }

  @Test
  void solveTest() {
    int index = 0;
    for (RotateArraySolution solution : rotateArraySolutionArrayList) {
      solution.solve();
      assert this.compareSolutionResultAndExpectedValues(solution.getInput(),
          expectedResults.get(index++)) : Arrays.toString(solution.getInput());
    }
  }

  @Test
  void solve2Test() {
    int index = 0;
    for (RotateArraySolution solution : rotateArraySolutionArrayList) {
      solution.solve2();
      assert this.compareSolutionResultAndExpectedValues(solution.getInput(),
          expectedResults.get(index++)) : Arrays.toString(solution.getInput());
    }
  }

  private boolean compareSolutionResultAndExpectedValues(
      int[] solutionArray,
      int[] expectedArray) {

    boolean result = false;

    for (int i = 0; i < expectedArray.length; i++) {
      if (expectedArray[i] != solutionArray[i]) {
        return false;
      }

      result = true;
    }

    return result;
  }
}