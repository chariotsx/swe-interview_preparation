package array;

import common.Solution;
import lombok.Getter;

public class BestTimeToBuyAndSellStockIISolution extends Solution<Integer> {

  @Getter
  private final int[] input;

  public BestTimeToBuyAndSellStockIISolution(int[] input) {
    this.input = input;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Best Time to Buy and Sell Stock II";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/";
    this.notes = "Peaks and valleys, O(n) time and O(1) space complexity";
  }

  @Override
  public Integer solve() {
    int maxProfit = 0;

    for (int i = 1; i < this.input.length; i++) {
      if (this.input[i] > this.input[i - 1]) {
        maxProfit += this.input[i] - this.input[i - 1];
      }
    }

    return maxProfit;
  }
}
