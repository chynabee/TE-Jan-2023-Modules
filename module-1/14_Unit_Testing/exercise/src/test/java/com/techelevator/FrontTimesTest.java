package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {
    @Test
    public void test_first_3_chars() {


        //Arrange - declare class I want to test
        FrontTimes frontTimes = new FrontTimes();

        //Act - call the method I want to test and store the result
        String result = frontTimes.generateString("Chocolate", 2);

        //Assert - make sure result is the same as what we expect
        Assert.assertEquals("ChoCho", result);

    }

    @Test
    public void test_first_3_chars_3() {


        //Arrange - declare class I want to test
        FrontTimes frontTimes = new FrontTimes();

        //Act - call the method I want to test and store the result
        String result = frontTimes.generateString("Chocolate", 3);

        //Assert - make sure result is the same as what we expect
        Assert.assertEquals("ChoChoCho", result);


    }

    @Test
    public void test_first_3_chars_less_than_3() {


        //Arrange - declare class I want to test
        FrontTimes frontTimes = new FrontTimes();

        //Act - call the method I want to test and store the result
        String result = frontTimes.generateString("Abc", 3);

        //Assert - make sure result is the same as what we expect
        Assert.assertEquals("AbcAbcAbc", result);


    }
}
