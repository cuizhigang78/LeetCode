package no94;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        // TreeNode root = new TreeNode(11, new TreeNode(5, new TreeNode(7), new TreeNode(9, new TreeNode(8), new TreeNode(10))), new TreeNode(15));
        List<Integer> list = inorderTraversal(root);
        System.out.println(list);


    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        return res;
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                root = pop.right;
            }
        }
        return res;
    }

    /**
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    public static void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }
}
