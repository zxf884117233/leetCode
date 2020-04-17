package leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeInorderTraversal {
    //递归中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root.left != null) helper(root.left, list);
        list.add(root.val);
        if (root.right != null) helper(root.right, list);
    }

    //栈 Deque 双端队列实现栈的操作超出时间限制
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
