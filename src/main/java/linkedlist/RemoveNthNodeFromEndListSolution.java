package linkedlist;

import common.Solution;
import common.datastructures.linkedlist.LinkedList;
import common.datastructures.linkedlist.LinkedListNode;
import lombok.Getter;

@Getter
public class RemoveNthNodeFromEndListSolution extends Solution<LinkedListNode> {

  private final LinkedList<Integer> list;
  private final int nthNode;

  public RemoveNthNodeFromEndListSolution(
      LinkedList<Integer> list,
      int nthNode) {
    this.list = list;
    this.nthNode = nthNode;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Remove Nth Node From End of List";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/";
    this.notes = "Given head and Nth node from end of the list";
  }

  @Override
  public LinkedListNode<Integer> solve() {
    int listLength = this.list.length();

    this.list.deleteNodeAt(listLength - this.nthNode);
    return this.list.getHeadNode();
  }

  public LinkedListNode<Integer> solve2() {
    LinkedListNode<Integer> currentNode = this.list.getHeadNode();

    for (int i = 0; i < this.nthNode; i++) {
      currentNode = currentNode.getNextNode();
    }

    if (currentNode == null) {
      this.list.setHead(this.list.getHeadNode().getNextNode());
      return this.list.getHeadNode();
    }

    LinkedListNode<Integer> nodeBeforeRemoved = this.list.getHeadNode();

    while (currentNode.getNextNode() != null) {
      nodeBeforeRemoved = nodeBeforeRemoved.getNextNode();
      currentNode = currentNode.getNextNode();
    }

    nodeBeforeRemoved.setNextNode(nodeBeforeRemoved.getNextNode().getNextNode());

    return this.list.getHeadNode();
  }
}