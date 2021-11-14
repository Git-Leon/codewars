package com.github.git_leon.leetcode.linkedlist;

import com.github.git_leon.leetcode.linkedlist.ListNode;
import com.github.git_leon.leetcode.linkedlist.removefromlinkedlist.ListNodeRemovalInterface;
import com.github.git_leon.leetcode.linkedlist.removefromlinkedlist.ListNodeRemovalPerfectExpandedSolution;
import org.junit.Assert;
import org.junit.Test;

public class RemoveFromLinkedList {
    // given
    private void test(ListNode node, Integer valueToRemove, String expected) {
        // when
        ListNodeRemovalInterface solution = new ListNodeRemovalPerfectExpandedSolution();
        ListNode result = solution.removeElements(node, valueToRemove);
        String actual = ListNode.toString(result);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoval() {
        // given
        ListNode node = ListNode.generate(1, 2, 6, 3, 4, 5, 6);
        Integer valueToRemove = 5;
        String expected = "[1, 2, 6, 3, 4, 6]";
        test(node, valueToRemove, expected);
    }

    @Test
    public void testRemoval1() {
        // given
        ListNode node = ListNode.generate(1, 2, 6, 3, 4, 5, 6);
        Integer valueToRemove = 6;
        String expected = "[1, 2, 3, 4, 5]";
        test(node, valueToRemove, expected);
    }

    @Test
    public void testRemoval2() {
        // given
        ListNode node = ListNode.generate(7, 7, 7, 7);
        Integer valueToRemove = 7;
        String expected = "[]";
        test(node, valueToRemove, expected);
    }

}
