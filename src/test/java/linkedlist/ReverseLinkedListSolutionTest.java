package linkedlist;

import common.datastructures.linkedlist.LinkedList;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverseLinkedListSolutionTest {

  private ArrayList<ReverseLinkedListSolution> solutions;
  private ArrayList<LinkedList<Integer>> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    LinkedList<Integer> linkedListTest1 = new LinkedList<>(new Integer[]{1, 2, 3, 4, 5});
    LinkedList<Integer> expectedLinkedListTest1 = new LinkedList<>(new Integer[]{5, 4, 3, 2, 1});

    solutions.add(
        new ReverseLinkedListSolution(linkedListTest1));
    expectedResults.add(expectedLinkedListTest1);

    // Test 2
    LinkedList<Integer> linkedListTest2 = new LinkedList<>();
    LinkedList<Integer> expectedLinkedListTest2 = new LinkedList<>();

    solutions.add(
        new ReverseLinkedListSolution(linkedListTest2));
    expectedResults.add(expectedLinkedListTest2);

    // Test 3
    LinkedList<Integer> linkedListTest3 = new LinkedList<>(new Integer[]{1, 2});
    LinkedList<Integer> expectedLinkedListTest3 = new LinkedList<>(new Integer[]{2, 1});

    solutions.add(
        new ReverseLinkedListSolution(linkedListTest3));
    expectedResults.add(expectedLinkedListTest3);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (ReverseLinkedListSolution solution : this.solutions) {
      solution.solve();
      assert solution.getList().equals(this.expectedResults.get(index)) :
          "Test[" + (index + 1) + "] " +
              "Result: " + solution.getList().toString() + " Expected: " +
              this.expectedResults.get(index).toString();
      index++;
    }
  }
}