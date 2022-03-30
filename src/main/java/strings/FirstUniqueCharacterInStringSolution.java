package strings;

import common.Solution;
import lombok.Getter;

public class FirstUniqueCharacterInStringSolution extends Solution<Integer> {

  @Getter
  private final String input;

  public FirstUniqueCharacterInStringSolution(String input) {
    this.input = input;
  }

  @Override
  protected void initializeSolution() {
    this.title = "First Unique Character in a String";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/";
    this.notes = "";
  }

  @Override
  public Integer solve() {
    int bucketLength = 'z' - 'a' + 1; // Only lowercase English letters
    int[] bucket = new int[bucketLength];

    for (char c : this.input.toCharArray()) {
      bucket[c - 'a'] += 1;
    }

    int index = 0;
    for (char c : this.input.toCharArray()) {
      if (bucket[c - 'a'] == 1) {
        return index;
      }
      index++;
    }

    return -1;
  }
}