package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {
    @Test

    public void test_get_a_table() {


        //Arrange - declare class I want to test
        DateFashion dateFashion = new DateFashion();

        //Act - call the method I want to test and store the result
        int result = dateFashion.getATable(5, 10);

        //Assert - make sure result is the same as what we expect
        Assert.assertEquals(2, result);

    }

    @Test
    public void test_get_a_maybe() {

        //Arrange - declare class I want to test
        DateFashion dateFashion = new DateFashion();

        //Act - call the method I want to test and store the result
        int result = dateFashion.getATable(5, 5);

        //Assert - make sure result is the same as what we expect
        Assert.assertEquals(1, result);

    }

    @Test
    public void test_get_a_no() {
        //Arrange - declare class I want to test
        DateFashion dateFashion = new DateFashion();

        //Act - call the method I want to test and store the result
        int result = dateFashion.getATable(5, 2);

        //Assert - make sure result is the same as what we expect
        Assert.assertEquals(0, result);
    }
}