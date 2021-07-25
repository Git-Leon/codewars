package com.github.git_leon.codewars;

import com.github.git_leon.codewars.adjacentdigits.AdjacentDigitInterface;
import com.github.git_leon.codewars.adjacentdigits.AdjacentDigits1;
import com.github.git_leon.codewars.adjacentdigits.AdjacentDigits2;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Chris on 4/1/2017.
 */
public class AdjacentDigitsTest {

    AdjacentDigitInterface[] ads = {//
            new AdjacentDigits1(), // first solution
            new AdjacentDigits2() // second solution
    };


    @Test
    public void test1() {
        Integer input1 = 1234567;
        for (AdjacentDigitInterface ad : ads) {
            String result1 = ad.adjacentDigits(input1);
            Assert.assertEquals(input1.toString(), result1);
        }
    }

    @Test
    public void test2() {
        Integer input2 = 12467930;
        for (AdjacentDigitInterface ad : ads) {
            String result2 = ad.adjacentDigits(input2);
            Assert.assertEquals("12*4*67-9-30", result2);
        }
    }

    @Test
    public void test3() {
        // given
        AdjacentDigits2 adjacentDigits2 = new AdjacentDigits2();
        Integer input = 13789182;
        String expected = "1-3-789-18*2";

        // when
        String actual = adjacentDigits2.adjacentDigits(input);

        // then
        Assert.assertEquals(expected, actual);
    }
}