package com.github.git_leon.leetcode;

import com.github.git_leon.leetcode.removefromlinkedlist.ListNode;
import com.github.git_leon.leetcode.removefromlinkedlist.ListNodeRemovalSolution;
import org.junit.Assert;
import org.junit.Test;

public class RemoveFromLinkedList {
    @Test
    public void testRemoval1() {
        // given
        ListNode node = ListNode.generate(1, 2, 6, 3, 4, 5, 6);
        Integer valueToRemove = 5;
        String expected = "[1, 2, 6, 3, 4, 6]";

        // when
        ListNodeRemovalSolution solution = new ListNodeRemovalSolution();
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

        // when
        ListNodeRemovalSolution solution = new ListNodeRemovalSolution();
        ListNode result = solution.removeElements(node, 6);

        // then
        System.out.println(ListNode.toString(result));
    }

}
