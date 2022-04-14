package trees;

import common.datastructures.tree.Tree;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidateBinarySearchTreeSolutionTest {

  private ArrayList<ValidateBinarySearchTreeSolution> solutions;
  private ArrayList<Boolean> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    Tree<Integer> treeTest1 = new Tree<>(new Integer[]{2, 1, 3});
    solutions.add(
        new ValidateBinarySearchTreeSolution(treeTest1));
    expectedResults.add(true);

    // Test 2
    Tree<Integer> treeTest2 = new Tree<>(new Integer[]{5, 1, 4, null, null, 3, 6});
    solutions.add(
        new ValidateBinarySearchTreeSolution(treeTest2));
    expectedResults.add(false);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (ValidateBinarySearchTreeSolution solution : this.solutions) {
      boolean result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index).toString();
      index++;
    }
  }
}