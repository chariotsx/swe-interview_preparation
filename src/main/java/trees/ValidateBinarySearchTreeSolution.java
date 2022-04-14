package trees;

import common.Solution;
import common.datastructures.tree.Tree;
import common.datastructures.tree.TreeNode;
import lombok.Getter;

@Getter
public class ValidateBinarySearchTreeSolution extends Solution<Boolean> {

  private final Tree<Integer> tree;

  public ValidateBinarySearchTreeSolution(Tree<Integer> tree) {
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
    return this.validateBST(this.tree.getRoot(), null, null);
  }

  private boolean validateBST(TreeNode<Integer> root, Integer minValue, Integer maxValue) {
    if (root != null) {
      if ((minValue != null && root.getValue() <= minValue) ||
          (maxValue != null && root.getValue() >= maxValue)) {
        return false;
      }

      return this.validateBST(root.getLeftNode(), minValue, root.getValue()) &&
          this.validateBST(root.getRightNode(), root.getValue(), maxValue);
    }

    return true;
  }
}