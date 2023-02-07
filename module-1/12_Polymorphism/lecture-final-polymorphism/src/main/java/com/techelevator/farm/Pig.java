package com.techelevator.farm;

// can only extend ONE super class
// but can implement MANY interfaces (comma separated list)
public class Pig extends FarmAnimal implements Sellable, Singable
{
    private double price;

    public Pig()
    {
        super("Pig", "oink!!");

        // initializing the default value of price
        // IN THE CONSTRUCTOR (instead of inline with the variable)
        this.price = 4.5;
    }

    public double getPrice()
    {
        return price;
    }
}
