package common.datastructures.tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tree<T> {

  private TreeNode<T> root;

  public Tree() {
    this.root = null;
  }

  public Tree(T value) {
    this.root = new TreeNode<T>(value);
  }

  public Tree(T[] array) {
    this.root = this.insertLevelOrder(array, this.root, 0);
  }

  public TreeNode<T> getRightNode() {
    return this.root.getRightNode();
  }

  public TreeNode<T> getLeftNode() {
    return this.root.getLeftNode();
  }

  public TreeNode<T> insertLevelOrder(T[] array, TreeNode<T> root, int i) {
    if (i < array.length && array[i] != null) {
      root = new TreeNode<>(array[i]);
      root.setLeftNode(this.insertLevelOrder(array, root.getLeftNode(), 2 * i + 1));
      root.setRightNode(this.insertLevelOrder(array, root.getRightNode(), 2 * i + 2));
    }

    return root;
  }

  public boolean equals(Tree<T> tree) {
    return this.equals(tree.getRoot());
  }

  public boolean equals(TreeNode<T> root) {
    return this.equals(this.root, root);
  }

  private boolean equals(TreeNode<T> root1, TreeNode<T> root2) {
    if (root1 == null && root2 != null || root1 != null && root2 == null) {
      return false;
    }

    if (root1 != null && root2 != null) {
      if (root1.getValue() != root2.getValue()) {
        return false;
      }

      return this.equals(root1.getLeftNode(), root2.getLeftNode()) &&
          this.equals(root1.getRightNode(), root2.getRightNode());
    }

    return true;
  }
}