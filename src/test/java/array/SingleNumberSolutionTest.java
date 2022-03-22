package array;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingleNumberSolutionTest {

  private ArrayList<SingleNumberSolution> singleNumberSolutionArrayList;
  private ArrayList<Integer> expectedResults;

  @BeforeEach
  void setUp() {
    singleNumberSolutionArrayList = new ArrayList<>();
    expectedResults = new ArrayList<>();

    singleNumberSolutionArrayList.add(
        new SingleNumberSolution(new int[]{2, 2, 1}));
    expectedResults.add(1);

    singleNumberSolutionArrayList.add(
        new SingleNumberSolution(new int[]{4, 1, 2, 1, 2}));
    expectedResults.add(4);

    singleNumberSolutionArrayList.add(
        new SingleNumberSolution(new int[]{1}));
    expectedResults.add(1);
  }

  @Test
  void solve() {
    int index = 0;
    for (SingleNumberSolution solution : singleNumberSolutionArrayList) {
      Integer result = solution.solve();
      assert result == this.expectedResults.get(index) : "Result: " +
          result + " Expected: " + this.expectedResults.get(index).toString();
      index++;
    }
  }
}