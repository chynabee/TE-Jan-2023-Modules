package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/hotels")
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Hotel> list(@RequestParam(required=false) String state,
                            @RequestParam(required=false) String city) {

        if(state != null && city != null){
            return hotelDao.getFilteredList(state, city);
        }

        return hotelDao.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDao.get(id);
    }

    //localhost:8080/hotels/3/reservations
    @RequestMapping(path="/{hotelId}/reservations", method= RequestMethod.GET)
    public List<Reservation> getReservationsByHotel(@PathVariable int hotelId){
        return reservationDao.findByHotel(hotelId);
    }


}
