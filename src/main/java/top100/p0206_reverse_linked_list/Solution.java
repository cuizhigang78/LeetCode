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

        ListNode result = solution.reverseList(head);

        result.print();

    }

    /**
     * 递归
     * <p>
     * 执行结果： 通过
     * <p>
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 12.79% 的用户
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
     * <p>
     * 执行结果： 通过
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 5.10% 的用户
     * 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 30.96% 的用户
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
     * 遍历链表，将每个节点的next指向它的前一个节点
     * 因为单向链表没有前一个节点，所以使用prev变量保存，并在每次向前遍历时更新prev。
     * <p>
     * 执行结果： 通过
     * <p>
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 63.55% 的用户
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
