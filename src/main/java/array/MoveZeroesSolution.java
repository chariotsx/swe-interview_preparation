package array;

import common.Solution;
import lombok.Getter;

public class MoveZeroesSolution extends Solution<int[]> {

  @Getter
  private final int[] input;

  public MoveZeroesSolution(int[] input) {
    this.input = input;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Move Zeroes";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/";
    this.notes = "In-place";
  }

  @Override
  public int[] solve() {
    int nonZeroIndex = 0, zeroIndex = 0;

    while (nonZeroIndex < this.input.length && zeroIndex < this.input.length) {
      if (this.input[nonZeroIndex] != 0 &&
          this.input[zeroIndex] == 0 &&
          zeroIndex < nonZeroIndex) { // Only swap them when we have a zero before a non-zero number
        // Swapping elements
        int temp = this.input[zeroIndex];
        this.input[zeroIndex] = this.input[nonZeroIndex];
        this.input[nonZeroIndex] = temp;
      } else if (zeroIndex
          > nonZeroIndex) { // It means all elements before zeroIndex are non-zero numbers
        nonZeroIndex = zeroIndex;
      } else if (this.input[zeroIndex] != 0) {
        zeroIndex++;
      } else if (this.input[nonZeroIndex] == 0) {
        nonZeroIndex++;
      }
    }
    // Exiting this loop means that all remaining elements are either zero or non-zero

    return this.input;
  }

  public int[] solve2() {
    int nonZeroIndex = 0;

    for (int i = 0; i < this.input.length && nonZeroIndex < this.input.length; i++) {
      if (this.input[i] != 0) {
        if (i != nonZeroIndex) { // Swap when it should be swapped
          // Swapping elements
          int temp = this.input[i];
          this.input[i] = this.input[nonZeroIndex];
          this.input[nonZeroIndex] = temp;
        }

        // All elements between nonZeroIndex and i are zeros
        nonZeroIndex++;
      }
    }
    return this.input;
  }
}
