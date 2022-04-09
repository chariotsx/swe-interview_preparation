package linkedlist;

import common.datastructures.linkedlist.LinkedList;
import common.datastructures.linkedlist.LinkedListNode;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RemoveNthNodeFromEndListSolutionTest {

  private ArrayList<RemoveNthNodeFromEndListSolution> solutions;
  private ArrayList<LinkedList<Integer>> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    LinkedList<Integer> linkedListTest1 = new LinkedList<>(new Integer[]{1, 2, 3, 4, 5});
    LinkedList<Integer> expectedLinkedListTest1 = new LinkedList<>(new Integer[]{1, 2, 3, 5});

    solutions.add(
        new RemoveNthNodeFromEndListSolution(linkedListTest1, 2));
    expectedResults.add(expectedLinkedListTest1);

    // Test 2
    LinkedList<Integer> linkedListTest2 = new LinkedList<>(new Integer[]{4, 5, 1, 9});
    LinkedList<Integer> expectedLinkedListTest2 = new LinkedList<>(new Integer[]{4, 5, 9});

    solutions.add(
        new RemoveNthNodeFromEndListSolution(linkedListTest2, 2));
    expectedResults.add(expectedLinkedListTest2);

    // Test 3
    LinkedList<Integer> linkedListTest3 = new LinkedList<>(new Integer[]{1});
    LinkedList<Integer> expectedLinkedListTest3 = new LinkedList<>();

    solutions.add(
        new RemoveNthNodeFromEndListSolution(linkedListTest3, 1));
    expectedResults.add(expectedLinkedListTest3);

    // Test 4
    LinkedList<Integer> linkedListTest4 = new LinkedList<>(new Integer[]{1, 2});
    LinkedList<Integer> expectedLinkedListTest4 = new LinkedList<>(new Integer[]{1});

    solutions.add(
        new RemoveNthNodeFromEndListSolution(linkedListTest4, 1));
    expectedResults.add(expectedLinkedListTest4);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (RemoveNthNodeFromEndListSolution solution : this.solutions) {
      solution.solve();
      assert solution.getList().equals(this.expectedResults.get(index)) :
          "Test[" + (index + 1) + "] " +
              "Result: " + solution.getList().toString() + " Expected: " +
              this.expectedResults.get(index).toString();
      index++;
    }
  }

  @Test
  void solve2Test() {
    int index = 0;
    for (RemoveNthNodeFromEndListSolution solution : this.solutions) {
      solution.solve2();
      assert solution.getList().equals(this.expectedResults.get(index)) :
          "Test[" + (index + 1) + "] " +
              "Result: " + solution.getList().toString() + " Expected: " +
              this.expectedResults.get(index).toString();
      index++;
    }
  }
}