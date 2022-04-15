package sortingandsearching;

import common.Solution;
import lombok.Getter;

@Getter
public class MergeSortedArraySolution extends Solution<Void> {

  private final Integer[] nums1;
  private final Integer[] nums2;
  private final int m, n;

  public MergeSortedArraySolution(Integer[] nums1, Integer[] nums2, int m, int n) {
    this.nums1 = nums1;
    this.nums2 = nums2;
    this.m = m;
    this.n = n;
  }


  @Override
  protected void initializeSolution() {
    this.title = "Merge Sorted Array";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/587/";
    this.notes = "";
  }

  @Override
  public Void solve() {
    // Filling from end to start
    int i = this.m - 1;
    int j = this.n - 1;
    int trueIndex = this.m + this.n - 1;

    while (trueIndex >= 0) {
      if (j < 0) {
        break;
      } else if (i >= 0 && this.nums1[i] > this.nums2[j]) {
        this.nums1[trueIndex] = this.nums1[i];
        i--;
      } else {
        this.nums1[trueIndex] = this.nums2[j];
        j--;
      }

      trueIndex--;
    }

    return null;
  }
}