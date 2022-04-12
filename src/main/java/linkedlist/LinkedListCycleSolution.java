package linkedlist;

import common.Solution;
import common.datastructures.linkedlist.LinkedList;
import common.datastructures.linkedlist.LinkedListNode;
import lombok.Getter;

@Getter
public class LinkedListCycleSolution extends Solution<Boolean> {

  private final LinkedList<Integer> list;

  public LinkedListCycleSolution(
      LinkedList<Integer> list) {
    this.list = list;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Linked List Cycle";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/";
    this.notes = "O(1) space complexity";
  }

  @Override
  public Boolean solve() {
    if (this.list.getHead() == null) {
      return false;
    }

    LinkedListNode<Integer> slow = this.list.getHead();
    LinkedListNode<Integer> fast = this.list.getHead().getNextNode();

    while (slow != fast) {
      if (fast == null || fast.getNextNode() == null) {
        return false;
      }

      slow = slow.getNextNode();
      fast = fast.getNextNode().getNextNode();
    }

    return true;
  }
}