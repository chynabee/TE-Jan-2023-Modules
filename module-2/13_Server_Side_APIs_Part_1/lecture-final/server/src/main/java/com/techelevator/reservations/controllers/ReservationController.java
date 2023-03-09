package com.techelevator.reservations.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.apache.coyote.Request;

@RestController
@RequestMapping(path="/reservations")
public class ReservationController {

    private ReservationDao reservationDao;

    public ReservationController() {
        this.reservationDao = new MemoryReservationDao(new MemoryHotelDao());
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Reservation> getReservations(@RequestParam(required = false, defaultValue="0") int minGuests,
                                             @RequestParam(required = false, defaultValue="0") int maxGuests){

        List<Reservation> reservations = reservationDao.findAll();

        if(minGuests > 0 && maxGuests > 0) {
            List<Reservation> reservationsWGuests = new ArrayList<>();
            for(Reservation reservation : reservations) {
                if(reservation.getGuests() >= minGuests && reservation.getGuests() <= maxGuests){
                    reservationsWGuests.add(reservation);
                }
            }

            return reservationsWGuests;
        }else if(minGuests > 0) {
            List<Reservation> reservationsWGuests = new ArrayList<>();
            for(Reservation reservation : reservations) {
                if(reservation.getGuests() >= minGuests){
                    reservationsWGuests.add(reservation);
                }
            }

            return reservationsWGuests;
        } else if(maxGuests > 0) {
            List<Reservation> reservationsWGuests = new ArrayList<>();
            for(Reservation reservation : reservations) {
                if(reservation.getGuests() <= maxGuests){
                    reservationsWGuests.add(reservation);
                }
            }

            return reservationsWGuests;
        }
        else {
            return reservations;
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id){
        return reservationDao.get(id);
    }


    @RequestMapping(path="", method=RequestMethod.POST)
    public Reservation createReservation(@RequestBody Reservation reservation){
        return reservationDao.create(reservation, reservation.getHotelId());
    }

    @RequestMapping(path="", method=RequestMethod.PUT)
    public Reservation updateReservation(@RequestBody Reservation reservation){
        // call method to update the reservation
        return null;
    }

    @RequestMapping(path="", method=RequestMethod.DELETE)
    public void deleteReservation(@RequestBody Reservation reservation){
        // call method to delete the reservation
    }

}