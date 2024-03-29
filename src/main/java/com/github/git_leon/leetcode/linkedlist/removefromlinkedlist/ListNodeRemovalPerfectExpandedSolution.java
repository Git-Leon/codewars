package com.github.git_leon.leetcode.linkedlist.removefromlinkedlist;

import com.github.git_leon.leetcode.linkedlist.ListNode;

/**
 * The decision to break; first is to ensure that we account for the simplest logic first
 *///https://leetcode.com/problems/remove-linked-list-elements/submissions/
public class ListNodeRemovalPerfectExpandedSolution implements ListNodeRemovalInterface {
    public ListNode removeElements(ListNode head, int valueToRemove) {
        ListNode currentNode = head;

        // skip all head elements which are not valid or until head is `null`
        while (true) {
            boolean isCurrentNull = currentNode == null;
            if (isCurrentNull) { // if current is null: we are at end of list
                break;
            } else {
                boolean isCurrentValid = currentNode.val == valueToRemove;
                if (!isCurrentValid) { // if current is invalid: next node is current
                    break;
                } else { // all other cases: continue to iterate
                    currentNode = currentNode.next;
                }
            }
        }

        // if not at end of list: find first valid element
        head = currentNode;
        ListNode mostRecentValid = head;
        while (true) {
            boolean isCurrentNull = currentNode == null;
            if (isCurrentNull) { // if current is null: we are at end of list
                break;
            } else {
                // if current is not null: check if current is valid
                boolean isCurrentValid = currentNode.val != valueToRemove;
                if (isCurrentValid) { // if current is valid: most recently valid is current
                    mostRecentValid = currentNode;
                } else { // if current is not valid: most recently valid is next
                    mostRecentValid.next = currentNode.next;
                }
                // as long as current is not null, next is current.next
                currentNode = currentNode.next;
            }
        }

        return head;
    }
}
