package dp;

import common.Solution;
import lombok.Getter;

@Getter
public class HouseRobberSolution extends Solution<Integer> {

  private final int[] nums;

  public HouseRobberSolution(int[] nums) {
    this.nums = nums;
  }

  @Override
  protected void initializeSolution() {
    this.title = "House Robber";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/576/";
    this.notes = "Bottom-up: MaxAmountRobbed[position] = Max(nums[i] + maxRobbedAmount[i - 2], maxRobbedAmount[position - 1])";
  }

  @Override
  public Integer solve() {
    int[] maxRobbedAmount = new int[this.nums.length];
    maxRobbedAmount[0] = this.nums[0];

    for (int i = 1; i < this.nums.length; i++) {
      if (i == 1) {
        maxRobbedAmount[i] = Math.max(this.nums[i], maxRobbedAmount[i - 1]);
      } else {
        maxRobbedAmount[i] = Math.max(this.nums[i] + maxRobbedAmount[i - 2],
            maxRobbedAmount[i - 1]);
      }
    }

    return maxRobbedAmount[this.nums.length - 1];
  }
}