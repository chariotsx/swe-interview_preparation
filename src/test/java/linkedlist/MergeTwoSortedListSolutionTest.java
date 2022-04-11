package linkedlist;

import common.datastructures.linkedlist.LinkedList;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeTwoSortedListSolutionTest {

  private ArrayList<MergeTwoSortedListSolution> solutions;
  private ArrayList<LinkedList<Integer>> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    LinkedList<Integer> linkedList1Test1 = new LinkedList<>(new Integer[]{1, 2, 3});
    LinkedList<Integer> linkedList2Test1 = new LinkedList<>(new Integer[]{4, 5});
    LinkedList<Integer> expectedLinkedListTest1 = new LinkedList<>(new Integer[]{1, 2, 3, 4, 5});

    solutions.add(
        new MergeTwoSortedListSolution(linkedList1Test1, linkedList2Test1));
    expectedResults.add(expectedLinkedListTest1);

    // Test 2
    LinkedList<Integer> linkedList1Test2 = new LinkedList<>(new Integer[]{1, 2, 4});
    LinkedList<Integer> linkedList2Test2 = new LinkedList<>(new Integer[]{1, 3, 4});
    LinkedList<Integer> expectedLinkedListTest2 = new LinkedList<>(new Integer[]{1, 1, 2, 3, 4, 4});

    solutions.add(
        new MergeTwoSortedListSolution(linkedList1Test2, linkedList2Test2));
    expectedResults.add(expectedLinkedListTest2);

    // Test 2
    LinkedList<Integer> linkedList1Test3 = new LinkedList<>();
    LinkedList<Integer> linkedList2Test3 = new LinkedList<>();
    LinkedList<Integer> expectedLinkedListTest3 = new LinkedList<>();

    solutions.add(
        new MergeTwoSortedListSolution(linkedList1Test3, linkedList2Test3));
    expectedResults.add(expectedLinkedListTest3);

    // Test 4
    LinkedList<Integer> linkedList1Test4 = new LinkedList<>();
    LinkedList<Integer> linkedList2Test4= new LinkedList<>(new Integer[]{0});
    LinkedList<Integer> expectedLinkedListTest4 = new LinkedList<>(new Integer[]{0});

    solutions.add(
        new MergeTwoSortedListSolution(linkedList1Test4, linkedList2Test4));
    expectedResults.add(expectedLinkedListTest4);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (MergeTwoSortedListSolution solution : this.solutions) {
      solution.solve();
      assert solution.getList1().equals(this.expectedResults.get(index)) :
          "Test[" + (index + 1) + "] " +
              "Result: " + solution.getList1().toString() + " Expected: " +
              this.expectedResults.get(index).toString();
      index++;
    }
  }
}