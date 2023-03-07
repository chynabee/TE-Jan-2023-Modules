package com.techelevator.hotels.services;

import com.techelevator.hotels.model.AstronomyPicOfDay;
import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";

    // This is similar to our jdbc template. It is our "waiter" that will take our order
    // (in this case, an HTTP request) and deliver it to the kitchen (server) and then return
    // our food (results)
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {

        //define the path we want to call
        String path = API_BASE_URL + "hotels";
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
        return restTemplate.getForObject(path,Review[].class );
    }

    public Hotel[] getHotelsByStarRating(int stars) {

        String path = API_BASE_URL + "hotels?stars="+stars;
        return restTemplate.getForObject(path, Hotel[].class);
    }

    public AstronomyPicOfDay getWithCustomQuery(){

        String path = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
        return restTemplate.getForObject(path, AstronomyPicOfDay.class);
    }

}
