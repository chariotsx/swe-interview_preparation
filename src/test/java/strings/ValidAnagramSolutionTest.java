package strings;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidAnagramSolutionTest {

  private ArrayList<ValidAnagramSolution> solutions;
  private ArrayList<Boolean> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    solutions.add(
        new ValidAnagramSolution("anagram", "nagaram"));
    expectedResults.add(true);

    solutions.add(
        new ValidAnagramSolution("rat", "car"));
    expectedResults.add(false);

    solutions.add(
        new ValidAnagramSolution("a", "ab"));
    expectedResults.add(false);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (ValidAnagramSolution solution : this.solutions) {
      boolean result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }
}