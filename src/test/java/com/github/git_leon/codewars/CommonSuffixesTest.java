package com.github.git_leon.codewars;

import com.github.git_leon.codewars.commonstrings.CommonSuffixes1;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Chris on 4/1/2017.
 */
public class CommonSuffixesTest {
    CommonSuffixes1 cs = new CommonSuffixes1();

    @Test
    public void test1() {
        Integer i1 = 1234567890;
        Integer i2 = 1234567890;
        String result = cs.largestCommonSuffix(i1.toString(), i2.toString());
        Assert.assertEquals(result, i1.toString());
    }
    @Test
    public void test2() {
        Integer i1 = 1234567890;
        Integer i2 = 123456789;
        String result = cs.largestCommonSuffix(i1.toString(), i2.toString());
        Assert.assertEquals(result, null);
    }
}