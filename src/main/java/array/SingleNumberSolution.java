package array;

import common.Solution;
import lombok.Getter;

public class SingleNumberSolution extends Solution<Integer> {

  @Getter
  private final int[] input;

  public SingleNumberSolution(int[] input) {
    this.input = input;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Single Number";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/";
    this.notes = "Appears twice, O(N) time complexity, XOR";
  }

  @Override
  public Integer solve() {
    Integer result = this.input[0];

    for (int i = 1; i < this.input.length; i++) {
      result ^= this.input[i];
    }

    return result;
  }
}