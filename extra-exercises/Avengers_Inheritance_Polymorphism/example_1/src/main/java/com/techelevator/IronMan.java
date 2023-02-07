package com.techelevator;

public class IronMan extends Avenger implements Flyable {

    public IronMan(){
        super("Iron Man", "Advanced Technology");
    }

    //This implements the Flyable interface
    public void fly() {
        System.out.println("Iron Man is flying");
    }

}
