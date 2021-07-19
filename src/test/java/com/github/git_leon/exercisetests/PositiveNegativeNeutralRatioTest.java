package com.github.git_leon.exercisetests;

import com.github.git_leon.exercises.PositveNegativeNeutralRatio;
import org.junit.Test;

import java.util.Arrays;

public class PositiveNegativeNeutralRatioTest {
    @Test
    public void test() {
        // given
        PositveNegativeNeutralRatio obj = new PositveNegativeNeutralRatio(Arrays.asList(-4, 3, -9, 0, 4, 1));

        // when
        System.out.println(obj.toString());
    }
}
