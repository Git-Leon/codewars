package com.github.git_leon.exercisetests.buildpalindrome;

import com.github.git_leon.exercises.buildpalindrome.BuildPalindromeInterface;
import com.github.git_leon.exercises.buildpalindrome.BuildPalindromeIurchenko;
import com.github.git_leon.exercises.buildpalindrome.BuildPalindromeIurchenkoRefactored;
import org.junit.Assert;
import org.junit.Test;

public class BuildPalindromeIurchenkoTest {

    //given
    private void test(String value1, String value2, String expected) {

        // when
        String actual = BuildPalindromeIurchenko.buildPalindrome(value1, value2);

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

    @Test
    public void test4() {
        test("jdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfhjdfh", "dfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfd", "hfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfh");
    }

    @Test
    public void test5() {
        test("qquhuwqhdswxxrxuzzfhkplwunfagppcoildagktgdarveusjuqfistulgbglwmfgzrnyxryetwzhlnfewczmnoozlqatugmd", "dfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfd", "hfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfhfddfh");
    }
    @Test
    public void test6() {
        test("qquhuwqhdswxxrxuzzfhkplwunfagppcoildagktgdarveusjuqfistulgbglwmfgzrnyxryetwzhlnfewczmnoozlqatugmd", "jwgzcfabbkoxyjxkatjmpprswkdkobdagwdwxsufeesrvncbszcepigpbzuzoootorzfskcwbqorvw", "oozlzoo");
    }

}