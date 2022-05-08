package com.github.git_leon.codewars.largestdifference;

import org.junit.Assert;
import org.junit.Test;

public class LargestDifferenceTest {
    @Test
    public void test1() {
        Assert.assertEquals(4, LargestDifference.largestDifference(new int[]{9,4,1,10,3,4,0,-1,-2}));
    }

    @Test
    public void test2(){
        Assert.assertEquals(0, LargestDifference.largestDifference(new int[]{3,2,1}));
    }

}