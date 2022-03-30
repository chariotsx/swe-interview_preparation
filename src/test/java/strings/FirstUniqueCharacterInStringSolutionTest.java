package strings;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FirstUniqueCharacterInStringSolutionTest {

  private ArrayList<FirstUniqueCharacterInStringSolution> solutions;
  private ArrayList<Integer> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    solutions.add(
        new FirstUniqueCharacterInStringSolution("aabbc"));
    expectedResults.add(4);

    solutions.add(
        new FirstUniqueCharacterInStringSolution("leetcode"));
    expectedResults.add(0);

    solutions.add(
        new FirstUniqueCharacterInStringSolution("loveleetcode"));
    expectedResults.add(2);

    solutions.add(
        new FirstUniqueCharacterInStringSolution("aabb"));
    expectedResults.add(-1);

    solutions.add(
        new FirstUniqueCharacterInStringSolution("a"));
    expectedResults.add(0);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (FirstUniqueCharacterInStringSolution solution : this.solutions) {
      int result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }
}