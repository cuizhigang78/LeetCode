package top100.p0019_remove_nth_node_from_end_of_list;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 通过次数315,953提交次数77
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import common.ListNode;

/**
 * 模式识别：
 *
 * 1. 涉及链表的特殊位置，考虑快慢指针
 * 2. 要删除链表节点，找到它的前驱
 *
 */
class Solution {
    /**
     * 快慢指针定位倒数第n个
     *
     * 快指针先走n步，再同步走快慢指针，当快指针到达链表末尾时，
     * 慢指针的下一个节点，就是要删除的节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast.next == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    /**
     * 暴力解法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode pointer = head;
        while (pointer != null) {
            len++;
            pointer = pointer.next;
        }
        if (len == n) {
            return head.next;
        }

        pointer = head;
        int index = 0;
        while (pointer != null) {
            if (index + 1 == len - n) {
                pointer.next = pointer.next.next;
            }
            pointer = pointer.next;
            index++;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head =
                //new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
                //new ListNode(1);
                new ListNode(1, new ListNode(2));
        ListNode retNode = solution.removeNthFromEnd1(head, 2);
        printListNode(retNode);
    }

    private static void printListNode(ListNode head) {
        ListNode pointer = head;
        while (pointer != null) {
            System.out.println(pointer.val);
            pointer = pointer.next;
        }
    }
}
