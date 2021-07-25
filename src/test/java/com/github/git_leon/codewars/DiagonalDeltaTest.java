package com.github.git_leon.codewars;

import com.github.git_leon.codewars.diagnoldelta.DiagonalDelta;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DiagonalDeltaTest {
    private void getLeftDiagonalSumTest(List<List<Integer>> list, int expected) {
        //given
        DiagonalDelta delta = new DiagonalDelta();

        //when
        int actual = delta.getLeftDiagonalSum(list);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLeftDiagonalSumTest1() {
        getLeftDiagonalSumTest(Arrays.asList(
                Arrays.asList(11, 2, 4),
                Arrays.asList(4, 5, 6),
                Arrays.asList(10, 8, -12)), 4);
    }

    @Test
    public void getLeftDiagonalSumTest2() {
        getLeftDiagonalSumTest(Arrays.asList(
                Arrays.asList(10, 2, 4),
                Arrays.asList(4, 5, 6),
                Arrays.asList(10, 8, -10)), 5);
    }

    private void getRightDiagonalSumTest(List<List<Integer>> list, int expected) {
        //given
        DiagonalDelta delta = new DiagonalDelta();

        //when
        int actual = delta.getRightDiagonalSum(list);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRightDiagonalSumTest1() {
        getRightDiagonalSumTest(Arrays.asList(
                Arrays.asList(11, 2, 4),
                Arrays.asList(4, 5, 6),
                Arrays.asList(10, 8, -12)), 19);
    }

    @Test
    public void getRightDiagonalSumTest2() {
        getRightDiagonalSumTest(Arrays.asList(
                Arrays.asList(10, 2, 4),
                Arrays.asList(4, 5, 6),
                Arrays.asList(-10, 8, -10)), -1);
    }
}
