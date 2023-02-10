package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {

    @Test
    public void testIfNo3s() {

        Lucky13 lucky13test3 = new Lucky13();

        boolean result = lucky13test3.getLucky(new int[] {0,2,4});

        Assert.assertEquals(true, result);
    }

    @Test
    public void testIfNo1s() {

        Lucky13 lucky13test1 = new Lucky13();

        boolean result = lucky13test1.getLucky(new int[]{3, 3, 2});

        Assert.assertEquals(false, result);
    }


        public void testIfNo1True () {

            Lucky13 lucky13test1true = new Lucky13();

            boolean result = lucky13test1true.getLucky(new int[]{1, 3, 4});

            Assert.assertEquals(true, result);
        }
    }




