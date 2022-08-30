package no94_binary_tree_inorder_traversal;

import common.TreeNode;

import java.util.*;

/**
 * 中序遍历：左 -> 中 -> 右
 */
public class Solution {

    public static void main(String[] args) {
        // TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        List<Integer> list = inorderTraversal(root);
        System.out.println("输出：" + list);


    }

    /**
     * Morris 遍历算法是另一种遍历二叉树的方法，它能将非递归的中序遍历空间复杂度降为 O(1)。
     * 缺点是改变了整个树的结构，强行把一棵二叉树改成一段链表结构。
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while (root != null) {
            if (root.left != null) {
                // 1. 如果左子树不为空，就把当前节点及右子树（如果有的话）挂到左子树的最右节点的右节点
                // 1.1 找到左子树的最右节点
                TreeNode leftSonRightmost = root.left;
                while (leftSonRightmost.right != null) {
                    leftSonRightmost = leftSonRightmost.right;
                }
                // 1.2 把当前节点及右子树（如果有的话）放到左子树的最右节点的右节点
                leftSonRightmost.right = root;
                // 1.3 root 指向它的左子树
                TreeNode left = root.left;
                root.left = null;
                root = left;
            } else {
                // 2. 如果左子树为空，就向右遍历
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 迭代，首先找到最左子节点，在这一过程中，把沿途遇到的根节点保存到栈中，
     * 找到最左子节点后，将其加入到结果集中，
     * 再将栈中的根节点出栈，对它的右子树，也是先找到最左子节点，在这一过程中，把沿途遇到的根节点保存到栈中
     *
     * @param root
     * @return
     */
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
     * 递归调用
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n) 递归栈深度
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
