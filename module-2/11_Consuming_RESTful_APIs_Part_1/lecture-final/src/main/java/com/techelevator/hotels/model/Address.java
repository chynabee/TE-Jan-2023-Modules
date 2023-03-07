package com.techelevator.hotels.model;

public class Address {

    /*
     "id": "44144a78-725b-47bf-9516-fe9a9d65fbb2",
            "address": "1111 W 10th St",
            "address2": "",
            "city": "Cleveland",
            "state": "Ohio",
            "zip": "44113"
     */

    private String id;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return address + " " + address2 + " " + city + ", " + state + " " + zip;
    }
}
