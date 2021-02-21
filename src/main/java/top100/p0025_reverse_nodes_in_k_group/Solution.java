package top100.p0025_reverse_nodes_in_k_group;

import common.ListNode;

/**
 * 25. K 个一组翻转链表 （hard）
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode =
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode rtNode = solution.reverseKGroup(listNode, 2);
        rtNode.print();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode pointer = head;
        while (pointer != null) {
            len++;
            pointer = pointer.next;
        }
        // 如果链表长度小于k，直接返回原链表
        if (len < k) return head;

        // 如果链表长度不小于k，翻转后返回
        // 1. 拿出前k个翻转
        ListNode root = head;
        for (int i = 0; i < k - 1; i++) {
            root = root.next;
        }
        ListNode newHead = root.next;
        root.next = null;
        // 2. 前k个翻转后的结果的next = reverseKGroup('后面的')
        ListNode front = reverseKNodes(head);
        ListNode p = front;
        while (p.next != null) {
            p = p.next;
        }
        head.next = null;
        p.next = reverseKGroup(newHead, k);
        return root;
    }

    public ListNode reverseKNodes(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode newHead = reverseKNodes(head.next);

        // 交换
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
