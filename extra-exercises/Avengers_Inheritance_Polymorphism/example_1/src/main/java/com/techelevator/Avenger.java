package com.techelevator;

public class Avenger {

    //Instance variables - always make these private
    private String name;
    private String power;

    //Constructor
    public Avenger(String name, String power) {
        this.name = name;
        this.power = power;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
