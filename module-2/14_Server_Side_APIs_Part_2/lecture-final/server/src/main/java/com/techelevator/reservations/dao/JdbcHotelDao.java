package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Hotel;
import org.springframework.stereotype.Component;

import java.util.List;


public class JdbcHotelDao implements HotelDao{
    @Override
    public List<Hotel> list() {
        return null;
    }

    @Override
    public List<Hotel> getFilteredList(String state, String city) {
        return null;
    }

    @Override
    public void create(Hotel hotel) {

    }

    @Override
    public Hotel get(int id) {
        return null;
    }
}
