package linkedlist;

import common.datastructures.linkedlist.LinkedList;
import common.datastructures.linkedlist.LinkedListNode;
import common.Solution;
import lombok.Getter;

@Getter
public class DeleteNodeLinkedListSolution extends Solution<Void> {

  private final LinkedList<Integer> list;
  private final LinkedListNode<Integer> nodeToDelete;

  public DeleteNodeLinkedListSolution(
      LinkedList<Integer> list,
      LinkedListNode<Integer> nodeToDelete) {
    this.list = list;
    this.nodeToDelete = nodeToDelete;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Delete Node in a Linked List";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/";
    this.notes = "Not access to the head of the list, guaranteed that node to delete is not tail of list";
  }

  @Override
  public Void solve() {
    LinkedListNode<Integer> temp = this.nodeToDelete;
    LinkedListNode<Integer> forwardTemp = this.nodeToDelete.getNextNode();

    while (forwardTemp != null) {

      temp.setValue(forwardTemp.getValue());

      if (forwardTemp.getNextNode() == null) {
        temp.setNextNode(null);
        break;
      }

      temp = temp.getNextNode();
      forwardTemp = forwardTemp.getNextNode();
    }

    return null;
  }
}