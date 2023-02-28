package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*
    1. If we want results that are multiple columns and/or multiple rows then we can use
        jdbcTemplate.queryForRowSet
    2. If we want only a single value back from a query (one row one column) then we can use
        jdbcTemplate.queryForObject
    3. If we don't care about receiving results back and just want the query to run, we can use
        jdbcTemplate.update


     */

    @Override
    public Park getPark(int parkId) {

        //Step 1 - we want to declare the variable we are returning
        // make sure that you look at the return type for the method (right before the method name)
        Park park = null;

        //Step 2 - write out your sql in pg admin and then save it to a variable here
        // in intellij. Make sure that any variables we want to include in our query
        // we represent as ?
        String sql = "SELECT park_id, park_name, date_established, area, has_camping\n" +
                    "FROM park\n" +
                    "WHERE park_id = ?;";

        //Step 3 - use our jdbcTemplate to send out SQL to the database, and store the results
        // if we have any
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);

        //Step 4 - convert our results to whatever data type we are returning
        if(results.next()) {
            park = mapRowToPark(results);
        }

        //Step 5 - return our result
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        //Step 1 - declare the variable we want to return
        List<Park> parks = new ArrayList<>();

        //Step 2 - declare our sql
        String sql = "SELECT park.park_id, park_name, date_established, area, has_camping\n" +
                "FROM park\n" +
                "JOIN park_state\n" +
                "\tON park.park_id = park_state.park_id\n" +
                "WHERE state_abbreviation = ?;";

        //Step 3 - use the jdbcTemplate to send the sql to the database
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        //Step 4 - convert our results to our return type
        while(results.next()) {
            Park park = mapRowToPark(results);
            parks.add(park);
        }

        //Step 5 - return the parks
        return parks;
    }

    @Override
    public Park createPark(Park park) {
        return new Park();
    }

    @Override
    public void updatePark(Park park) {

    }

    @Override
    public void deletePark(int parkId) {

    }

    @Override
    public void addParkToState(int parkId, String stateAbbreviation) {

    }

    @Override
    public void removeParkFromState(int parkId, String stateAbbreviation) {

    }

    private Park mapRowToPark(SqlRowSet results) {
        Park park = new Park();

        int parkIdFromDB = results.getInt("park_id");
        park.setParkId(parkIdFromDB);

        String parkName = results.getString("park_name");
        park.setParkName(parkName);

        // If we are retrieving a date, make sure to select java.sql.Date, and then
        // afterward call .toLocalDate().
        // BUT if there is an opportunity for this date to be null, we don't want
        // to convert to localDate because it will throw a null pointer exception
        // so wrap it in an if to make sure it's not null
        Date establishedDate = results.getDate("date_established");
        if(establishedDate != null ) {
            park.setDateEstablished(establishedDate.toLocalDate());
        }

        double area = results.getDouble("area");
        park.setArea(area);

        boolean hasCamping = results.getBoolean("has_camping");
        park.setHasCamping(hasCamping);

        return park;
    }
}
