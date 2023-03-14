package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Sighting;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class JdbcSightingDao implements SightingDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSightingDao(DataSource dataSource) {

        //we are receiving the details of where the database is and the credentials
        //and feeding that to our jdbcTemplate so that when it runs sql it knows
        // where to run that sql
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Sighting createSighting(Sighting sighting) {

        //Step 1 - declare a variable that is of the type we want to return
        //because this is an insert, I will return the sighting at the end

        //Step 2 - create the sql to insert into the sighting table
        String sql = "INSERT INTO sighting(city, state_abbreviation, description, sighting_datetime)\n" +
                "VALUES (?, ?, ?, ?) RETURNING sighting_id;";

        //Step 3 - send this sql to the database
        int sightingId = jdbcTemplate.queryForObject(sql, int.class, sighting.getCity(), sighting.getStateAbbreviation(),
                sighting.getDescription(), sighting.getSightingDateTime());

        return getSighting(sightingId);
    }

    public Sighting getSighting(int id){

        //Step 1 - declare a variable that is of the type we want to return
        Sighting sighting = null;

        //Step 2 - write out our sql
        String sql = "SELECT sighting_id, identification_explanation, sighting_datetime, city, state_abbreviation, description, debunked, has_police_report\n" +
                "FROM sighting\n" +
                "WHERE sighting_id = ?;";

        //Step 3 - send our sql to the database
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        //Step 4 - convert our results to our return type
        if(results.next()){

            sighting = mapRowToSighting(results);

        }

        //Step 5 return the sighting
        return sighting;
    }

    private Sighting mapRowToSighting(SqlRowSet results) {
        Sighting sighting = new Sighting();

        int sightingId = results.getInt("sighting_id");
        sighting.setSightingId(sightingId);

        String identificationExplanation = results.getString("identification_explanation");
        sighting.setIdentificationExplaination(identificationExplanation);

        Timestamp sightingDateTime = results.getTimestamp("sighting_datetime");
        if(sightingDateTime != null){
            sighting.setSightingDateTime(sightingDateTime.toLocalDateTime());
        }

        sighting.setCity(results.getString("city"));
        sighting.setStateAbbreviation(results.getString("state_abbreviation"));
        sighting.setDescription(results.getString("description"));
        sighting.setDebunked(results.getBoolean("debunked"));
        sighting.setPoliceReport(results.getBoolean("has_police_report"));

        return sighting;
    }

    public List<Sighting> getSightingsByState(String state) {

        //Step 1
        List<Sighting> sightings = new ArrayList<>();

        //Step 2
        String sql = "SELECT sighting_id, identification_explanation, sighting_datetime, city, state_abbreviation, description, debunked, has_police_report\n" +
                "FROM sighting\n" +
                "WHERE state_abbreviation = ?;";

        //Step 3
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, state);

        //Step 4
        while(results.next()){
            Sighting sighting = mapRowToSighting(results);
            sightings.add(sighting);
        }

        //Step 5
        return sightings;
    }
}
