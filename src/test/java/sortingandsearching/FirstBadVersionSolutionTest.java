package sortingandsearching;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FirstBadVersionSolutionTest {

  private ArrayList<FirstBadVersionSolution> solutions;
  private ArrayList<Integer> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    solutions.add(
        new FirstBadVersionSolution(5, 4));
    expectedResults.add(4);

    // Test 2
    solutions.add(
        new FirstBadVersionSolution(1, 1));
    expectedResults.add(1);

    // Test 3
    solutions.add(
        new FirstBadVersionSolution(9, 4));
    expectedResults.add(4);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (FirstBadVersionSolution solution : this.solutions) {
      Integer result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }
}