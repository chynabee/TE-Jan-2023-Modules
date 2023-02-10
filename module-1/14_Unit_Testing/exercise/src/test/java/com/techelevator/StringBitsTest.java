package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {

    @Test
    public void testBits() {

        //Arrange - declare class I want to test
        StringBits stringbits = new StringBits();

        //Act - call the method I want to test and store the result
        String Hello = "Hello";
        String result = stringbits.getBits(Hello);

        //Assert - make sure result is the same as what we expect
        Assert.assertEquals("Hlo", result);
    }

}













