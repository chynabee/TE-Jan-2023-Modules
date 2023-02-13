package com.techelevator.mariokart;

public class LargeCart extends Racer{

    public LargeCart(String name) {

        super(name, Racer.LARGE);
    }

    public int getMaxSpeed(){
        return 75;
    }

    public void bump(Racer racer){
        racer.addDamage();
    }
}
