package common.datastructures.linkedlist;

import lombok.Getter;

@Getter
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

  public void AddNode(T value) {
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

  public LinkedListNode<T> GetNodeAt(int i) {
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

  public void AddArray(T[] array) {
    for (T item : array) {
      this.AddNode(item);
    }
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
