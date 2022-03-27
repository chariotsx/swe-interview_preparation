package array;

import common.Solution;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

public class TwoSumSolution extends Solution<int[]> {

  @Getter
  private final int[] input;
  private final int target;

  public TwoSumSolution(int[] input, int target) {
    this.input = input;
    this.target = target;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Move Zeroes";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/";
    this.notes = "Less than O(n^2) time complexity";
  }

  @Override
  public int[] solve() {
    int[] result = new int[2];
    Map<Integer, Integer> hashMap = new HashMap<>();

    for (int i = 0; i < this.input.length; i++) {
      int complement = this.target - this.input[i];

      if (hashMap.containsKey(complement)) {
        result[0] = i;
        result[1] = hashMap.get(complement);
        break;
      }

      hashMap.putIfAbsent(this.input[i], i);
    }

    return result;
  }
}
