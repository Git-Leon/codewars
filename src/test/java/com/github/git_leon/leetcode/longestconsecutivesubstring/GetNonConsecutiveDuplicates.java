package com.github.git_leon.leetcode.longestconsecutivesubstring;

import com.github.git_leon.leetcode.other.GetLengthOfLongestNonConsecutiveString;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GetNonConsecutiveDuplicates {
    // given
    private void test(String input, boolean expected) {
        GetLengthOfLongestNonConsecutiveString solution = new GetLengthOfLongestNonConsecutiveString();

        // when
        List<String> actual = solution.getNonConsecutiveSubStrings(input);

        // then
        System.out.println(actual);
    }

    @Test
    public void test() {
        test("aba", false);
        test("aa", true);
        test("Hello world",  true);
        test("Hey is this a consecutive duplicate too?", true);
    }
}
