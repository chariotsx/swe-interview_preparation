package strings;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ImplementStrStrSolutionTest {

  private ArrayList<ImplementStrStrSolution> solutions;
  private ArrayList<Integer> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    solutions.add(
        new ImplementStrStrSolution("abc", "c"));
    expectedResults.add(2);

    solutions.add(
        new ImplementStrStrSolution("hello", "ll"));
    expectedResults.add(2);

    solutions.add(
        new ImplementStrStrSolution("aaaaa", "bba"));
    expectedResults.add(-1);

    solutions.add(
        new ImplementStrStrSolution("aaaaa", ""));
    expectedResults.add(0);

    solutions.add(
        new ImplementStrStrSolution("aaaaa", "aaaaa"));
    expectedResults.add(0);

    solutions.add(
        new ImplementStrStrSolution("", ""));
    expectedResults.add(-1);

    solutions.add(
        new ImplementStrStrSolution(null, ""));
    expectedResults.add(-1);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (ImplementStrStrSolution solution : this.solutions) {
      int result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }
}