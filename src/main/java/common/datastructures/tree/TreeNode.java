package common.datastructures.tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode<T> {

  private T value;
  private TreeNode<T> leftNode, rightNode;

  public TreeNode(T value) {
    this.value = value;
    this.leftNode = null;
    this.rightNode = null;
  }

  public TreeNode(T value, TreeNode<T> leftNode, TreeNode<T> rightNode) {
    this.value = value;
    this.leftNode = leftNode;
    this.rightNode = rightNode;
  }
}