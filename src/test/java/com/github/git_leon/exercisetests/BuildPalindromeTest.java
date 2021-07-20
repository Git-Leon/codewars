package com.github.git_leon.exercisetests;

import com.github.git_leon.exercises.buildpalindrome.BuildPalindrome;
import org.junit.Assert;
import org.junit.Test;

public class BuildPalindromeTest {
    private void test(String value1, String value2, String expected) {
        // given
        BuildPalindrome bp = new BuildPalindrome(value1, value2);

        // when
        String actual = bp.toString();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        test("bac", "bac", "aba");
    }

    @Test
    public void test2() {
        test("abc", "def", "-1");
    }

    @Test
    public void test3() {
        test("jdfh", "fds", "dfhfd");
    }
}
