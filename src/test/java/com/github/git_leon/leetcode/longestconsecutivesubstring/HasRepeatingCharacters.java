package com.github.git_leon.leetcode.longestconsecutivesubstring;

import com.github.git_leon.leetcode.other.GetLengthOfLongestNonConsecutiveString;
import org.junit.Assert;
import org.junit.Test;

public class HasRepeatingCharacters {
    // given
    private void test(String input, boolean expected) {
        GetLengthOfLongestNonConsecutiveString solution = new GetLengthOfLongestNonConsecutiveString();

        // when
        boolean actual = solution.hasRepeatingCharacters(input);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        test("aba", true);
    }

    @Test
    public void test2() {
        test("aa", true);
    }


    @Test
    public void test3() {
        test("Hello world", true);
    }


    @Test
    public void test4() {
        test("Hey is this a consecutive duplicate too?", true);
    }

    @Test
    public void test5() {
        test("The quick brown", false);
    }
}
