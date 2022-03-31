package strings;

import common.Solution;
import lombok.Getter;

public class ValidPalindromeSolution extends Solution<Boolean> {

  @Getter
  private final String input;

  public ValidPalindromeSolution(String input) {
    this.input = input;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Valid Palindrome";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/";
    this.notes = "";
  }

  @Override
  public Boolean solve() {
    Boolean result = true;
    String lowercaseInput = this.input.toLowerCase();

    int i = 0, j = lowercaseInput.length() - 1;

    while (i < j) {
      if (!this.isValidCharacter(lowercaseInput.charAt(i))) {
        i++;
        continue;
      }

      if (!this.isValidCharacter(lowercaseInput.charAt(j))) {
        j--;
        continue;
      }

      if (lowercaseInput.charAt(i) != lowercaseInput.charAt(j)) {
        result = false;
        break;
      }

      i++;
      j--;
    }

    return result;
  }

  private boolean isValidCharacter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
  }
}