package com.techelevator;

import com.techelevator.mariokart.MediumCart;
import org.junit.Assert;
import org.junit.Test;

public class MarioTest {

    @Test
    public void test_mario_get_name(){

        //Arrange - create class you want to test
        MediumCart mario = new MediumCart("Mario");

        //Act - call the method we want to test
        // and store the result
        String result = mario.getName();

        //Assert - make sure our result is equal to what we
        //         expected
        Assert.assertEquals("Mario", result);

    }

    @Test
    public void test_luigi_get_name(){

        //Arrange - create class you want to test
        MediumCart mario = new MediumCart("Luigi");

        //Act - call the method we want to test
        // and store the result
        String result = mario.getName();

        //Assert - make sure our result is equal to what we
        //         expected
        Assert.assertEquals("Luigi", result);

    }
}
