package array;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContainsDuplicateSolutionTest {

  private ArrayList<ContainsDuplicateSolution> containsDuplicateSolutionArrayList;
  private ArrayList<Boolean> expectedResults;

  @BeforeEach
  void setUp() {
    containsDuplicateSolutionArrayList = new ArrayList<>();
    expectedResults = new ArrayList<>();

    containsDuplicateSolutionArrayList.add(
        new ContainsDuplicateSolution(new int[]{1, 2, 3, 1}));
    expectedResults.add(true);

    containsDuplicateSolutionArrayList.add(
        new ContainsDuplicateSolution(new int[]{1, 2, 3, 4}));
    expectedResults.add(false);

    containsDuplicateSolutionArrayList.add(
        new ContainsDuplicateSolution(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    expectedResults.add(true);
  }

  @Test
  void solve() {
    int index = 0;
    for (ContainsDuplicateSolution solution : containsDuplicateSolutionArrayList) {
      Boolean result = solution.solve();
      assert result == this.expectedResults.get(index) : "Result: " +
          result + " Expected: " + this.expectedResults.get(index).toString();
      index++;
    }
  }
}