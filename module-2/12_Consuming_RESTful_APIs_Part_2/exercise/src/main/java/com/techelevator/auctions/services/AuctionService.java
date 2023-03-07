package com.techelevator.auctions.services;

import com.techelevator.util.BasicLogger;
import org.apiguardian.api.API;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction add(Auction newAuction) {

        String path = API_BASE_URL;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Auction> request = new HttpEntity<>(newAuction, headers);

        Auction returnedAuction = null;

        try{
            returnedAuction = restTemplate.postForObject(path, request, Auction.class);
        } catch (RestClientResponseException ex) {
            BasicLogger.log("Error:" + ex.getRawStatusCode() + " - " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            BasicLogger.log(ex.getMessage());
        }
        return returnedAuction;
    }

    public boolean update(Auction updatedAuction) {

        boolean successful = false;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Auction> request = new HttpEntity<>(updatedAuction, headers);

        try {
            String path = API_BASE_URL + updatedAuction.getId();
            restTemplate.put(path, request);
            successful = true;
        } catch (RestClientResponseException ex) {
            BasicLogger.log("Error:" + ex.getRawStatusCode() + " - " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            BasicLogger.log(ex.getMessage());
        }
        return successful;
    }

    public boolean delete(int auctionId) {
        boolean successful = false;

        try {
            String path = API_BASE_URL + auctionId;
            restTemplate.delete(path);
            successful = true;
        } catch (RestClientResponseException ex) {
            BasicLogger.log("Error:" + ex.getRawStatusCode() + " - " + ex.getStatusText());
        } catch (ResourceAccessException ex) {
            BasicLogger.log(ex.getMessage());
        }
        return successful;
    }

    public Auction[] getAllAuctions() {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction getAuction(int id) {
        Auction auction = null;
        try {
            auction = restTemplate.getForObject(API_BASE_URL + id, Auction.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?title_like=" + title, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?currentBid_lte=" + price, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    private HttpEntity<Auction> makeEntity(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(auction, headers);
    }

}
