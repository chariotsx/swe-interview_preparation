package array;

import common.Solution;
import lombok.Getter;

public class RotateArraySolution extends Solution<Void> {

  @Getter
  private final int[] input;
  private final int steps;

  public RotateArraySolution(int[] input, int steps) {
    this.input = input;
    this.steps = steps;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Rotate Array";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/";
    this.notes = "Rotate to right, In-place, constant space";
  }

  @Override
  public Void solve() {
    int finalSteps = this.steps % this.input.length;

    if (finalSteps > 0) {
      for (int step = 0; step < finalSteps; step++) {

        int previousElement = this.input[this.input.length - 1];
        for (int i = 0; i < this.input.length; i++) {
          int temp = this.input[i];
          this.input[i] = previousElement;
          previousElement = temp;
        }
      }
    }

    return null;
  }

  public Void solve2() {
    int finalSteps = this.steps % this.input.length;

    if (finalSteps > 0) {
      this.reverseInput(0, this.input.length - 1);
      this.reverseInput(0, finalSteps - 1);
      this.reverseInput(finalSteps, this.input.length - 1);
    }

    return null;
  }

  private void reverseInput(int start, int end) {
    for (int i = start, j = end; i < j; i++, j--) {
       int temp = this.input[i];
       this.input[i] = this.input[j];
       this.input[j] = temp;
    }
  }
}
