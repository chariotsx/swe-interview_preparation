package dp;

import common.Solution;
import java.util.HashMap;
import java.util.Map;

public class ClimbingStairsSolution extends Solution<Integer> {

  private static final Map<Integer, Integer> memoizationMap = new HashMap<>();

  private final int totalSteps;

  public ClimbingStairsSolution(int totalSteps) {
    this.totalSteps = totalSteps;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Climbing Stairs";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/569/";
    this.notes = "One or two steps";
  }

  @Override
  public Integer solve() {
    return this.getNumberWaysToReachTop_topDown(this.totalSteps);
  }

  public Integer solve2() {
    return this.getNumberWaysToReachTop_bottomUp(this.totalSteps);
  }

  private int getNumberWaysToReachTop_topDown(int totalSteps) {
    if (totalSteps < 0) {
      return 0;
    }
    if (totalSteps == 0) {
      return 1;
    }

    if (!memoizationMap.containsKey(totalSteps)) {
      memoizationMap.put(
          totalSteps,
          this.getNumberWaysToReachTop_topDown(totalSteps - 1) +
              this.getNumberWaysToReachTop_topDown(totalSteps - 2));
    }

    return memoizationMap.get(totalSteps);
  }

  private int getNumberWaysToReachTop_bottomUp(int totalSteps) {
    if (totalSteps <= 2) {
      return totalSteps;
    }

    int prevResult = 1;
    int result = 2;
    for (int i = 3; i <= totalSteps; i++) {
      int temp = result;
      result = result + prevResult;
      prevResult = temp;
    }

    return result;
  }
}