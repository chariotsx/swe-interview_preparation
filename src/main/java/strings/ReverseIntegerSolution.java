package strings;

import common.Solution;
import lombok.Getter;

public class ReverseIntegerSolution extends Solution<Integer> {

  private static final int LAST_DIGIT_MIN_VALUE = Integer.MIN_VALUE % 10;
  private static final int LAST_DIGIT_MAX_VALUE = Integer.MAX_VALUE % 10;

  @Getter
  private final int input;

  public ReverseIntegerSolution(int input) {
    this.input = input;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Reverse Integer";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/";
    this.notes = "Signed 32-bit integer";
  }

  @Override
  public Integer solve() {
    int temp = this.input;
    int result = 0;

    // 123 -> 321
    // We can use the concept of a list to use operations like push and pop within an integer
    while (temp != 0) {
      // Pop digit from input
      int digit = temp % 10;
      temp /= 10;

      // - Push to result
      // - Before multiplying we should ensure that won't be overflowed
      // - Corner case when we have exact same numbers of MAX_VALUE, in this case only will be
      //   overflowed if digit is greater than last digit of MAX_VALUE or lesser than last digit
      //   of MIN_VALUE
      if (result > Integer.MAX_VALUE / 10 ||
          (result == Integer.MAX_VALUE / 10 && digit > LAST_DIGIT_MAX_VALUE)) {
        return 0;
      }
      if (result < Integer.MIN_VALUE / 10 ||
          (result == Integer.MIN_VALUE / 10 && digit < LAST_DIGIT_MIN_VALUE)) {
        return 0;
      }

      // Push last digit in a safe way
      result = result * 10 + digit;
    }

    return result;
  }
}