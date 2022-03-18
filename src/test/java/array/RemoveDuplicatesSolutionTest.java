package array;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RemoveDuplicatesSolutionTest {

  private ArrayList<RemoveDuplicatesSolution> removeDuplicatesSolutionArrayList;
  private ArrayList<int[]> expectedResults;

  @BeforeEach
  void setUp() {
    removeDuplicatesSolutionArrayList = new ArrayList<>();
    expectedResults = new ArrayList<>();

    removeDuplicatesSolutionArrayList.add(
        new RemoveDuplicatesSolution(new int[]{1, 1, 2}));
    expectedResults.add(new int[]{1, 2});

    removeDuplicatesSolutionArrayList.add(
        new RemoveDuplicatesSolution(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    expectedResults.add(new int[]{0, 1, 2, 3, 4});

    removeDuplicatesSolutionArrayList.add(
        new RemoveDuplicatesSolution(new int[]{0, 0, 0, 0}));
    expectedResults.add(new int[]{0});
  }

  @Test
  void solveTest() {
    int index = 0;
    for (RemoveDuplicatesSolution solution : removeDuplicatesSolutionArrayList) {
      int result = solution.solve();
      assert this.compareSolutionResultAndExpectedValues(solution.getInput(),
          expectedResults.get(index++), result);
    }
  }

  private boolean compareSolutionResultAndExpectedValues(
      int[] solutionArray,
      int[] expectedArray,
      int solutionResult) {

    boolean result = false;

    if (solutionResult == expectedArray.length) {
      for (int i = 0; i < expectedArray.length; i++) {
        if (expectedArray[i] != solutionArray[i]) {
          break;
        }
      }

      result = true;
    }

    return result;
  }
}