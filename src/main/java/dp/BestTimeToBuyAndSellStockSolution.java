package dp;

import common.Solution;
import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStockSolution extends Solution<Integer> {

  private static final Map<Integer, Integer> memoizationMap = new HashMap<>();

  private final int[] prices;

  public BestTimeToBuyAndSellStockSolution(int[] prices) {
    this.prices = prices;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Best Time to Buy and Sell Stock";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/572/";
    this.notes = "Single day to buy and a different one to sell, if not possible, returns zero";
  }

  @Override
  public Integer solve() {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i = 0; i < this.prices.length; i++) {
      minPrice = Math.min(minPrice, this.prices[i]);
      maxProfit = Math.max(maxProfit, this.prices[i] - minPrice);
    }

    return maxProfit;
  }
}