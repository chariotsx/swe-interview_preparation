package dp;

import common.Solution;

public class MaximumSubarraySolution extends Solution<Integer> {

  private final int[] nums;

  public MaximumSubarraySolution(int[] nums) {
    this.nums = nums;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Maximum Subarray";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/566/";
    this.notes = "Bottom-up: MaxSum[position] = Max(MaxSum[position - 1] + nums[position], nums[position])";
  }

  @Override
  public Integer solve() {
    int[] maxSumAtPosition = new int[this.nums.length];
    maxSumAtPosition[0] = this.nums[0];
    int result = maxSumAtPosition[0];

    for (int i = 1; i < this.nums.length; i++) {
      maxSumAtPosition[i] = Math.max(
          maxSumAtPosition[i - 1] + this.nums[i],
          this.nums[i]);

      result = Math.max(result, maxSumAtPosition[i]);
    }

    return result;
  }
}