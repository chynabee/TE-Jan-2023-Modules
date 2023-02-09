package com.techelevator.mariokart;

public abstract class Racer {

    public static final String LARGE = "Large";
    public static final String MEDIUM = "Medium";
    public static final String SMALL = "Small";

    // instance variables
    private String name;
    private String size;

    //constructor
    public Racer(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public static void sayCatchPhrase(){
        System.out.println("Mama-mia");
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract int getMaxSpeed();

    public String getName() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


}
