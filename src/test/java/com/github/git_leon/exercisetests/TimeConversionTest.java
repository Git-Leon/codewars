package com.github.git_leon.exercisetests;

import com.github.git_leon.exercises.timeconversion.TimeConversion;
import org.junit.Assert;
import org.junit.Test;

public class TimeConversionTest {
    @Test
    public void test() {
        // given
        String input = "07:05:45PM";
        String expected = "19:05:45";
        TimeConversion tc = new TimeConversion(input);

        // when
        String actual = tc.toString();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        // given
        String input = "12:45:54PM";
        String expected = "12:45:54";
        TimeConversion tc = new TimeConversion(input);

        // when
        String actual = tc.toString();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        // given
        String input = "12:00:00AM";
        String expected = "00:00:00";
        TimeConversion tc = new TimeConversion(input);

        // when
        String actual = tc.toString();

        // then
        Assert.assertEquals(expected, actual);
    }
}
