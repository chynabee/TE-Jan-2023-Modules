package com.techelevator.dao;

import com.techelevator.model.Sighting;

import java.util.List;

public interface SightingDao {

    public Sighting createSighting(Sighting sighting);
    public Sighting getSighting(int id);
    public List<Sighting> getSightingsByState(String state);
}
