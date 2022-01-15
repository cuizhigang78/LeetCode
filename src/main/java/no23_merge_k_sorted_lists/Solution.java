package no23_merge_k_sorted_lists;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并K个升序链表 （hard）
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));

        ListNode listNode = solution.mergeKLists(lists);
        listNode.print();
    }

    /**
     * 优先级队列
     * <p>
     * 定义一个优先级队列pq，每次poll出val最小的节点，将此节点加到新链表的末尾
     * 如果此节点还有next节点，再将此next节点放回pq
     * （因为此处已定义好每个链表都是有序的，所以可以先取再加，
     * 如果是无序链表，那么只能先将所有节点都加到pq中，再逐一取出。）
     *
     * @param lists
     * @return
     */
    public ListNode mergeKListsByPriorityQueue(ListNode[] lists) {
        ListNode dummyNode = new ListNode(0);
        ListNode pointer = dummyNode;

        Queue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode listNode : lists) {
            if (listNode != null) priorityQueue.add(listNode);
        }

        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            pointer.next = poll;
            pointer = pointer.next;
            if (poll.next != null) priorityQueue.add(poll.next);
        }
        return dummyNode.next;
    }

    /**
     * 递归
     * <p>
     * mergeK(list) = merge2(mergeK(list/2), mergeK(list/2))
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (lists.length == 0) return null;
        if (left == right || lists.length == 1) return lists[left];

        int mid = (left + right) / 2;
        ListNode l1 = mergeKLists(lists, left, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    /**
     * 详见19题
     * <p>
     * 这里改为非递归方法，时间复杂度直接打败100%
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
