package linkedlist;

import common.datastructures.linkedlist.LinkedList;
import common.datastructures.linkedlist.LinkedListNode;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteNodeLinkedListSolutionTest {

  private ArrayList<DeleteNodeLinkedListSolution> solutions;
  private ArrayList<LinkedList<Integer>> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    LinkedList<Integer> linkedListTest1 = new LinkedList<>();
    linkedListTest1.AddArray(new Integer[]{1, 2, 3, 4, 5});
    LinkedListNode<Integer> nodeToDeleteTest1 = linkedListTest1.GetNodeAt(3);

    LinkedList<Integer> expectedLinkedListTest1 = new LinkedList<>();
    expectedLinkedListTest1.AddArray(new Integer[]{1, 2, 3, 5});

    solutions.add(
        new DeleteNodeLinkedListSolution(linkedListTest1, nodeToDeleteTest1));
    expectedResults.add(expectedLinkedListTest1);

    // Test 2
    LinkedList<Integer> linkedListTest2 = new LinkedList<>();
    linkedListTest2.AddArray(new Integer[]{4, 5, 1, 9});
    LinkedListNode<Integer> nodeToDeleteTest2 = linkedListTest2.GetNodeAt(1);

    LinkedList<Integer> expectedLinkedListTest2 = new LinkedList<>();
    expectedLinkedListTest2.AddArray(new Integer[]{4, 1, 9});

    solutions.add(
        new DeleteNodeLinkedListSolution(linkedListTest2, nodeToDeleteTest2));
    expectedResults.add(expectedLinkedListTest2);

    // Test 3
    LinkedList<Integer> linkedListTest3 = new LinkedList<>();
    linkedListTest3.AddArray(new Integer[]{4, 5, 1, 9});
    LinkedListNode<Integer> nodeToDeleteTest3 = linkedListTest3.GetNodeAt(2);

    LinkedList<Integer> expectedLinkedListTest3 = new LinkedList<>();
    expectedLinkedListTest3.AddArray(new Integer[]{4, 5, 9});

    solutions.add(
        new DeleteNodeLinkedListSolution(linkedListTest3, nodeToDeleteTest3));
    expectedResults.add(expectedLinkedListTest3);
  }

  @Test
  void solve() {
    int index = 0;
    for (DeleteNodeLinkedListSolution solution : this.solutions) {
      solution.solve();
      assert solution.getList().equals(this.expectedResults.get(index)) :
          "Test[" + (index + 1) + "] " +
              "Result: " + solution.getList().toString() + " Expected: " +
              this.expectedResults.get(index).toString();
      index++;
    }
  }
}