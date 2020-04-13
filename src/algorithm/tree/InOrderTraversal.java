package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 */
public class InOrderTraversal {
  public List<Integer> InOrderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    helper(root, list);
    return list;
  }

  private void helper(TreeNode root, List<Integer> list) {
    if (root.left != null) {
      helper(root.left, list);
    }
    list.add(root.val);
    if (root.right != null) {
      helper(root.right, list);
    }
  }
}
