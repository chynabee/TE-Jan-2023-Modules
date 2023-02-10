package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {
    @Test

    public void test_min_cigar_count() {
        //Arrange-
        CigarParty cigarParty = new CigarParty();


        //Act
        boolean result = cigarParty.haveParty(42, true);


        //Assert
        Assert.assertEquals(true, result);

    }
}
