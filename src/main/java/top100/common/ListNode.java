package top100.common;

/**
 * @ClassName ListNode
 * @Author Maxwell
 * @Date 2021/2/3 21:30
 * @Description ListNode
 * @Version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode pointer = this;
        while (pointer != null) {
            System.out.println(pointer.val);
            pointer = pointer.next;
        }
    }
}
