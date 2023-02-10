package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {

    @Test

    public void testArrayOfLargerNumberOfFirstLast () {

        MaxEnd3 maxEnd3 = new MaxEnd3();

        int [] result = maxEnd3.makeArray(new int[] {0,2,3});

        Assert.assertArrayEquals(new int[] {3,3,3}, result);
    }


   }
