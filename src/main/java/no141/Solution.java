package no141;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        // ListNode node3 = new ListNode(0);
        // ListNode node4 = new ListNode(4);
        node1.next = node2;
        // node2.next = node3;
        // node3.next = node4;
        // node4.next = node2;
        boolean res = hasCycle(node1);
        System.out.println("输出： " + res);
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (head != null) {
            head = head.next;
            if (slow.next == null) {
                return false;
            } else {
                slow = slow.next;
            }
            if (fast.next == null || fast.next.next == null) {
                return false;
            } else {
                fast = fast.next.next;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        int count = 0;
        while (head != null) {
            if (count > 10000) {
                return true;
            }
            head = head.next;
            count++;
        }
        return false;
    }

    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
