package dp;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HouseRobberSolutionTest {

  private ArrayList<HouseRobberSolution> solutions;
  private ArrayList<Integer> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    solutions.add(
        new HouseRobberSolution(new int[]{2, 1, 1, 2}));
    expectedResults.add(4);

    // Test 2
    solutions.add(
        new HouseRobberSolution(new int[]{1, 2, 3, 1}));
    expectedResults.add(4);

    // Test 3
    solutions.add(
        new HouseRobberSolution(new int[]{2, 7, 9, 3, 1}));
    expectedResults.add(12);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (HouseRobberSolution solution : this.solutions) {
      Integer result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }
}