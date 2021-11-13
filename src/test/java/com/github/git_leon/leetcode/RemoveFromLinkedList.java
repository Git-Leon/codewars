package com.github.git_leon.leetcode;

import com.github.git_leon.leetcode.removefromlinkedlist.ListNode;
import com.github.git_leon.leetcode.removefromlinkedlist.ListNodeRemovalSolution;
import org.junit.Test;

public class RemoveFromLinkedList {
    @Test
    public void testRemoval() {
        // given
        ListNode node = ListNode.generate(1, 2, 3, 4, 5);
        Integer valueToRemove = 5;

        // when
        ListNodeRemovalSolution solution = new ListNodeRemovalSolution();
        ListNode result = solution.removeElements(node, 5);

        // then
        System.out.println(ListNode.toString(result));
    }

}
