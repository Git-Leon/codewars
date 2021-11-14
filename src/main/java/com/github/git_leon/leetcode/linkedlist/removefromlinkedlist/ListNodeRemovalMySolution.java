package com.github.git_leon.leetcode.linkedlist.removefromlinkedlist;

import com.github.git_leon.leetcode.linkedlist.ListNode;

public class ListNodeRemovalMySolution implements ListNodeRemovalInterface {
    public ListNode removeElements(ListNode head, int valueToRemove) {
        // if head is null return null
        if (head == null) {
            return head;
        }

        // decapitate null head
        while (head.next != null && head.val == valueToRemove) {
            head.next = head.next.next;
        }

        // traverse list
        ListNode currentNode = head;
        ListNode mostRecentValidNode = currentNode;
        while (true) {
            boolean isNotNullCurrent = currentNode != null;
            if (isNotNullCurrent) {
                boolean isValidCurrent = currentNode.val != valueToRemove;
                if (isValidCurrent) {
                    mostRecentValidNode = currentNode;
                } else { // currentNode is not valid
                    boolean isNotNullNext = currentNode.next != null;
                    if (isNotNullNext) {
                        boolean isValidNext = currentNode.next.val != valueToRemove;
                        if (isValidNext) {
                            mostRecentValidNode = currentNode.next;
                        } else {
                            currentNode = currentNode.next;
                        }
                    }
                }
            } else { // if isNullCurrent
                break;
            }
        }
        return head;
    }
}

