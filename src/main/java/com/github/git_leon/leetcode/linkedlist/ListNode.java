package com.github.git_leon.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static String toString(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head.next != null) {
            result.add(head.val);
            head = head.next;
        }
        return result.toString();
    }

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