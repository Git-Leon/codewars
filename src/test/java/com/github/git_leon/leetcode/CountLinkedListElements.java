package com.github.git_leon.leetcode;

import com.github.git_leon.leetcode.linkedlist.ListNode;
import com.github.git_leon.leetcode.linkedlist.count.ListNodeCountSolution;
import org.junit.Assert;
import org.junit.Test;

public class CountLinkedListElements {
    @Test
    public void testCountSize1() {
        // given
        ListNode node = ListNode.generate(1, 2, 3, 4, 5);
        ListNodeCountSolution solution = new ListNodeCountSolution();
        int expected = 5;

        // when
        int result = solution.count(node);

        // then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCountSize2() {
        // given
        ListNode node = ListNode.generate(1, 2, 3, 4, 5, 6);
        ListNodeCountSolution solution = new ListNodeCountSolution();
        int expected = 6;

        // when
        int result = solution.count(node);

        // then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCountRange1() {
        // given
        ListNode node = ListNode.generate(1, 2, 3, 4, 5);
        ListNodeCountSolution solution = new ListNodeCountSolution();
        int expected = 2;

        // when
        int result = solution.count(node, 2, 3);

        // then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCountRange2() {
        // given
        ListNode node = ListNode.generate(1, 2, 3, 4, 5);
        ListNodeCountSolution solution = new ListNodeCountSolution();
        int expected = 3;

        // when
        int result = solution.count(node, 1, 3);

        // then
        Assert.assertEquals(expected, result);
    }


    @Test
    public void testCountExactly1() {
        // given
        ListNode node = ListNode.generate(1, 2, 3, 4, 5);
        ListNodeCountSolution solution = new ListNodeCountSolution();
        int expected = 1;

        // when
        int result = solution.count(node, 2);

        // then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCountExactly2() {
        // given
        ListNode node = ListNode.generate(1, 2, 3, 4, 5);
        ListNodeCountSolution solution = new ListNodeCountSolution();
        int expected = 0;

        // when
        int result = solution.count(node, 6);

        // then
        Assert.assertEquals(expected, result);
    }
}
