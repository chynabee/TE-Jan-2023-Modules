package com.techelevator.dao;

import com.techelevator.models.Sighting;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcSightingDao implements SightingDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSightingDao(DataSource dataSource) {


        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Sighting createSighting (Sighting sighting) {

        //Step 1: declare a variable that is of the type that we want to return
        //because this is an insert, I will return the sighting at the end


        //Step 2: create the sql to insert into the sighting table
        String sql = "INSERT INTO sighting (city, state_abbreviation, description, sighting_datetime)\n" +
                "VALUES (?, ?, ?, ?) RETURNING sighting_id;";

        //Step 3: send this sql to the database
        int sighting_id = jdbcTemplate.queryForObject(sql, int.class, sighting.getCity(), sighting.getStateAbbreviation(),
                sighting.getDescription(), sighting.getSightingDateTime())


        return null;
    }

}
