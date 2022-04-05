package strings;

import common.Solution;
import lombok.Getter;

public class LongestCommonPrefixSolution extends Solution<String> {

  @Getter
  private final String[] input;

  public LongestCommonPrefixSolution(String[] input) {
    this.input = input;
  }

  @Override
  protected void initializeSolution() {
      this.title = "Longest Common Prefix";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/";
    this.notes = "If theres is no common prefix, return empty string";
  }

  @Override
  public String solve() {
    if (this.input == null || this.input.length == 0) {
      return "";
    }

    return this.getLongestCommonPrefix(0, this.input.length - 1);
  }

  private String getLongestCommonPrefix(int leftIndex, int rightIndex) {
    if (leftIndex == rightIndex) {
      return this.input[leftIndex];
    }

    int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
    String leftLcp = this.getLongestCommonPrefix(leftIndex, midIndex);
    String rightLcp = this.getLongestCommonPrefix(midIndex + 1, rightIndex);
    return this.getCommonPrefix(leftLcp, rightLcp);
  }

  private String getCommonPrefix(String s, String m) {
    int minLength = Math.min(s.length(), m.length());
    String result = s.substring(0, minLength);

    for (int i = 0; i < minLength; i++) {
      if (s.charAt(i) != m.charAt(i)) {
        result = s.substring(0, i);
        break;
      }
    }

    return result;
  }