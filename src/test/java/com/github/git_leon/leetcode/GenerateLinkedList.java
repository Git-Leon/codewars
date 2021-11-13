package com.github.git_leon.leetcode;

import com.github.git_leon.leetcode.removefromlinkedlist.ListNode;
import org.junit.Test;

public class GenerateLinkedList {
    @Test
    public void testGeneration() {
        // given
        ListNode node = ListNode.generate(1,2,3,4,5);

        // when
        String result = ListNode.toString(node);

        // then
        System.out.println(result);
    }

}
