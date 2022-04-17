package dp;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaximumSubarraySolutionTest {

  private ArrayList<MaximumSubarraySolution> solutions;
  private ArrayList<Integer> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    solutions.add(
        new MaximumSubarraySolution(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    expectedResults.add(6);

    // Test 2
    solutions.add(
        new MaximumSubarraySolution(new int[]{1}));
    expectedResults.add(1);

    // Test 3
    solutions.add(
        new MaximumSubarraySolution(new int[]{5, 4, -1, 7, 8}));
    expectedResults.add(23);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (MaximumSubarraySolution solution : this.solutions) {
      Integer result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }
}