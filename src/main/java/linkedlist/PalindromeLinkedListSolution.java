package linkedlist;

import common.Solution;
import common.datastructures.linkedlist.LinkedList;
import common.datastructures.linkedlist.LinkedListNode;
import lombok.Getter;

@Getter
public class PalindromeLinkedListSolution extends Solution<Boolean> {

  private final LinkedList<Integer> list;

  public PalindromeLinkedListSolution(
      LinkedList<Integer> list) {
    this.list = list;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Palindrome Linked List";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/";
    this.notes = "O(n) time and O(1) space complexity";
  }

  @Override
  public Boolean solve() {
    int listLength = this.list.length();
    int indexMidHead = (int) (Math.ceil(listLength / 2.0));

    LinkedListNode<Integer> head = this.list.getHead();
    LinkedListNode<Integer> midHead = this.list.getHead();

    for (int i = 0; i < indexMidHead; i++) {
      midHead = midHead.getNextNode();
    }

    midHead = this.reverseLinkedList(midHead);

    for (int i = 0; i < listLength / 2; i++) {
      if (head.getValue() != midHead.getValue()) {
        return false;
      }

      head = head.getNextNode();
      midHead = midHead.getNextNode();
    }

    return true;
  }

  private LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> midHead) {
    LinkedListNode<Integer> currentNode = midHead;
    LinkedListNode<Integer> previousNode = null;

    while (currentNode != null) {
      LinkedListNode<Integer> nextNode = currentNode.getNextNode();
      currentNode.setNextNode(previousNode);
      previousNode = currentNode;
      currentNode = nextNode;
    }

    return previousNode;
  }
}