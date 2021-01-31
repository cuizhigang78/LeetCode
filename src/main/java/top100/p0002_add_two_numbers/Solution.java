package top100.p0002_add_two_numbers;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 这题主要考查链表知识，而链表的核心在于指针，如下head作为头节点（虚拟的），pointer作为从root开始的指针，逐一遍历链表各节点。
 *
 */
public class Solution {
    /**
     * 时间复杂度：O(max(m, n))，m和n分别表示l1和l2的长度，该算法最多重复max(m, n)次
     * 空间复杂度：O(max(m, n))，新列表的长度最多为max(m, n) + 1
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            pointer.next = new ListNode(sum % 10);
            carry = sum / 10;
            pointer = pointer.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
