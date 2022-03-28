package array;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidSudokuSolutionTest {

  private ArrayList<ValidSudokuSolution> solutions;
  private ArrayList<Boolean> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    solutions.add(
        new ValidSudokuSolution(new char[][] {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    expectedResults.add(true);

    solutions.add(
        new ValidSudokuSolution(new char[][] {
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    expectedResults.add(false);

    solutions.add(
        new ValidSudokuSolution(new char[][] {
            {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
            {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
            {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
            {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
            {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
            {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
            {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        }));
    expectedResults.add(false);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (ValidSudokuSolution solution : this.solutions) {
      boolean resultSolution = solution.solve();
      assert resultSolution == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + resultSolution + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }

  @ParameterizedTest
  @ValueSource(ints = {3})
    // Number of test
  void solveTest(int numTest) {
    boolean resultSolution = this.solutions.get(numTest - 1).solve();
    assert resultSolution == this.expectedResults.get(numTest - 1) :
        "Test[" + (numTest) + "] " +
            "Result: " + resultSolution + " Expected: " +
            this.expectedResults.get(numTest - 1);
  }

  @Test
  void solve2Test() {
    int index = 0;
    for (ValidSudokuSolution solution : this.solutions) {
      boolean resultSolution = solution.solve2();
      assert resultSolution == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + resultSolution + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }
}