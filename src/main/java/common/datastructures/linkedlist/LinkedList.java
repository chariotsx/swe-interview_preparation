package common.datastructures.linkedlist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkedList<T> {

  private LinkedListNode<T> head;
  private LinkedListNode<T> tail;

  public LinkedList() {
    this.head = null;
    this.tail = null;
  }

  public LinkedList(T value) {
    this.head = new LinkedListNode<T>(value);
    this.tail = this.head;
  }

  public LinkedList(T[] array) {
    this.addArray(array);
  }

  public LinkedListNode<T> getHeadNode() {
    return this.head;
  }

  public void addNode(T value) {
    if (this.head == null) {
      this.head = new LinkedListNode<T>(value);
      this.tail = this.head;
    } else {
      this.tail.setNextNode(
          new LinkedListNode<>(value)
      );
      this.tail = this.tail.getNextNode();
    }
  }

  public LinkedListNode<T> getNodeAt(int i) {
    if (i >= this.length()) {
      return null;
    }

    LinkedListNode<T> temp = this.head;
    while (temp != null && i > 0) {
      i--;
      temp = temp.getNextNode();
    }

    return temp;
  }

  public void addArray(T[] array) {
    for (T item : array) {
      this.addNode(item);
    }
  }

  public void deleteNodeAt(int i) {
    int listLength = this.length();
    if (listLength == 0 || i < 0 || i >= listLength) {
      return;
    }

    if (i == 0) {
      this.head = this.head.getNextNode();

      if (this.tail != null) {
        this.tail = this.tail.getNextNode();
      }

      return;
    }

    int nodeBeforeRemovedIndex = i - 1;

    LinkedListNode<T> temp = this.head;
    while (temp != null && nodeBeforeRemovedIndex > 0) {
      nodeBeforeRemovedIndex--;
      temp = temp.getNextNode();
    }

    if (temp.getNextNode().getNextNode() == null) {
      this.tail = temp;
    }
    temp.setNextNode(temp.getNextNode().getNextNode());
  }

  public int length() {
    LinkedListNode<T> temp = this.head;
    int result = 0;

    while (temp != null) {
      result++;
      temp = temp.getNextNode();
    }

    return result;
  }

  public boolean equals(LinkedList<T> list) {
    if (this.length() != list.length()) {
      return false;
    }

    LinkedListNode<T> temp1 = this.head;
    LinkedListNode<T> temp2 = list.head;

    while (temp1 != null) {
      if (!temp1.getValue().equals(temp2.getValue())) {
        return false;
      }

      temp1 = temp1.getNextNode();
      temp2 = temp2.getNextNode();
    }

    return true;
  }

  public String toString() {
    LinkedListNode<T> tempHead = this.head;
    StringBuilder strBuilder = new StringBuilder();

    while (tempHead != null) {
      strBuilder.append(tempHead.getValue().toString());
      tempHead = tempHead.getNextNode();
    }

    return strBuilder.toString();
  }
}
