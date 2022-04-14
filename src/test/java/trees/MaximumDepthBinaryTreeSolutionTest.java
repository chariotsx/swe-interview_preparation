package trees;

import common.datastructures.tree.Tree;
import java.util.ArrayList;
import linkedlist.PalindromeLinkedListSolution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaximumDepthBinaryTreeSolutionTest {

  private ArrayList<MaximumDepthBinaryTreeSolution> solutions;
  private ArrayList<Integer> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    Tree<Integer> treeTest1 = new Tree<>(new Integer[]{3, 9, 20, null, null, 15, 7});
    solutions.add(
        new MaximumDepthBinaryTreeSolution(treeTest1));
    expectedResults.add(3);

    // Test 2
    Tree<Integer> treeTest2 = new Tree<>(new Integer[]{1, null, 2});
    solutions.add(
        new MaximumDepthBinaryTreeSolution(treeTest2));
    expectedResults.add(2);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (MaximumDepthBinaryTreeSolution solution : this.solutions) {
      Integer result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index).toString();
      index++;
    }
  }
}