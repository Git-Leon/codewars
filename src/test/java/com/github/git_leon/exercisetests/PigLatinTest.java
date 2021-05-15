package com.github.git_leon.exercisetests;

import com.github.git_leon.exercises.piglatin.PigLatin1;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Chris on 4/1/2017.
 */
public class PigLatinTest {
    PigLatin1 p = new PigLatin1();

    @Test
    public void test1() {
        test("mommy", "ommymay");
    }

    @Test
    public void test2() {
        test("table", "abletay");
    }
    @Test
    public void test3() {
        test("end", "endway");
    }

    private void test(String input, String expectedOutput) {
        String actualOutput = p.translate(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
