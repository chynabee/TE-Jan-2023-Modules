package com.techelevator.mariokart;

public class MediumCart extends Racer{

    public MediumCart(String name){
        super(name, Racer.MEDIUM);
    }

    public int getMaxSpeed() {
        return 125;
    }
}
