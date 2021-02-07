package top100.p0206_reverse_linked_list;

import common.ListNode;

import java.util.Stack;

/**
 * 206. 反转链表 (easy)
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode result = solution.reverseList3(head);

        result.print();

    }

    /**
     * 递归
     *
     *
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList3(head.next);

        // 交换
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 迭代 + 栈
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(0);
        ListNode nextNode = dummyNode;

        Stack<ListNode> stack = new Stack<>();

        ListNode pointer = head;
        while (pointer != null) {
            stack.push(pointer);
            pointer = pointer.next;
        }

        while (!stack.empty()) {
            ListNode pop = stack.pop();
            pop.next = null;
            nextNode.next = pop;
            nextNode = nextNode.next;
        }
        return dummyNode.next;
    }

    /**
     * 纯迭代，双层循环
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(0);
        ListNode nextNode = dummyNode;

        // 1. 计算原链表长度
        int len = 0;
        ListNode pointer = head;
        while (pointer != null) {
            len++;
            pointer = pointer.next;
        }

        // 2. 从尾到头遍历原链表
        for (int i = 0; i < len; i++) {
            pointer = head;
            for (int j = 0; j < len - i - 1; j++) {
                pointer = pointer.next;
            }
            pointer.next = null;
            nextNode.next = pointer;
            nextNode = nextNode.next;
        }
        return dummyNode.next;
    }
}
