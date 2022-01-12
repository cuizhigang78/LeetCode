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
    public ListNode reverseKGroup(ListNode head, int k) {
        // 边界条件之一，节点为空时，不再反转
        if (head == null) return head;
        ListNode kthNode = head;
        for (int i = 0; i < k - 1; i++) {
            kthNode = kthNode.next;
            // 边界条件之二，节点长度小于 k 时，不再反转
            if (kthNode == null) return head;
        }
        // 反转前 k 个节点
        ListNode nextNode = kthNode.next;
        kthNode.next = null;
        ListNode reversedHead = reverse(head);
        ListNode reversedTail = reversedHead;
        while (reversedTail.next != null) {
            reversedTail = reversedTail.next;
        }
        // 并将第 k 个节点的 next 指针，指向剩余节点反转后的链表
        reversedTail.next = reverseKGroup(nextNode, k);
        return reversedHead;
    }

    /**
     * 翻转链表：
     *
     * dummyNode 作为新链表的哑节点，遍历原链表时，
     * 逐个将原链表的节点拼接到 dummyNode 的 next 指针，
     * 当原链表遍历完成后，dummyNode 的 next 节点
     * 就是反转后的新链表的头节点。
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        ListNode curr = head;
        while (curr != null) {
            ListNode currNext = curr.next;
            ListNode dummyNext = dummyNode.next;
            dummyNode.next = curr;
            curr.next = dummyNext;
            curr = currNext;
        }
        return dummyNode.next;
    }
}
