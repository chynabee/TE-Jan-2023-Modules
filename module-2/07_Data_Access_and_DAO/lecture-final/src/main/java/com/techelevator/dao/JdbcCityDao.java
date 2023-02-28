package com.techelevator.dao;

import com.techelevator.model.City;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCityDao implements CityDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCityDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public City getCity(int cityId) {
        City city = null;
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                     "FROM city " +
                     "WHERE city_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cityId);
        if (results.next()) {
            city = mapRowToCity(results);
        }
        return city;
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                     "FROM city " +
                     "WHERE state_abbreviation = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while (results.next()) {
            cities.add(mapRowToCity(results));
        }
        return cities;
    }

    @Override
    public City createCity(City city) {
        //Step 1 - there's nothing to return

        //Step 2 - we declare our sql
        String sql = "INSERT INTO city (city_name, state_abbreviation, population, area) " +
                     "VALUES (?, ?, ?, ?) RETURNING city_id;";

        //Step 3 - send results to the database
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                city.getCityName(), city.getStateAbbreviation(), city.getPopulation(), city.getArea());

        //Step 4 - it's already an int, nothing to convert

        //Step 5 - return the city based on the new id we got back
        return getCity(newId);
    }

    @Override
    public void updateCity(City city) {
        String sql = "UPDATE city " +
                    "SET city_name = ?, state_abbreviation = ?, population = ?, area = ? " +
                    "WHERE city_id = ?;";
        jdbcTemplate.update(sql, city.getCityName(), city.getStateAbbreviation(), city.getPopulation(),
                city.getArea(), city.getCityId());
    }

    @Override
    public void deleteCity(int cityId) {
        String sql = "DELETE FROM city WHERE city_id = ?;";
        jdbcTemplate.update(sql, cityId);
    }

    private City mapRowToCity(SqlRowSet rowSet) {
        City city = new City();

        int cityId = rowSet.getInt("city_id");
        city.setCityId(cityId);

        city.setCityName(rowSet.getString("city_name"));
        city.setStateAbbreviation(rowSet.getString("state_abbreviation"));
        city.setPopulation(rowSet.getInt("population"));
        city.setArea(rowSet.getDouble("area"));
        return city;
    }
}
