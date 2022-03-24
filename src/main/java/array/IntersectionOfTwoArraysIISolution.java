package array;

import common.Solution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

public class IntersectionOfTwoArraysIISolution extends Solution<int[]> {

  @Getter
  private final int[] input1, input2;

  public IntersectionOfTwoArraysIISolution(int[] input1, int[] input2) {
    if (input1.length > input2.length) {
      this.input1 = input2;
      this.input2 = input1;
    }
    else {
      this.input1 = input1;
      this.input2 = input2;
    }
  }

  @Override
  protected void initializeSolution() {
    this.title = "Intersection of Two Arrays II";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/";
    this.notes = "Any order";
  }

  @Override
  public int[] solve() {
    ArrayList<Integer> result = new ArrayList<>();

    Map<Integer, Integer> hashMap = new HashMap<>();
    for (int item : this.input1) {
      hashMap.putIfAbsent(item, 0);
      hashMap.computeIfPresent(item, (k,v) -> v + 1);
    }

    for (int item : this.input2) {
      if (hashMap.getOrDefault(item, 0) > 0) {
        result.add(item);
      }

      hashMap.computeIfPresent(item, (k, v) -> v - 1);
    }

    return result.stream().mapToInt(i -> i).toArray();
  }
}