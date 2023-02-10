package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {
    @Test

    public void testIf1LessThan20() {


        //Arrange - declare class I want to test
        Less20 less20 = new Less20();

        //Act - call the method I want to test and store the result
        boolean result = less20.isLessThanMultipleOf20(19);

        //Assert - make sure result is the same as what we expect
        Assert.assertEquals(true, result);
    }

    @Test

    public void testIf2LessThan20(){

        Less20 less20 = new Less20();

        boolean result = less20.isLessThanMultipleOf20(40);

        Assert.assertEquals(false, result);

    }
    @Test
    public void testIf2LessThan20True() {

        Less20 less20 = new Less20();

        boolean result = less20.isLessThanMultipleOf20(18);

        Assert.assertEquals(true, result);

    }
}

