package dp;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BestTimeToBuyAndSellStockSolutionTest {

  private ArrayList<BestTimeToBuyAndSellStockSolution> solutions;
  private ArrayList<Integer> expectedResults;

  @BeforeEach
  void setUp() {
    solutions = new ArrayList<>();
    expectedResults = new ArrayList<>();

    // Test 1
    solutions.add(
        new BestTimeToBuyAndSellStockSolution(new int[]{7, 1, 5, 3, 6, 4}));
    expectedResults.add(5);

    // Test 2
    solutions.add(
        new BestTimeToBuyAndSellStockSolution(new int[]{7, 6, 4, 3, 1}));
    expectedResults.add(0);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (BestTimeToBuyAndSellStockSolution solution : this.solutions) {
      Integer result = solution.solve();
      assert result == this.expectedResults.get(index) :
          "Test[" + (index + 1) + "] " +
              "Result: " + result + " Expected: " +
              this.expectedResults.get(index);
      index++;
    }
  }
}