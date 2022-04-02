package strings;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringToIntegerSolutionTest {

  private ArrayList<StringToIntegerSolution> solutions;
  private ArrayList<Integer> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    solutions.add(
        new StringToIntegerSolution("words and 987"));
    expectedResults.add(0);

    solutions.add(
        new StringToIntegerSolution("12   4"));
    expectedResults.add(12);

    solutions.add(
        new StringToIntegerSolution("12345 567 v"));
    expectedResults.add(12345);

    solutions.add(
        new StringToIntegerSolution("   -42"));
    expectedResults.add(-42);

    solutions.add(
        new StringToIntegerSolution("4193 with words"));
    expectedResults.add(4193);

    solutions.add(
        new StringToIntegerSolution("+-12"));
    expectedResults.add(0);

    solutions.add(
        new StringToIntegerSolution("00000-42a1234"));
    expectedResults.add(0);

    solutions.add(
        new StringToIntegerSolution(Integer.MAX_VALUE + "1"));
    expectedResults.add(Integer.MAX_VALUE);

    solutions.add(
        new StringToIntegerSolution(Integer.MIN_VALUE + "1"));
    expectedResults.add(Integer.MIN_VALUE);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (StringToIntegerSolution solution : this.solutions) {
      int result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }

  @ParameterizedTest
  @ValueSource(ints = {4})
  void solveTest(int numTest) {
    int result = this.solutions.get(numTest - 1).solve();
    assert result == this.expectedResults.get(numTest - 1) :
        "Test[" + (numTest) + "] " +
            "Result: " + result + " Expected: " +
            this.expectedResults.get(numTest - 1);
  }
}