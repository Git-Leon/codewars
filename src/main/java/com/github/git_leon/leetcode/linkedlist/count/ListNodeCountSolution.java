package com.github.git_leon.leetcode.linkedlist.count;

import com.github.git_leon.leetcode.linkedlist.ListNode;

public class ListNodeCountSolution {
    public Integer count(ListNode head, int min, int max) {
        int count = 0;
        if(head == null) {
            return count;
        }

        while(head.next != null) {
            if(head.val >= min && head.val <= max) {
                count++;
            }
            head = head.next;
        }
        return count;
    }

    public Integer count(ListNode head, int exactValue) {
        return count(head, exactValue, exactValue);
    }

    public Integer count(ListNode head) {
        return count(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

}
