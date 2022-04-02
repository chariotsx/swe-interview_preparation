package strings;

import common.Solution;
import lombok.Getter;

public class StringToIntegerSolution extends Solution<Integer> {

  private static final int LAST_DIGIT_MIN_VALUE = Integer.MIN_VALUE % 10;
  private static final int LAST_DIGIT_MAX_VALUE = Integer.MAX_VALUE % 10;

  @Getter
  private final String input;

  public StringToIntegerSolution(String input) {
    this.input = input;
  }

  @Override
  protected void initializeSolution() {
    this.title = "String to Integer (atoi)";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/884/";
    this.notes = "Ignore leading whitespaces, validate signs, remove unnecessary leading zeros, "
        + "within range [-2^31, 2^31 - 1], return MIN_VALUE or MAX_VALUE if input is out of range";
  }

  @Override
  public Integer solve() {
    String stringNumber = this.getValidStringNumber();

    int resultNumber = 0;
    boolean shouldNegativeNumber = false;

    for (int i = 0; i < stringNumber.length(); i++) {
      if (this.isSign(stringNumber.charAt(i))) {
        shouldNegativeNumber = this.isMinusSign(stringNumber.charAt(i));
        continue;
      }

      // Pop digit from string and convert into int
      int digit = (stringNumber.charAt(i) - '0') % 10;

      // First digit to mark with sign
      if (shouldNegativeNumber && digit > 0) {
        digit = -digit;
      }

      // Safe check if we overflow for positive int
      if (resultNumber > Integer.MAX_VALUE / 10 ||
          (resultNumber == Integer.MAX_VALUE / 10 && digit > LAST_DIGIT_MAX_VALUE)) {
        return Integer.MAX_VALUE;
      }

      // Safe check if we overflow for negative int
      if (resultNumber < Integer.MIN_VALUE / 10 ||
          (resultNumber == Integer.MIN_VALUE / 10 && digit < LAST_DIGIT_MIN_VALUE)) {
        return Integer.MIN_VALUE;
      }

      // After validation, we push it to result
      resultNumber = resultNumber * 10 + digit;
    }

    return resultNumber;
  }

  private String getValidStringNumber() {
    StringBuilder number = new StringBuilder(this.input);
    boolean shouldAddSign = true;

    int start = 0;

    // Removing leading whitespaces
    while (start < number.length() &&
        this.isWhitespace(number.charAt(start))) {
      start++;
    }

    // Removing leading zeros
    while (start < number.length() &&
        this.isZero(number.charAt(start))) {
      start++;
      shouldAddSign = false;
    }

    int i;
    for (i = start; i < number.length(); i++) {
      // If it is our first sign we keep it.
      if (this.isSign(number.charAt(i)) && shouldAddSign) {
        shouldAddSign = false;
        continue;
      }

      // Validate char as number, if so, we keep it
      if (!this.isNumber(number.charAt(i))) {
        break;
      }
    }

    return number.substring(start, i);
  }

  private boolean isNumber(char c) {
    return c >= '0' && c <= '9';
  }

  private boolean isSign(char c) {
    return c == '+' || c == '-';
  }

  private boolean isWhitespace(char c) {
    return c == ' ';
  }

  private boolean isZero(char c) {
    return c == '0';
  }

  private boolean isMinusSign(char c) {
    return c == '-';
  }
}