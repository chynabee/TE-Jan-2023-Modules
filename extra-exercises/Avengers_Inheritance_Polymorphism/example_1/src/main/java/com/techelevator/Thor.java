package com.techelevator;

public class Thor extends Avenger implements Flyable{

    //private instant variable
    private boolean worthy;

    //Constructor
    public Thor() {

        //Are we all just accepting this hammer story? I don't get it.
        // Is it a magic hammer? Can the same magic apply to a spatula?
        // Is that less reasonable than a hammer?
        super("Thor", "Swinging Hammer Fast");

        //by default, let's say Thor is worthy
        worthy = true;
    }

    //Getters and Setters
    public boolean isWorthy() {
        return worthy;
    }

    public void setWorthy(boolean worthy) {
        this.worthy = worthy;
    }

    @Override
    public String getPower() {
        if(worthy) {
            return super.getPower();
        } else {
            return "I am not worthy! *** profuse crying *** ";
        }
    }

    //This implements the Flyable interface
    public void fly() {
        if(worthy) {
            System.out.println("Look at me fly like a helicopter!!!");
        } else {
            System.out.println(" *** more profuse crying *** ");
        }
    }
}
