package no83_remove_dunolicates_from_sorted_list;

import common.ListNode;

/**
 * 83. 删除排序链表中的重复元素 （easy）
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2)));
        //ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        deleteDuplicates1(head).print();
    }

    /**
     * 双指针，逐个遍历，有重复的删除即可
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.6 MB, 在所有 Java 提交中击败了95.79 %的用户
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (prev != null && curr.val == prev.val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    /**
     * 递归法
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了19.57%的用户
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates1(head.next);
        return head.next.val == head.val ? head.next : head;
    }
}
