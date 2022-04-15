package sortingandsearching;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeSortedArraySolutionTest {

  private ArrayList<MergeSortedArraySolution> solutions;
  private ArrayList<Integer[]> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    Integer[] array1Test1 = new Integer[]{1, 2, 3, 0, 0, 0};
    Integer[] array2Test1 = new Integer[]{2, 5, 6};
    solutions.add(
        new MergeSortedArraySolution(array1Test1, array2Test1, 3, 3));
    expectedResults.add(new Integer[]{1, 2, 2, 3, 5, 6});

    // Test 2
    Integer[] array1Test2 = new Integer[]{1};
    Integer[] array2Test2 = new Integer[]{};
    solutions.add(
        new MergeSortedArraySolution(array1Test2, array2Test2, 1, 0));
    expectedResults.add(new Integer[]{1});

    // Test 3
    Integer[] array1Test3 = new Integer[]{0};
    Integer[] array2Test3 = new Integer[]{1};
    solutions.add(
        new MergeSortedArraySolution(array1Test3, array2Test3, 0, 1));
    expectedResults.add(new Integer[]{1});

    // Test 4
    Integer[] array1Test4 = new Integer[]{4, 5, 6, 0, 0, 0};
    Integer[] array2Test4 = new Integer[]{1, 2, 3};
    solutions.add(
        new MergeSortedArraySolution(array1Test4, array2Test4, 3, 3));
    expectedResults.add(new Integer[]{1, 2, 3, 4, 5, 6});
  }

  @Test
  void solveTest() {
    int index = 0;
    for (MergeSortedArraySolution solution : this.solutions) {
      solution.solve();
      assert Arrays.equals(solution.getNums1(), this.expectedResults.get(index)) :
          "Test[" + (index + 1) + "] " +
              "Result: " + Arrays.toString(solution.getNums1()) + " Expected: " +
              Arrays.toString(this.expectedResults.get(index));
      index++;
    }
  }
}