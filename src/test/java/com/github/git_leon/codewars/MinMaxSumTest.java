package com.github.git_leon.codewars;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MinMaxSumTest {
    @Test
    public void test1() {
        //given
        List<Integer> input = Arrays.asList(1,2,3,4,5);
        String expected = "10 14";
        MinMaxSum minMaxSum = new MinMaxSum(input);

        //
        Assert.assertEquals(expected, minMaxSum.toString());
    }

    @Test
    public void test2() {
        //given
        List<Integer> input = Arrays.asList(1,3,5,7,9);
        String expected = "16 24";
        MinMaxSum minMaxSum = new MinMaxSum(input);

        //
        Assert.assertEquals(expected, minMaxSum.toString());
    }

    @Test
    public void test3() {
        //given
        List<Integer> input = Arrays.asList(1,3,5,7,-9);
        String expected = "0 16";
        MinMaxSum minMaxSum = new MinMaxSum(input);

        //
        Assert.assertEquals(expected, minMaxSum.toString());
    }
    @Test
    public void test4() {
        //given
        List<Integer> input = Arrays.asList(396285104, 573261094, 759641832, 819230764, 364801279);
        String expected = "2093989309 2548418794";
        MinMaxSum minMaxSum = new MinMaxSum(input);

        //
        Assert.assertEquals(expected, minMaxSum.toString());
    }
}
