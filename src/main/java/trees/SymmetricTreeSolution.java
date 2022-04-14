package trees;

import common.Solution;
import common.datastructures.tree.Tree;
import common.datastructures.tree.TreeNode;
import lombok.Getter;

@Getter
public class SymmetricTreeSolution extends Solution<Boolean> {

  private final Tree<Integer> tree;

  public SymmetricTreeSolution(Tree<Integer> tree) {
    this.tree = tree;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Validate Binary Search Tree";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/";
    this.notes = "";
  }

  @Override
  public Boolean solve() {
    if (this.tree.getRoot() == null) {
      return true;
    }

    return this.isSymmetricTree(this.tree.getLeftNode(), this.tree.getRightNode());
  }

  private Boolean isSymmetricTree(TreeNode<Integer> left, TreeNode<Integer> right) {
    if ((left == null && right != null) ||
        (left != null && right == null)) {
      return false;
    }

    if (left != null && right != null) {
      if (left.getValue() != right.getValue()) {
        return false;
      }

      return this.isSymmetricTree(left.getLeftNode(), right.getRightNode()) &&
          this.isSymmetricTree(left.getRightNode(), right.getLeftNode());
    }

    return true;
  }
}