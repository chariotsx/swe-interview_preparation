package strings;

import common.Solution;
import lombok.Getter;

public class ReverseStringSolution extends Solution<Void> {

  @Getter
  private final char[] input;

  public ReverseStringSolution(char[] input) {
    this.input = input;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Reverse String";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/";
    this.notes = "In-place";
  }

  @Override
  public Void solve() {
    for (int i = 0, j = this.input.length - 1; i < j; i++, j--) {
      char temp = this.input[i];
      this.input[i] = this.input[j];
      this.input[j] = temp;
    }

    return null;
  }
}
