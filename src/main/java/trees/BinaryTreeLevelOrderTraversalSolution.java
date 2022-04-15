package trees;

import common.Solution;
import common.datastructures.tree.Tree;
import common.datastructures.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class BinaryTreeLevelOrderTraversalSolution extends Solution<List<List<Integer>>> {

  private final Tree<Integer> tree;

  public BinaryTreeLevelOrderTraversalSolution(
      Tree<Integer> tree) {
    this.tree = tree;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Binary Tree Level Order Traversal";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/";
    this.notes = "Same order";
  }

  @Override
  public List<List<Integer>> solve() {
    List<List<Integer>> result = new ArrayList<>();

    this.fillListBSTLevelOrder(this.tree.getRoot(), result, 0);

    return result;
  }

  private void fillListBSTLevelOrder(
      TreeNode<Integer> root,
      List<List<Integer>> result,
      int level) {

    if (root != null) {

      // Adding sublist for current level nodes
      if (level + 1 > result.size()) {
        result.add(new ArrayList<>());
      }

      result.get(level).add(root.getValue());
      this.fillListBSTLevelOrder(root.getLeftNode(), result, level + 1);
      this.fillListBSTLevelOrder(root.getRightNode(), result, level + 1);
    }
  }
}