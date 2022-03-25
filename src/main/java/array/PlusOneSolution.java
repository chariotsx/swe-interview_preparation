package array;

import common.Solution;
import lombok.Getter;

public class PlusOneSolution extends Solution<int[]> {

  @Getter
  private final int[] input;

  public PlusOneSolution(int[] input) {
    this.input = input;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Plus One";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/";
    this.notes = "";
  }

  @Override
  public int[] solve() {
    int[] result;

    int carry = 1;
    for (int i = this.input.length - 1; i >= 0; i--) {
      this.input[i] += carry;
      carry = this.input[i] > 9 ? 1 : 0;
      this.input[i] %= 10;
    }

    if (carry > 0) {
      result = new int[this.input.length + 1];
      result[0] = 1;
      for (int i = 1; i < result.length; i++) {
        result[i] = this.input[i - 1];
      }
    } else {
      result = this.input;
    }

    return result;
  }
}