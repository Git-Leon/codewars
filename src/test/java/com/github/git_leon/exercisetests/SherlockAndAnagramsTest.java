package com.github.git_leon.exercisetests;

import com.github.git_leon.exercises.sherlockandanagrams.SherlockAndAnagrams;
import org.junit.Assert;
import org.junit.Test;

public class SherlockAndAnagramsTest {
    public void test(String input, int expected) {
        // given
        SherlockAndAnagrams sherlockAndAnagrams = new SherlockAndAnagrams(input);

        // when
        int actual = sherlockAndAnagrams.solve().size();

        // actual
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void test0() {
        // given
        test("mom", 2);
    }



    @Test
    public void test1() {
        // given
        test("abba", 4);
    }

    @Test
    public void test2() {
        // given
        test("abcd", 0);
    }

    @Test
    public void test3() {
        // given
        test("ifailuhkqq", 3);
    }

    @Test
    public void test4() {
        // given
        test("kkkk", 10);
    }


    @Test
    public void test5() {
        // given
        test("cdcd", 5);
    }
}
