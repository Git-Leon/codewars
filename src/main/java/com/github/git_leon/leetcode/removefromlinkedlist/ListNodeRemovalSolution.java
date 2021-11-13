package com.github.git_leon.leetcode.removefromlinkedlist;

public class ListNodeRemovalSolution {
    public ListNode removeElements(ListNode head, int valueToRemove) {
        // decapitate if necessary
        while (head.next != null && head.val == valueToRemove) {
            head = head.next;
        }
        Boolean isTail = null;
        ListNode previousElement = head;
        ListNode currentElement = head.next;

        while (true) {
            Boolean shouldRemoveCurrentNode = currentElement.val == valueToRemove;
            if (shouldRemoveCurrentNode) { // eliminate currentElement from chain
                previousElement.next = currentElement.next;
                currentElement = currentElement.next.next;
            } else {
                previousElement = currentElement;
                currentElement = currentElement.next;
            }

            isTail = currentElement.next == null;
            if (isTail) {
                boolean shouldRemoveTail = currentElement.val == valueToRemove;
                if (shouldRemoveTail) {
                    previousElement.next = null;
                }
                break;
            }
        }
        return head;
    }
}
