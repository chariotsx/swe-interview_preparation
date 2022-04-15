package sortingandsearching;

import common.Solution;
import lombok.Getter;

@Getter
public class FirstBadVersionSolution extends Solution<Integer> {

  private final int version;
  private final int firstBadVersion;

  public FirstBadVersionSolution(int version, int firstBadVersion) {
    this.version = version;
    this.firstBadVersion = firstBadVersion;
  }

  @Override
  protected void initializeSolution() {
    this.title = "First Bad Version";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/774/";
    this.notes = "It reduces to leftmost binary search";
  }

  @Override
  public Integer solve() {
    int start = 1;
    int end = this.version;

    while (start < end) {
      int mid = start + (end - start) / 2;

      if (this.isBadVersion(mid)) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }

    return end;
  }

  private boolean isBadVersion(int Version) {
    return Version >= this.firstBadVersion;
  }
}