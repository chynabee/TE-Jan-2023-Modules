package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.JdbcSightingDao;
import com.techelevator.tenmo.dao.SightingDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

//First thing to do with any controller
//is to indicate to spring that it is a controller
@RestController
public class SightingController {

    //instead of declaring a new dao, have spring wire it up for you
    // use the autowired annotation here, and make sure the dao
    // itself has the component annotation on it
    @Autowired
    private SightingDao sightingDao ;

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/sightings", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public Sighting createSighting(@RequestBody Sighting sighting, Principal token) {

        String username = token.getName();
        int userId = userDao.findIdByUsername(username);

        sighting.setSightingDateTime(LocalDateTime.now());
        return sightingDao.createSighting(sighting, userId);
    }

    @RequestMapping(path="sightings/{stateAbbreviation}", method = RequestMethod.GET)
    public List<Sighting> getSightings(@PathVariable String stateAbbreviation) {
        return sightingDao.getSightingsByState(stateAbbreviation);
    }

}
