package com.github.git_leon.leetcode;

import com.github.git_leon.leetcode.linkedlist.ListNode;
import com.github.git_leon.leetcode.linkedlist.count.ListNodeCountSolution;
import org.junit.Test;

public class CountLinkedListElements {
    @Test
    public void testCountSize() {
        // given
        ListNode node = ListNode.generate(1, 2, 3, 4, 5);
        ListNodeCountSolution solution = new ListNodeCountSolution();

        // when
        int result = solution.count(node);

        // then
        System.out.println(result);
    }

    @Test
    public void testCountRange() {
        // given
        ListNode node = ListNode.generate(1, 2, 3, 4, 5);
        ListNodeCountSolution solution = new ListNodeCountSolution();

        // when
        int result = solution.count(node, 2, 3);

        // then
        System.out.println(result);
    }


    @Test
    public void testCountExactly() {
        // given
        ListNode node = ListNode.generate(1, 2, 3, 4, 5);
        ListNodeCountSolution solution = new ListNodeCountSolution();

        // when
        int result = solution.count(node, 2);

        // then
        System.out.println(result);
    }
}
