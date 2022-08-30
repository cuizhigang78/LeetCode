package no145_binary_tree_postorder_traversal;

import common.TreeNode;

import java.util.*;

/**
 * 后序遍历：左 -> 右 -> 中
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        List<Integer> list = postorderTraversal2(root);
        System.out.println("输出：" + list);
    }

    /**
     * morris
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while (root != null) {

        }
        return res;
    }

    /**
     * 2. 迭代
     *
     * 中右左 reverse
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                res.add(cur.val);
                if (cur.left != null) stack.push(cur.left);
                if (cur.right != null) stack.push(cur.right);
            }
            Collections.reverse(res);
        }
        return res;
    }

    /**
     * 1. 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private static void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
