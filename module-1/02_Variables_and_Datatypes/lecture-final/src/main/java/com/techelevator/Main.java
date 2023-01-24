package com.techelevator;

public class Main {

    public static void main(String[] args) {

        //declaration      assignment
        String message = "Hello World";

        //we can assign new values to our variable
        // but the data type has to still always be a string
        message = "Christopher is the instructor for this cohort teaching Java";
        message = "2";

        //message = 2;


        int age = 38;
        //age = "Christopher";

        // We can use + for String concatenation
        String firstName = "Christopher";
        String lastName = "Guarnera";
        String fullName = firstName
                + " " + lastName;

        int deposit1 = 20;
        int deposit2 = 40;
        int deposit3 = 10;

        // with ints + means addition
        int myBalance = deposit1 + deposit2 + deposit3;

        int withdraw = 15;
        myBalance = myBalance - withdraw;

        int newBalance = myBalance - withdraw;
        myBalance = newBalance;

        myBalance= 5;


        double myAgeDouble = 38.9;
        int myAgeInt = 38;

        // implicit cast
        // myAgeDouble = myAgeInt;

        //explicit cast
        myAgeInt = (int)myAgeDouble;

        System.out.println(myAgeInt);

        //final makes it constant
        final int MEANING_OF_LIFE = 42;

        double result = 15 / 2.0;
        System.out.println(result);


    }
}
