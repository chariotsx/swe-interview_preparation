package trees;

import common.datastructures.tree.Tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeLevelOrderTraversalSolutionTest {

  private ArrayList<BinaryTreeLevelOrderTraversalSolution> solutions;
  private ArrayList<List<List<Integer>>> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    Tree<Integer> treeTest1 = new Tree<>(new Integer[]{3, 9, 20, null, null, 15, 7});
    List<List<Integer>> expectedResultTest1 = new ArrayList<>();
    expectedResultTest1.add(Arrays.asList(3));
    expectedResultTest1.add(Arrays.asList(9, 20));
    expectedResultTest1.add(Arrays.asList(15, 7));

    solutions.add(
        new BinaryTreeLevelOrderTraversalSolution(treeTest1));
    expectedResults.add(expectedResultTest1);

    // Test 2
    Tree<Integer> treeTest2 = new Tree<>(new Integer[]{1});
    List<List<Integer>> expectedResultTest2 = new ArrayList<>();
    expectedResultTest2.add(Arrays.asList(1));

    solutions.add(
        new BinaryTreeLevelOrderTraversalSolution(treeTest2));
    expectedResults.add(expectedResultTest2);

    // Test 2
    Tree<Integer> treeTest3 = new Tree<>();
    solutions.add(
        new BinaryTreeLevelOrderTraversalSolution(treeTest3));
    expectedResults.add(new ArrayList<>());
  }

  @Test
  void solveTest() {
    int index = 0;
    for (BinaryTreeLevelOrderTraversalSolution solution : this.solutions) {
      List<List<Integer>> result = solution.solve();
      assert this.compareResult(result, this.expectedResults.get(index)) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index).toString();
      index++;
    }
  }

  private boolean compareResult(List<List<Integer>> list1, List<List<Integer>> list2) {
    if ((list1 == null && list2 != null) ||
        (list1 != null && list2 == null) ||
        list1.size() != list1.size()) {
      return false;
    }

    for (int i = 0; i < list1.size(); i++) {
      if ((list1.get(i) == null && list2.get(i) != null) ||
          (list1.get(i) != null && list2.get(i) == null) ||
          list1.get(i).size() != list1.get(i).size()) {
        return false;
      }

      for (int j = 0; j < list1.get(i).size(); j++) {
        if (list1.get(i).get(j) != list2.get(i).get(j)) {
          return false;
        }
      }
    }

    return true;
  }
}