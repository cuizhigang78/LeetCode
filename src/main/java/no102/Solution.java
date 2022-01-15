package no102;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root = null;
        List<List<Integer>> res = levelOrder(root);
        System.out.println("输出： " + res);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.push(root);

        while (queue1.size() != 0 || queue2.size() != 0) {
            List<Integer> path = new ArrayList<>();
            if (queue1.size() != 0) {
                while (queue1.size() != 0) {
                    TreeNode poll = queue1.poll();
                    if (poll.left != null) queue2.add(poll.left);
                    if (poll.right != null) queue2.add(poll.right);
                    path.add(poll.val);
                }
            } else {
                while (queue2.size() != 0) {
                    TreeNode poll = queue2.poll();
                    if (poll.left != null) queue1.add(poll.left);
                    if (poll.right != null) queue1.add(poll.right);
                    path.add(poll.val);
                }
            }
            res.add(path);
        }
        return res;
    }
}
