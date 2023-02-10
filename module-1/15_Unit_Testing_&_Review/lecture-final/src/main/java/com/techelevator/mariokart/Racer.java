package com.techelevator.mariokart;

import java.io.Serializable;

public abstract class Racer implements Serializable, Comparable {

    public static final String LARGE = "Large";
    public static final String MEDIUM = "Medium";
    public static final String SMALL = "Small";

    // instance variables
    private String name;
    private String size;
    private String catchPhrase;

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
        return name ;
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

    @Override
    public int compareTo(Object o) {
        Racer racer = (Racer) o;
        return getName().compareTo(racer.getName());
    }
}
