package algorithm.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
    }

    public static List<Integer> Tree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        InorderTree(root, list);
        return list;
    }

    private static void InorderTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            InorderTree(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            InorderTree(root.right, list);
        }
    }

    private static void OutOrderTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            OutOrderTree(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            OutOrderTree(root.right, list);
        }
    }

    private static void CenOrderTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            CenOrderTree(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            CenOrderTree(root.right, list);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}