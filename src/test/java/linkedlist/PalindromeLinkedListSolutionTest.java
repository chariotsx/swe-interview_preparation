package linkedlist;

import common.datastructures.linkedlist.LinkedList;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PalindromeLinkedListSolutionTest {

  private ArrayList<PalindromeLinkedListSolution> solutions;
  private ArrayList<Boolean> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    LinkedList<Integer> linkedListTest1 = new LinkedList<>(new Integer[]{1, 2, 2, 1});
    solutions.add(
        new PalindromeLinkedListSolution(linkedListTest1));
    expectedResults.add(true);

    // Test 2
    LinkedList<Integer> linkedListTest2 = new LinkedList<>(new Integer[]{1, 2});
    solutions.add(
        new PalindromeLinkedListSolution(linkedListTest2));
    expectedResults.add(false);

    // Test 3
    LinkedList<Integer> linkedListTest3 = new LinkedList<>();
    solutions.add(
        new PalindromeLinkedListSolution(linkedListTest3));
    expectedResults.add(true);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (PalindromeLinkedListSolution solution : this.solutions) {
      boolean result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index).toString();
      index++;
    }
  }
}