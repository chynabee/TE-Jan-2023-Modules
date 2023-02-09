package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {

    @Test
    public void test_getHerd(){

        //Arrange - declare class I want to test
        AnimalGroupName animalGroupName = new AnimalGroupName();

        //Act - call the method I want to test and store the result
        String result = animalGroupName.getHerd("giraffe");

        //Assert - make sure result is the same as what we expect
        Assert.assertEquals("Tower", result);

    }

    @Test
    public void test_getHerd_Empty(){

        //Arrange - declare class I want to test
        AnimalGroupName animalGroupName = new AnimalGroupName();

        //Act - call the method I want to test and store the result
        String result = animalGroupName.getHerd("");

        //Assert - make sure result is the same as what we expect
        Assert.assertEquals("unknown", result);

    }

    @Test
    public void test_getHerdWalrus(){

        //Arrange - declare class I want to test
        AnimalGroupName animalGroupName = new AnimalGroupName();

        //Act - call the method I want to test and store the result
        String result = animalGroupName.getHerd("walrus");

        //Assert - make sure result is the same as what we expect
        Assert.assertEquals("unknown", result);

    }
}
