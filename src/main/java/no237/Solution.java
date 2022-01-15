package no237;

import common.ListNode;

public class Solution {

    public static void main(String[] args) {

    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
