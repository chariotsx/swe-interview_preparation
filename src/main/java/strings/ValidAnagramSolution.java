package strings;

import common.Solution;
import lombok.Getter;

public class ValidAnagramSolution extends Solution<Boolean> {

  @Getter
  private final String input1;
  private final String input2;

  public ValidAnagramSolution(String input1, String input2) {
    this.input1 = input1;
    this.input2 = input2;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Valid Anagram";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/";
    this.notes = "";
  }

  @Override
  public Boolean solve() {
    if (this.input1.length() != this.input2.length()) {
      return false;
    }

    int bucketLength = 'z' - 'a' + 1;
    int[] bucket = new int[bucketLength];

    for (int i = 0; i < this.input1.length(); i++) {
      bucket[this.input1.charAt(i) - 'a']++;
      bucket[this.input2.charAt(i) - 'a']--;
    }

    for (int b : bucket) {
      if (b != 0) {
        return false;
      }
    }

    return true;
  }
}