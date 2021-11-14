package com.github.git_leon.leetcode.linkedlist.removefromlinkedlist;

import com.github.git_leon.leetcode.linkedlist.ListNode;

public class ListNodeRemovalSimpleSolution implements ListNodeRemovalInterface{
    public ListNode removeElements(ListNode head, int valueToRemove) {
        // return head if null
        boolean isHeadNull = head == null;
        if (isHeadNull) {
            return head;
        }

        // decapitate if necessary
        while (true) {
            boolean isNextNull = head.next == null;
            boolean shouldRemoveHead = head.val == valueToRemove;
            if (!isNextNull && shouldRemoveHead) {
                head = head.next;
            } else {
                break;
            }
        }

        //traverse list
        ListNode currentNode = head;
        while (true) {
            boolean isCurrentNodeNull = currentNode == null;
            boolean isNextNodeNull = currentNode.next == null;
            boolean shouldContinueTraversal = !isCurrentNodeNull && !isNextNodeNull;
            if (shouldContinueTraversal) {
                int nextValue = currentNode.next.val;
                boolean shouldRemoveNext = nextValue == valueToRemove;
                if (shouldRemoveNext) {
                    currentNode.next = currentNode.next.next;
                } else {
                    currentNode = currentNode.next;
                }
            } else {
                break;
            }
        }
        return head;
    }
}
