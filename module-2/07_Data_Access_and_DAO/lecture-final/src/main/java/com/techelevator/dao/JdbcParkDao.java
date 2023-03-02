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

    public  List<Park> searchByParkName(String name) {

        //Step 1 - A list of parks are what we want to return
        List<Park> parks = new ArrayList<>();

        //Step 2 - Write our sql
        String sql = "SELECT park.park_id, park_name, date_established, park.area, has_camping\n" +
                "FROM park\n" +
                "JOIN park_state\n" +
                "\tON park.park_id = park_state.park_id\n" +
                "JOIN state\n" +
                "\tON park_state.state_abbreviation = state.state_abbreviation\n" +
                "WHERE park_name ILIKE ? OR state_name ILIKE ?;";

        //Step 3 - Send our SQL to the database
        // for our searchTerm we want to manually add the wild card characters to indicate what the LIKE should
        // look for
        String parkSearchTerm = "%" + name + "%";
        String stateSearchTerm = "%" + name + "%";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkSearchTerm, stateSearchTerm);

        //Step 4 :
        while(results.next()){
            Park park = mapRowToPark(results);
            parks.add(park);
        }

        //Step 5
        return parks;
    }


    @Override
    public Park createPark(Park park) {

        //Step 1 - declare the variable that we want to return

        // Don't really need this because we are already receiving a park as a parameter
        // and we can also just pull the park we create from the database


        //Step 2 - create the sql we want to run on the database
        String sql = "INSERT INTO park(park_name, date_established, area, has_camping)\n" +
                        "VALUES(?,?,?, ?)  RETURNING park_id;";

        //Step 3 - send the sql to the database

        int parkId = jdbcTemplate.queryForObject(sql, // from this tried and true recipe
                                                 int.class, // we made this cake
                                                 park.getParkName(), //using these ingredients
                                                 park.getDateEstablished(),
                                                 park.getArea(),
                                                 park.getHasCamping());

        //Step 4 - convert our results to the return type we want


        //Step 5 return our value
        return getPark(parkId);
    }

    @Override
    public void updatePark(Park park) {
        //Step 1 - declare a variable for our return type
        // There is no return type

        //Step 2 - declare our sql
        String sql = "UPDATE park\n" +
                    "SET park_name = ?,\n" +
                    "    date_established = ?,\n" +
                    "\tarea = ?,\n" +
                    "\thas_camping = ?\n" +
                    "WHERE park_id = ?;";

        //Step 3 - send our sql to the database
        jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(), park.getArea(),
                park.getHasCamping(), park.getParkId());

        //Step 4 - convert any results
        // no results to convert

        //step 5 return our data
        // nothing to return
    }

    @Override
    public void deletePark(int parkId) {

        //Step 1 - declare a variable for our return type
        // There is no return type

        //Step 2 - write the sql

        //First delete any foreign key records from the park_state table
        String sql1 = "DELETE \n" +
                "FROM park_state\n" +
                "WHERE park_id = ?;";
        jdbcTemplate.update(sql1, parkId);

        //Now I can delete from the park table without violating any key constraints
        String sql2 = "DELETE\n" +
                "FROM park\n" +
                "WHERE park_id = ?;";

        //Step 3 - send the query to the database
        jdbcTemplate.update(sql2, parkId);
    }

    @Override
    public void addParkToState(int parkId, String stateAbbreviation) {

        String sql = "INSERT INTO park_state(park_id, state_abbreviation)\n" +
                "VALUES (?, ?);";

        jdbcTemplate.update(sql, parkId, stateAbbreviation);

    }

    @Override
    public void removeParkFromState(int parkId, String stateAbbreviation) {

        String sql = "DELETE\n" +
                "FROM park_state\n" +
                "WHERE park_id = ? AND state_abbreviation = ?;";

        jdbcTemplate.update(sql, parkId, stateAbbreviation );
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
