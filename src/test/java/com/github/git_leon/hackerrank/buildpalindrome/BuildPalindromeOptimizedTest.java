package com.github.git_leon.hackerrank.buildpalindrome;

import org.junit.Assert;
import org.junit.Test;

public class BuildPalindromeOptimizedTest {
    private void test(String value1, String value2, String expected) {
        // given
        BuildPalindromeInterface bp = new BuildPalindromeOptimized(value1, value2);

        // when
        String actual = bp.toString();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test() {
        String out = "The quick brown fox jumps over the lazy dog";
        System.out.println(out.concat(new StringBuilder(out).reverse().toString()));
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

    @Test
    public void test4() {
        test("jdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfh", "dfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfd", "hfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfh");
    }

    @Test
    public void test5() {
        test("jdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfh", "dfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfd", "hfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfh");
    }


}
