package com.github.git_leon.leetcode.linkedlist.removefromlinkedlist;

import com.github.git_leon.leetcode.linkedlist.ListNode;

public class ListNodeRemovalMySolution implements ListNodeRemovalInterface {
    public ListNode removeElements(ListNode head, int valueToRemove) {
        // if head is null return null
        if (head == null) {
            return head;
        }

        // decapitate null head
        ListNode currentNode = head;
        while (true) {
            boolean isNotNullCurrent = currentNode != null;
            if (isNotNullCurrent) {
                boolean isValidCurrent = currentNode.val != valueToRemove;
                if (isValidCurrent) {
                    currentNode = currentNode.next;
                } else {
                    break;
                }
            }
        }

        return head;
    }
}

