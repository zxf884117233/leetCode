package leetCode.tree;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * <p>
 * Example 1:
 * Input:
 * 1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * Output: true
 * <p>
 * Example 2:
 * Input:
 * 1         1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * Output: false
 * <p>
 * Example 3:
 * Input:
 * 1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * Output: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SameTree {
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isCheck(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!isCheck(p, q)) return false;
        Deque<TreeNode> pDeque = new ArrayDeque<>();
        Deque<TreeNode> qDeque = new ArrayDeque<>();
        pDeque.offerLast(p);
        qDeque.offerLast(q);
        while (!pDeque.isEmpty()) {
            p = pDeque.removeFirst();
            q = qDeque.removeFirst();
            if (!isCheck(p.left, q.left)) return false;
            if (p.left != null) {
                pDeque.offerLast(p.left);
                qDeque.offerLast(q.left);
            }
            if (!isCheck(p.right, q.right)) return false;
            if (p.right != null) {
                pDeque.offerLast(p.right);
                qDeque.offerLast(q.right);
            }

        }
        return true;
    }

}
