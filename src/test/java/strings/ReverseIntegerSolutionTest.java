package strings;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ReverseIntegerSolutionTest {

  private ArrayList<ReverseIntegerSolution> solutions;
  private ArrayList<Integer> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    solutions.add(
        new ReverseIntegerSolution(123));
    expectedResults.add(321);

    solutions.add(
        new ReverseIntegerSolution(-123));
    expectedResults.add(-321);

    solutions.add(
        new ReverseIntegerSolution(2147483646));
    expectedResults.add(0);

    solutions.add(
        new ReverseIntegerSolution(1463847412));
    expectedResults.add(2147483641);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (ReverseIntegerSolution solution : this.solutions) {
      int result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }

  @ParameterizedTest
  @ValueSource(ints = {2})
  void solveTest(int numTest) {
    int result = this.solutions.get(numTest - 1).solve();
    assert result == this.expectedResults.get(numTest - 1) :
        "Test[" + (numTest) + "] " +
            "Result: " + result + " Expected: " +
            this.expectedResults.get(numTest - 1);
  }
}