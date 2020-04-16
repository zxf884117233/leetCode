package algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 层次遍历
 */
public class LevelTraversal {
  public List<Integer> levelTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      list.add(curr.val);
      if (curr.left != null) {
        queue.offer(curr.left);
      }
      if (curr.right != null) {
        queue.offer(curr.right);
      }
    }
    return list;
  }
}
