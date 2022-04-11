package linkedlist;

import common.Solution;
import common.datastructures.linkedlist.LinkedList;
import common.datastructures.linkedlist.LinkedListNode;
import lombok.Getter;

@Getter
public class ReverseLinkedListSolution extends Solution<LinkedListNode> {

  private final LinkedList<Integer> list;

  public ReverseLinkedListSolution(LinkedList<Integer> list) {
    this.list = list;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Reverse Linked List";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/";
    this.notes = "Iterative solution";
  }

  @Override
  public LinkedListNode solve() {
    LinkedListNode<Integer> currentNode = this.list.getHeadNode();
    LinkedListNode<Integer> previousNode = null;

    // For LinkedList consistency purposes
    this.list.setTail(this.list.getHeadNode());

    while (currentNode != null) {
      LinkedListNode<Integer> nextNode = currentNode.getNextNode();
      currentNode.setNextNode(previousNode);
      previousNode = currentNode;
      currentNode = nextNode;
    }

    // For LinkedList consistency purposes
    this.list.setHead(previousNode);

    return previousNode;
  }
}