package array;

import common.Solution;
import lombok.Getter;

public class RotateImageSolution extends Solution<Void> {

  @Getter
  private final int[][] input;

  public RotateImageSolution(int[][] input) {
    this.input = input;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Rotate Image";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/";
    this.notes = "In-place";
  }

  @Override
  public Void solve() {
    // length = 4
    // layers = 2
    //     right
    //    0 1 2 4
    // up 1 n n n down
    //    2 n n n
    //    4 n n n
    //      left

    int matrixLength = this.input.length;
    int numLayers = (int) Math.ceil(matrixLength / 2.0);

    for (int i = 0; i < numLayers; i++) {
      for (int j = i; j < matrixLength - i - 1; j++) {
        int temp = this.input[i][j];
        // Move right to top
        this.input[i][j] = this.input[matrixLength - j - 1][i];
        // Move bottom to right
        this.input[matrixLength - j - 1][i] = this.input[matrixLength - i - 1][matrixLength - j - 1];
        // Move left to bottom
        this.input[matrixLength - i - 1][matrixLength - j - 1] = this.input[j][matrixLength - i - 1];
        // Move top to left
        this.input[j][matrixLength - i - 1] = temp;
      }
    }

    return null;
  }
}
