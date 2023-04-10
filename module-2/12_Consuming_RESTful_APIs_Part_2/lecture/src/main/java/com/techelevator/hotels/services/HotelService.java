package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {

        String path = API_BASE_URL + "reservations";

        //Anytime that we are doing a POST or PUT we will create these headers and indicate
        //content type is JSON FORMAT
        //These two lines will typically be the same in either context
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Now we add the data we are sending along with the headers to the request
        //the data type in the <> always represents what data type we are sending
        HttpEntity<Reservation> request = new HttpEntity<>(newReservation, headers);


       //Instead of getForObject we use postForObject to do the post
       //which will create the new reservation and return it with an id
        Reservation returnedReservation = null;
        try { //always do a try/catch
             returnedReservation = restTemplate.postForObject(path, request, Reservation.class);
        } catch (RestClientResponseException ex) {
            //RestClientResponseException means that we found the server but something went wrong and the server
            //is sending us back a status code and message that we can use
            BasicLogger.log("Error:" + ex.getRawStatusCode() + " - " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            //ResourceAccessException means that we could not find the server or something we were asking for from the server
            BasicLogger.log(ex.getMessage());
        }

        return returnedReservation;
    }

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     */
    public boolean updateReservation(Reservation updatedReservation) {

        boolean successful = false;
        String path = API_BASE_URL + "reservations/" + updatedReservation.getId();

        //declare our headers that we are sending json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Pass in variable name of what we are sending and headers in parentheses
        HttpEntity<Reservation> request = new HttpEntity<>(updatedReservation, headers);

        //not getting anything returned since we are updating something. So just path and request in the parentheses
        try {
            restTemplate.put(path, request);
            successful = true;
        } catch (RestClientResponseException ex) {
            //RestClientResponseException means that we found the server but something went wrong and the server
            //is sending us back a status code and message that we can use
            BasicLogger.log("Error:" + ex.getRawStatusCode() + " - " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            //ResourceAccessException means that we could not find the server or something we were asking for from the server
            BasicLogger.log(ex.getMessage());
        }
        return successful;
    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {

        boolean successful = false;

        try{
        String path = API_BASE_URL + "reservations/" + id;
        restTemplate.delete(path);
        successful = true;
        } catch (RestClientResponseException ex) {
            //RestClientResponseException means that we found the server but something went wrong and the server
            //is sending us back a status code and message that we can use
            BasicLogger.log("Error:" + ex.getRawStatusCode() + " - " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            //ResourceAccessException means that we could not find the server or something we were asking for from the server
            BasicLogger.log(ex.getMessage());
        }

        return successful;
    }

    /* DON'T MODIFY ANY METHODS BELOW */

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        Hotel[] hotels = null;
        try {
            hotels = restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
        } catch (RestClientResponseException e) {
            // handles exceptions thrown by rest template and contains status codes
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            // i/o error, ex: the server isn't running
            BasicLogger.log(e.getMessage());
        }
        return hotels;
    }

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * Find a single reservation by the reservationId
     */
    public Reservation getReservation(int reservationId) {
        Reservation reservation = null;
        try {
            reservation = restTemplate.getForObject(API_BASE_URL + "reservations/" + reservationId, Reservation.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }

}