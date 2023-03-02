package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {

        //Arrange - done in the setup and constants

        //Act - I call the method that I want to test and store the result
        Park result = sut.getPark(1);

        //Assert - I can make sure that the result is what I expect
      /*  Assert.assertEquals(PARK_1.getParkId(), result.getParkId());
        Assert.assertEquals(PARK_1.getParkName(), result.getParkName());
        Assert.assertEquals(PARK_1.getArea(), result.getArea(), .01);
        Assert.assertEquals(PARK_1.getDateEstablished(), result.getDateEstablished());
        Assert.assertEquals(PARK_1.getHasCamping(), result.getHasCamping()); *

       */

        assertParksMatch(PARK_1, result);
    }

    @Test
    public void getPark_returns_null_when_id_not_found() {

        //Act
        Park result = sut.getPark(999);

        //Assert
        Assert.assertNull(result);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {

        //Act
        List<Park> result = sut.getParksByState("AA");

        //Assert
        Assert.assertEquals(2, result.size());
        assertParksMatch(PARK_1, result.get(0));
        assertParksMatch(PARK_3, result.get(1));

    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
       //Act
        List<Park> result = sut.getParksByState("XX");

        //Assert
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        //Arrange
        Park newPark = new Park(0,"Test Park", LocalDate.now(), 999, true);

        //Act
        Park createdPark = sut.createPark(newPark);

        //Assert
        Assert.assertTrue(createdPark.getParkId() > 0);

        //the only difference between newPark and createdPark should be the id
        //so to make them exactly equal, I will set the id
        newPark.setParkId(createdPark.getParkId());

        //now that they should be the same, I can assert
        assertParksMatch(newPark, createdPark);

    }


    @Test
    public void created_park_has_expected_values_when_retrieved() {
        //Arrange
        Park newPark = new Park(0,"Test Park", LocalDate.now(), 999, true);

        //Act
        Park createdPark = sut.createPark(newPark);
        Park retrievedPark = sut.getPark(createdPark.getParkId());

        //Assert
        assertParksMatch(createdPark, retrievedPark);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {

        //Arrange - should change every column to a new value except the id column
        Park parkToUpdate = sut.getPark(1);
        parkToUpdate.setArea(9999);
        parkToUpdate.setParkName("Test");
        parkToUpdate.setDateEstablished(LocalDate.now());
        parkToUpdate.setHasCamping(false);

        //Act
        sut.updatePark(parkToUpdate);

        //Assert
        Park parkInDatabase = sut.getPark(1);
        assertParksMatch(parkToUpdate, parkInDatabase);
    }

    @Test
    public void deleted_park_cant_be_retrieved() {

        //Act
        sut.deletePark(1);

        //Assert
        Park retrievePark = sut.getPark(1);
        Assert.assertNull(retrievePark);

        //instead of 2 results this should now be 1 result
        List<Park> parksForAA = sut.getParksByState("AA");
        Assert.assertEquals(1, parksForAA.size());
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
         //Act
        sut.addParkToState(1, "CC");

        //Assert
        List<Park> parks = sut.getParksByState("CC");
        Assert.assertEquals(2, parks.size());
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        //Act - remove park 2 from state BB
        sut.removeParkFromState(2, "BB");

        //Assert
        List<Park> parks = sut.getParksByState("BB");
        Assert.assertEquals(0, parks.size());

    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
