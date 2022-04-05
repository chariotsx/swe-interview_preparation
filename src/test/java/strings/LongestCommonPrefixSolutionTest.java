package strings;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LongestCommonPrefixSolutionTest {

  private ArrayList<LongestCommonPrefixSolution> solutions;
  private ArrayList<String> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    solutions.add(
        new LongestCommonPrefixSolution(new String[] {
            "flower", "flow", "flight"
        }));
    expectedResults.add("fl");

    solutions.add(
        new LongestCommonPrefixSolution(new String[] {
            "dog", "racecar", "car"
        }));
    expectedResults.add("");

    solutions.add(
        new LongestCommonPrefixSolution(new String[] {
            ""
        }));
    expectedResults.add("");
  }

  @Test
  void solveTest() {
    int index = 0;
    for (LongestCommonPrefixSolution solution : this.solutions) {
      String result = solution.solve();
      assert result.equals(this.expectedResults.get(index)) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }
}