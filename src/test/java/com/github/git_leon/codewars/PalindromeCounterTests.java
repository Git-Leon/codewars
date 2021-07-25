package com.github.git_leon.codewars;

import com.github.git_leon.codewars.organizelater.PalindromeCounter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Chris on 4/1/2017.
 */
public class PalindromeCounterTests {
    PalindromeCounter pc = new PalindromeCounter();

    @Test
    public void test1() {
        test("racecar", 10);
    }

    private void test(String input, int expectedOutput) {
        int actualOutput = pc.getNumberOfPalindromes(input);
        Assert.assertEquals(actualOutput, expectedOutput);

    }
}
