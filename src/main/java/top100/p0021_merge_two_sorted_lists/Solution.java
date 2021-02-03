package top100.p0021_merge_two_sorted_lists;

import top100.common.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = solution.mergeTwoLists2(l1, l2);
        System.out.println(listNode);
    }

    /**
     * 分别从头开始遍历两个链表，将较小的加入新链表中，直到有一个链表遍历完成，
     * 将另外一个链表的剩余元素直接回到新链表末尾。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 要返回的链表的哑节点
        ListNode dummyNode = new ListNode(0);
        // 新链表的指针
        ListNode pointer = dummyNode;
        // l1的指针
        ListNode pointer1 = l1;
        // l2的指针
        ListNode pointer2 = l2;

        while (pointer1 != null || pointer2 != null) {
            if (pointer1 == null) {
                pointer.next = pointer2;
                return dummyNode.next;
            }
            if (pointer2 == null) {
                pointer.next = pointer1;
                return dummyNode.next;
            }
            if (pointer1.val <= pointer2.val) {
                pointer.next = pointer1;
                pointer1 = pointer1.next;
            } else {
                pointer.next = pointer2;
                pointer2 = pointer2.next;
            }
            pointer = pointer.next;
        }
        return dummyNode.next;
    }

    /**
     *
     * 递归
     *
     * 假设l1.val小于等于l2.val,合并l1,l2等价于把l1的next指向l1.next和l2合并后的结果。
     *
     * 模式识别：子问题和原问题具有相同的结果，考虑自上而下的递归。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
