package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {
    @Test
    public void testSameFirstLast1 () {




        //Arrange - declare class I want to test
        SameFirstLast sameFirstLast = new SameFirstLast();

        //Act - call the method I want to test and store the result
        boolean result = sameFirstLast.isItTheSame(new int[]{2, 1, 2});

        //Assert - make sure result is the same as what we expect
        Assert.assertEquals(true, result);

    }

    @Test

    public void testSameFirstLastFalse() {


        SameFirstLast sameFirstLast = new SameFirstLast();

        boolean result = sameFirstLast.isItTheSame(new int[]{1, 2, 3});

        Assert.assertEquals(false, result);


    }
}

