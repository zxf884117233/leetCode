package algorithm.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 先序遍历
 */
public class PreOrderTraversalTree {
  public List<Integer> preOrderTraversalTree(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    helper(root, list);
    return list;
  }

  private void helper(TreeNode root, List<Integer> list) {
    list.add(root.val);
    if (root.left != null) {
      helper(root.left, list);
    }
    if (root.right != null) {
      helper(root.right, list);
    }
  }
}
