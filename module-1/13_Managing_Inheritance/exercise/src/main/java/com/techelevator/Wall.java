package com.techelevator;

public abstract class Wall {
    private String name;
    private String color;

    //Constructors
    public Wall(String name, String color) {
        this.name = name;
        this.color = color;
    }

    //Getters
    public String getName() {return name;}
    public String getColor() {return color;}


    //Method

    public abstract int getArea();


}
