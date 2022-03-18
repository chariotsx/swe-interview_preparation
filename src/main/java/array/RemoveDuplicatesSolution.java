package array;

import common.Solution;
import lombok.Getter;

public class RemoveDuplicatesSolution extends Solution<Integer> {

  @Getter
  private final int[] input;

  public RemoveDuplicatesSolution(int[] input) {
    this.input = input;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Remove Duplicates from Sorted Array";
    this.url = "https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/";
    this.notes = "In-place";
  }

  @Override
  public Integer solve() {

    if (this.input == null) {
      return 0;
    }

    if (this.input.length <= 1) {
      return this.input.length;
    }

    int i = 0, j = 1;
    int currentValue = this.input[0];

    while (i < this.input.length) {
      while (j < this.input.length && this.input[j] == currentValue) {
        j++;
      }

      if (j >= this.input.length) {
        break;
      }

      i++;
      this.input[i] = this.input[j];
      currentValue = this.input[j];
    }

    return i + 1;
  }
}
