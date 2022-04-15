package trees;

import common.datastructures.tree.Tree;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedArrayToBSTSolutionTest {

  private ArrayList<SortedArrayToBSTSolution> solutions;
  private ArrayList<Tree<Integer>> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    solutions.add(
        new SortedArrayToBSTSolution(new Integer[]{-10, -3, 0, 5, 9}));
    Tree<Integer> expectedResultTest1 = new Tree<>(new Integer[]{0, -10, 5, null, -3, null, 9});
    expectedResults.add(expectedResultTest1);

    // Test 2
    solutions.add(
        new SortedArrayToBSTSolution(new Integer[]{1, 3}));
    Tree<Integer> expectedResultTest2 = new Tree<>(new Integer[]{1, null, 3});
    expectedResults.add(expectedResultTest2);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (SortedArrayToBSTSolution solution : this.solutions) {
      Tree<Integer> result = solution.solve();
      assert result.equals(this.expectedResults.get(index)) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index).toString();
      index++;
    }
  }
}