package com.github.git_leon.leetcode.removefromlinkedlist;

public class ListNodeGenerator {
    public static ListNode generate(Integer... vals) {
        ListNode headNode = new ListNode();
        ListNode currentNode = headNode;
        for (Integer val : vals) {
            currentNode.val = val;
            currentNode.next = new ListNode();
            currentNode = currentNode.next;
        }
        return headNode;
    }
}
