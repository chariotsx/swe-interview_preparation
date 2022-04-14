package trees;

import common.Solution;
import common.datastructures.tree.Tree;
import common.datastructures.tree.TreeNode;
import lombok.Getter;

@Getter
public class MaximumDepthBinaryTreeSolution extends Solution<Integer> {

  private final Tree<Integer> tree;

  public MaximumDepthBinaryTreeSolution(Tree<Integer> tree) {
    this.tree = tree;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Maximum Depth of Binary Tree";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/";
    this.notes = "";
  }

  @Override
  public Integer solve() {
    return this.maxDepth(tree.getRoot());
  }

  private int maxDepth(TreeNode<Integer> root) {
    if (root != null) {
      return 1 + Math.max(this.maxDepth(root.getLeftNode()), this.maxDepth(root.getRightNode()));
    }

    return 0;
  }
}