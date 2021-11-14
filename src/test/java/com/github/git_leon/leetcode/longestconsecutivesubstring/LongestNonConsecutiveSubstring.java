package com.github.git_leon.leetcode.longestconsecutivesubstring;

import com.github.git_leon.leetcode.other.GetLengthOfLongestNonConsecutiveString;
import org.junit.Assert;
import org.junit.Test;

public class LongestNonConsecutiveSubstring {
    @Test
    public void test() {
        // given
        String input = "abcabcbb";
        GetLengthOfLongestNonConsecutiveString solution = new GetLengthOfLongestNonConsecutiveString();
        int expected = 3;

        // when
        int actual = solution.lengthOfLongestSubstring(input);

        // then
        Assert.assertEquals(expected, actual);
    }
}
