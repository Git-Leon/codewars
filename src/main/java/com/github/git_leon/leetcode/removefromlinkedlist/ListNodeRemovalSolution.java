package com.github.git_leon.leetcode.removefromlinkedlist;

public class ListNodeRemovalSolution {
    public ListNode removeElements(ListNode head, int valueToRemove) {
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
