package linkedlist;

import common.Solution;
import common.datastructures.linkedlist.LinkedList;
import common.datastructures.linkedlist.LinkedListNode;
import lombok.Getter;

@Getter
public class MergeTwoSortedListSolution extends Solution<LinkedListNode> {

  private final LinkedList<Integer> list1;
  private final LinkedList<Integer> list2;

  public MergeTwoSortedListSolution(
      LinkedList<Integer> list1,
      LinkedList<Integer> list2) {
    this.list1 = list1;
    this.list2 = list2;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Merge Two Sorted Lists";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/";
    this.notes = "Result on input list one";
  }

  @Override
  public LinkedListNode solve() {
    LinkedListNode<Integer> preMergedListHead = new LinkedListNode<Integer>(0);
    LinkedListNode<Integer> headList1 = this.list1.getHead();
    LinkedListNode<Integer> headList2 = this.list2.getHead();
    LinkedListNode<Integer> previousNode = preMergedListHead;

    while (headList1 != null && headList2 != null) {
      if (headList1.getValue() <= headList2.getValue()) {
        previousNode.setNextNode(headList1);
        headList1 = headList1.getNextNode();
      } else {
        previousNode.setNextNode(headList2);
        headList2 = headList2.getNextNode();
      }

      previousNode = previousNode.getNextNode();
    }

    if (headList1 == null) {
      previousNode.setNextNode(headList2);
    }

    if (headList2 == null) {
      previousNode.setNextNode(headList1);
    }

    // For LinkedList consistency purposes, result on list1
    while (previousNode.getNextNode() != null) {
      previousNode = previousNode.getNextNode();
    }
    this.list1.setHead(preMergedListHead.getNextNode());
    this.list1.setTail(previousNode);

    return preMergedListHead.getNextNode();
  }
}