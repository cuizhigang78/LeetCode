package top100.p0024_swap_nodes_in_pairs;

import common.ListNode;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = solution.swapPairs2(head);
        listNode.print();
    }

    /**
     * 三个指针
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pointer = dummyNode;
        ListNode pointer1;
        ListNode pointer2;

        while (pointer.next != null && pointer.next.next != null) {
            pointer1 = pointer.next;
            pointer2 = pointer.next.next;
            // 交换pointer指针的后两个节点
            pointer1.next = pointer2.next;
            pointer2.next = pointer1;
            pointer.next = pointer2;
            // pointer前进2步
            pointer = pointer.next.next;
        }
        return dummyNode.next;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pointer1 = head;
        ListNode pointer2 = head.next;
        // 交换前两个，再把next指向swapPairs2
        pointer1.next = swapPairs2(pointer2.next);
        pointer2.next = pointer1;
        return pointer2;
    }
}
