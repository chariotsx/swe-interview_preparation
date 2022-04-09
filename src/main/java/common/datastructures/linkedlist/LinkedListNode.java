package common.datastructures.linkedlist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkedListNode<T> {

  private T value;
  private LinkedListNode<T> nextNode;

  public LinkedListNode(T value) {
    this.value = value;
    this.nextNode = null;
  }

  public LinkedListNode(T value, LinkedListNode<T> nextNode) {
    this.value = value;
    this.nextNode = nextNode;
  }
}

