package strings;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverseStringSolutionTest {

  private ArrayList<ReverseStringSolution> solutions;
  private ArrayList<char[]> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    solutions.add(
        new ReverseStringSolution(new char[]{'H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd'}));
    expectedResults.add(new char[]{'d', 'l', 'r', 'o', 'W', 'o', 'l', 'l', 'e', 'H'});

    solutions.add(
        new ReverseStringSolution(new char[]{'h', 'e', 'l', 'l', 'o'}));
    expectedResults.add(new char[]{'o', 'l', 'l', 'e', 'h'});

    solutions.add(
        new ReverseStringSolution(new char[]{'H', 'a', 'n', 'n', 'a', 'h'}));
    expectedResults.add(new char[]{'h', 'a', 'n', 'n', 'a', 'H'});
  }

  @Test
  void solveTest() {
    int index = 0;
    for (ReverseStringSolution solution : this.solutions) {
      solution.solve();
      assert compareSolutionResultAndExpectedValues(solution.getInput(),
          this.expectedResults.get(index)) :
          "Test[" + (index + 1) + "] " +
              "Result: " + Arrays.toString(solution.getInput()) + " Expected: " +
              Arrays.toString(this.expectedResults.get(index));
      index++;
    }
  }

  private boolean compareSolutionResultAndExpectedValues(
      char[] solutionResult,
      char[] expectedResult) {

    boolean result = false;

    if (solutionResult.length == expectedResult.length) {
      for (int i = 0; i < expectedResult.length; i++) {
        if (expectedResult[i] != solutionResult[i]) {
          return false;
        }
      }
      result = true;
    }

    return result;
  }
}