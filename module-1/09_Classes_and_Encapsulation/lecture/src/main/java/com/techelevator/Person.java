package com.techelevator;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person() {
        // just a default constructor, nothing initialized
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //This is an instance method
    public void introduceSelf() {
        System.out.println("Hello, my name is " + firstName + " " + lastName );
    }

    //getter
    public int getAge() {
        return age;
    }

    //setter
    public void setAge(int age) {
        this.age = age;
    }

    //derived property
    public boolean canVote() {
        return age >= 18;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}











