package array;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BestTimeToBuyAndSellStockIISolutionTest {

  private ArrayList<BestTimeToBuyAndSellStockIISolution> bestTimeToBuyAndSellStockIISolutionArrayList;
  private ArrayList<Integer> expectedResults;

  @BeforeEach
  void setUp() {
    bestTimeToBuyAndSellStockIISolutionArrayList = new ArrayList<>();
    expectedResults = new ArrayList<>();

    bestTimeToBuyAndSellStockIISolutionArrayList.add(
        new BestTimeToBuyAndSellStockIISolution(new int[]{7, 1, 5, 3, 6, 4}));
    expectedResults.add(7);

    bestTimeToBuyAndSellStockIISolutionArrayList.add(
        new BestTimeToBuyAndSellStockIISolution(new int[]{1, 2, 3, 4, 5}));
    expectedResults.add(4);

    bestTimeToBuyAndSellStockIISolutionArrayList.add(
        new BestTimeToBuyAndSellStockIISolution(new int[]{7, 6, 4, 3, 1}));
    expectedResults.add(0);
  }

  @Test
  void solveTest() {
    int index = 0;
    for (BestTimeToBuyAndSellStockIISolution solution : bestTimeToBuyAndSellStockIISolutionArrayList) {
      int result = solution.solve();
      assert result == this.expectedResults.get(index) : "Result: " +
          result + " Expected: " + this.expectedResults.get(index).toString();
      index++;
    }
  }
}