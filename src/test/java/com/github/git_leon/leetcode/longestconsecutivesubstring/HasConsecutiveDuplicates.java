package com.github.git_leon.leetcode.longestconsecutivesubstring;

import com.github.git_leon.leetcode.other.GetLengthOfLongestNonConsecutiveString;
import org.junit.Assert;
import org.junit.Test;

public class HasConsecutiveDuplicates {
    // given
    private void test(String input, boolean expected) {
        GetLengthOfLongestNonConsecutiveString solution = new GetLengthOfLongestNonConsecutiveString();

        // when
        boolean actual = solution.hasConsecutiveDuplicates(input);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        test("aba", false);
        test("aa", true);
        test("Hello world",  true);
        test("Hey is this a consecutive duplicate too?", true);
    }
}
