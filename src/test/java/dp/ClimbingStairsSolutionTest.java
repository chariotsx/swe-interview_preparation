package dp;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClimbingStairsSolutionTest {

  private ArrayList<ClimbingStairsSolution> solutions;
  private ArrayList<Integer> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    solutions.add(
        new ClimbingStairsSolution(2));
    expectedResults.add(2);

    // Test 2
    solutions.add(
        new ClimbingStairsSolution(3));
    expectedResults.add(3);

    // Test 3
    solutions.add(
        new ClimbingStairsSolution(10));
    expectedResults.add(89);

    // Test 4
    solutions.add(
        new ClimbingStairsSolution(6));
    expectedResults.add(13);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (ClimbingStairsSolution solution : this.solutions) {
      Integer result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }

  @Test
  void solve2Test() {
    int index = 0;
    for (ClimbingStairsSolution solution : this.solutions) {
      Integer result = solution.solve2();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }
}