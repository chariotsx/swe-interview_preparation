package linkedlist;

import common.datastructures.linkedlist.LinkedList;
import common.datastructures.linkedlist.LinkedListNode;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListCycleSolutionTest {

  private ArrayList<LinkedListCycleSolution> solutions;
  private ArrayList<Boolean> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    LinkedList<Integer> linkedListTest1 = new LinkedList<>(new Integer[]{3, 2, 0, -4});
    LinkedListNode<Integer> cycleNode = linkedListTest1.getHeadNode();
    int pos = 1;
    while (pos-- > 0) {
      cycleNode = cycleNode.getNextNode();
    }
    linkedListTest1.getTail().setNextNode(cycleNode);
    solutions.add(
        new LinkedListCycleSolution(linkedListTest1));
    expectedResults.add(true);

    // Test 2
    LinkedList<Integer> linkedListTest2 = new LinkedList<>(new Integer[]{1, 2});
    cycleNode = linkedListTest2.getHeadNode();
    pos = 0;
    while (pos-- > 0) {
      cycleNode = cycleNode.getNextNode();
    }
    linkedListTest2.getTail().setNextNode(cycleNode);
    solutions.add(
        new LinkedListCycleSolution(linkedListTest2));
    expectedResults.add(true);

    // Test 3
    LinkedList<Integer> linkedListTest3 = new LinkedList<>(new Integer[]{1});
    solutions.add(
        new LinkedListCycleSolution(linkedListTest3));
    expectedResults.add(false);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (LinkedListCycleSolution solution : this.solutions) {
      boolean result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index).toString();
      index++;
    }
  }
}