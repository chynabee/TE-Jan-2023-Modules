package com.techelevator.farm;

public class Egg implements Sellable
{
    // default values can be set either in the constructor
    // or inline with the variable declaration
    private String name = "Egg";
    private double price = 1.5;

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }
}
