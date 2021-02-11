package top100.p0148_sort_list;

import common.ListNode;

import java.util.*;

/**
 * 148. 排序链表（medium）
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode listNode = sortList(head);
        listNode.print();
    }

    /**
     * 使用优先级队列
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(0);
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode pointer = head;
        while (pointer != null) {
            queue.add(pointer);
            pointer = pointer.next;
        }
        pointer = dummyNode;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            poll.next = null;
            pointer.next = poll;
            pointer = pointer.next;
        }
        return dummyNode.next;
    }
}
































