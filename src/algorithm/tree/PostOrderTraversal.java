package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历
 */
public class PostOrderTraversal {
  public List<Integer> postOrderTraversal(TreeNode root) {
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
    if (root.right != null) {
      helper(root.right, list);
    }
    list.add(root.val);
  }
}
