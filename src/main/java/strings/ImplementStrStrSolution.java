package strings;

import common.Solution;
import lombok.Getter;

public class ImplementStrStrSolution extends Solution<Integer> {

  @Getter
  private final String haystack;
  private final String needle;

  public ImplementStrStrSolution(String haystack, String needle) {
    this.haystack = haystack;
    this.needle = needle;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Implement strStr()";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/";
    this.notes = "Return 0 when needle is an empty string";
  }

  @Override
  public Integer solve() {
    if (this.isNullOrEmpty(this.needle) && this.isNullOrEmpty(this.haystack)) {
      return -1;
    }

    if (this.isNullOrEmpty(this.needle)) {
      return 0;
    }

    if (this.needle.equals(this.haystack)) {
      return 0;
    }

    int result = -1;
    int needleLength = this.needle.length();
    for (int i = 0; i <= this.haystack.length() - needleLength; i++) {
      if (this.haystack.substring(i, i + needleLength).equals(this.needle)) {
        result = i;
        break;
      }
    }

    return result;
  }

  private boolean isNullOrEmpty(CharSequence s) {
    return s == null || s.length() == 0;
  }
}