package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Sighting;

import java.util.List;

public interface SightingDao {

    public Sighting createSighting(Sighting sighting, int userId);
    public Sighting getSighting(int id);
    public List<Sighting> getSightingsByState(String state);


}
