package strings;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidPalindromeSolutionTest {

  private ArrayList<ValidPalindromeSolution> solutions;
  private ArrayList<Boolean> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    solutions.add(
        new ValidPalindromeSolution("A man, a plan, a canal: Panama"));
    expectedResults.add(true);

    solutions.add(
        new ValidPalindromeSolution("race a car"));
    expectedResults.add(false);

    solutions.add(
        new ValidPalindromeSolution(" "));
    expectedResults.add(true);

    solutions.add(
        new ValidPalindromeSolution(" a"));
    expectedResults.add(true);

    solutions.add(
        new ValidPalindromeSolution("b"));
    expectedResults.add(true);

    solutions.add(
        new ValidPalindromeSolution("0P"));
    expectedResults.add(false);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (ValidPalindromeSolution solution : this.solutions) {
      boolean result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }
}