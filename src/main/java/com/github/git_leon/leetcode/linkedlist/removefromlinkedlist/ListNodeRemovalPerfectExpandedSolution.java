package com.github.git_leon.leetcode.linkedlist.removefromlinkedlist;

import com.github.git_leon.leetcode.linkedlist.ListNode;

public class ListNodeRemovalPerfectExpandedSolution implements ListNodeRemovalInterface {
    public ListNode removeElements(ListNode head, int val) {
        ListNode currentNode = head;

        // skip any val elements at the start of the list
        while (true) {
            boolean isCurrentNull = currentNode == null;
            if (!isCurrentNull) {
                boolean isCurrentValid = currentNode.val == val;
                if (isCurrentValid) {
                    currentNode = currentNode.next;
                } else {
                    break;
                }
            }
        }

        // here we either found the first non-val element
        // or are at the end of the list
        head = currentNode;
        ListNode lastGoodElement = head;
        while (true) {
            boolean isCurrentNull = currentNode == null;
            if (!isCurrentNull) {
                boolean isCurrentValid = currentNode.val == val;
                if (isCurrentValid) {
                    lastGoodElement.next = currentNode.next;
                } else {
                    lastGoodElement = currentNode;
                }
                currentNode = currentNode.next;
            } else {
                break;
            }
        }

        return head;
    }
}
