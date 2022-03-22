package array;

import common.Solution;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

public class ContainsDuplicateSolution extends Solution<Boolean> {

  @Getter
  private final int[] input;

  public ContainsDuplicateSolution(int[] input) {
    this.input = input;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Contains Duplicate";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/";
    this.notes = "Sorted O(NLogN) time complexity, using Set with extra space O(N)";
  }

  @Override
  public Boolean solve() {
    boolean result = false;
    Set<Integer> setInput = new HashSet<>();

    for (int item : this.input) {
      if (setInput.contains(item)) {
        result = true;
        break;
      }
      setInput.add(item);
    }

    return result;
  }
}
