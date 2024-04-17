package no144_binary_tree_preorder_traversal;

import common.TreeNode;

import java.util.*;

/**
 * 二叉树的前序遍历
 * <p>
 * 前序：中 -> 左 -> 右
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        List<Integer> list = preorderTraversal2(root);
        System.out.println("输出：" + list);
    }

    /**
     * 3. Morris
     * @param root 根节点
     * @return 前序遍历结果
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while (root != null) {
            res.add(root.val);
            if (root.left != null) {
                // 1. 如果左子树不为空，就把右子树（如果有得话）直接挂到左子树的最右节点的右节点
                TreeNode leftSonRightmost = root.left;
                while (leftSonRightmost.right != null) {
                    leftSonRightmost = leftSonRightmost.right;
                }
                leftSonRightmost.right = root.right;
                root = root.left;
            } else {
                // 2. 如果左子树为空，向右迭代
                root = root.right;
            }

        }
        return res;
    }

    /**
     * 迭代
     *
     * 1. 从栈中弹出一个节点 cur
     * 2. 处理 cur
     * 3. 先右后左压栈（如果有）
     * 4. 循环
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                res.add(cur.val);
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            }
        }
        return res;
    }

    /**
     * 1. 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
