package com.github.git_leon.leetcode.linkedlist.removefromlinkedlist;

import com.github.git_leon.leetcode.linkedlist.ListNode;

//https://leetcode.com/problems/remove-linked-list-elements/submissions/
public class ListNodeRemovalPerfectSolution implements ListNodeRemovalInterface {
    public ListNode removeElements(ListNode head, int val) {
        ListNode currentNode = head;
        // skip any val elements at the start of the list
        while (currentNode != null && currentNode.val == val) {
            currentNode = currentNode.next;
        }

        // here we either found the first non-val element
        // or are at the end of the list
        head = currentNode;
        ListNode lastGoodElement = head;
        while (currentNode != null) {
            if (currentNode.val == val) {
                lastGoodElement.next = currentNode.next;
            } else {
                lastGoodElement = currentNode;
            }
            currentNode = currentNode.next;
        }

        return head;
    }
}
