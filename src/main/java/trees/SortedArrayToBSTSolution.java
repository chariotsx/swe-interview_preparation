package trees;

import common.Solution;
import common.datastructures.tree.Tree;
import common.datastructures.tree.TreeNode;
import lombok.Getter;

@Getter
public class SortedArrayToBSTSolution extends Solution<Tree<Integer>> {

  private final Integer[] sortedArray;


  public SortedArrayToBSTSolution(Integer[] sortedArray) {
    this.sortedArray = sortedArray;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Convert Sorted Array to Binary Search Tree";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/";
    this.notes = "";
  }

  @Override
  public Tree<Integer> solve() {
    Tree<Integer> resultTree = new Tree<>();
    resultTree.setRoot(this.getTreeFromSortedArray(0, this.sortedArray.length - 1));

    return resultTree;
  }

  private TreeNode<Integer> getTreeFromSortedArray(int start, int end) {
    if (start > end) {
      return null;
    }

    if (start == end) {
      return new TreeNode<>(this.sortedArray[start]);
    }

    int mid = start + (end - start) / 2;
    TreeNode<Integer> treeNode = new TreeNode<>(this.sortedArray[mid]);
    treeNode.setLeftNode(this.getTreeFromSortedArray(start, mid - 1));
    treeNode.setRightNode(this.getTreeFromSortedArray(mid + 1, end));

    return treeNode;
  }
}