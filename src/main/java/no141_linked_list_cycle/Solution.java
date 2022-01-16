package no141_linked_list_cycle;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(4))));
        boolean res = hasCycle(node1);
        System.out.println("输出： " + res);
    }

    /**
     * 快慢指针，一前一后
     * 没有环的情况下，两个指针永远不可能相遇；有环的情况下，两个指针必然会相遇（快指针超过了慢指针 N 圈）
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 题干要求链表节点范围是[0, 10 ^ 4]，所以当计数器大于 10000 时，表示形成了环
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
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

    /**
     * 遍历所有节点，判断是否被访问过
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    public static boolean hasCycle3(ListNode head) {
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
