package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";

    //This RestTemplate is similar to our jdbc Template. It is our "waiter" that will take our order
    //(in this case, an HTTP request) and deliver it to the kitchen (server) and then return our food(results)
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {

        //Step 1: specify what path I am calling
        String path = API_BASE_URL + "hotels"; //same as path in postman localhost:3000/hotels

        //Step 2: return the array of the hotels. Return the template as getForObject then in parentheses we
        //include the String(path) and then the array (Hotel[]) and always add .class after
        return restTemplate.getForObject(path, Hotel[].class);

    }

    public Review[] listReviews() {

        String path = API_BASE_URL + "reviews";
        return restTemplate.getForObject(path, Review[].class);
    }

    public Hotel getHotelById(int id) {

        String path = API_BASE_URL + "hotels/" + id;
        return restTemplate.getForObject(path, Hotel.class);
    }

    public Review[] getReviewsByHotelId(int hotelId) {

        String path = API_BASE_URL + "hotels/" + hotelId + "/reviews";
        return restTemplate.getForObject(path, Review[].class);


    }

    public Hotel[] getHotelsByStarRating(int stars) {

        String path = API_BASE_URL + "hotels?stars=" + stars; //in postman localhost:3000/hotels?stars=4
        return restTemplate.getForObject(path, Hotel[].class);

    }

    public City getWithCustomQuery(){


        return null;
    }

}
