package no234;

import common.ListNode;

public class Solution {

    public static void main(String[] args) {
        // ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2))));
        ListNode head = new ListNode(1, new ListNode(2));
        boolean res = isPalindrome(head);
        System.out.println("输出： " + res);
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rHead = reverseList(slow.next);

        while (rHead != null) {
            if (head.val != rHead.val) {
                return false;
            }
            head = head.next;
            rHead = rHead.next;
        }
        return true;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 执行用时：11 ms, 在所有 Java 提交中击败了17.86%的用户
     * 内存消耗：51.1 MB, 在所有 Java 提交中击败了22.58%的用户
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        int i = 0, j = sb.length() - 1;
        while (i < j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
