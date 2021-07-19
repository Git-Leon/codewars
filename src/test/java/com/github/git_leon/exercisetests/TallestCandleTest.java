package com.github.git_leon.exercisetests;

import com.github.git_leon.exercises.tallestcandle.TallestCandle;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TallestCandleTest {
    @Test
    public void test() {
        // given
        int additionalElement = Integer.MIN_VALUE;
        int expected = 2;
        int mostCommon = 3;
        List<Integer> candles = Arrays.asList(mostCommon, 2, 1, mostCommon);
        Collections.shuffle(candles);
        TallestCandle tallestCandle = new TallestCandle(candles);

        // when
        int actual = tallestCandle.count();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        // given
        int additionalElement = Integer.MIN_VALUE;
        int expected = 2;
        int mostCommon = 5;
        List<Integer> candles = Arrays.asList(mostCommon, 2, 1, mostCommon);
        Collections.shuffle(candles);
        TallestCandle tallestCandle = new TallestCandle(candles);

        // when
        int actual = tallestCandle.count();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        // given
        int additionalElement = Integer.MIN_VALUE;
        int expected = 2;
        int mostCommon = 8;
        List<Integer> candles = Arrays.asList(mostCommon, 2, 1, mostCommon);
        Collections.shuffle(candles);
        TallestCandle tallestCandle = new TallestCandle(candles);

        // when
        int actual = tallestCandle.count();

        // then
        Assert.assertEquals(expected, actual);
    }

}
