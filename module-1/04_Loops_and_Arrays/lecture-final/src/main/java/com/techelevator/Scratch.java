package com.techelevator;

public class Scratch {

    public static void main(String[] args) {

/*
        String[] groceries = {"bread", "milk", "eggs"};

        System.out.println( groceries.length );

        //first element
        System.out.println( groceries[0]);

        String last = groceries[ groceries.length-1 ];
        System.out.println(last);

        String element = groceries[1];
        System.out.println(element);

        //   init    condition  iterator
        for(int i=0; i < 5; i++  ){
            System.out.println("Hello World " + i);

        }

        System.out.println("*****");

        // Going from beginning to end
        for(int i=0; i < groceries.length; i++) {
            System.out.println( groceries[i] + " is at index " + i);
        }

        System.out.println("*****");

        // Going from end to beginning
        for(int i= groceries.length-1; i >= 0; i--) {
            System.out.println( groceries[i] + " is at index " + i);
        }

        System.out.println("*****");

        for(int i=0; i < groceries.length; i = i + 2){
            System.out.println( groceries[i] + " is at index " + i);
        }

        System.out.println("After the for loop");


        /*

        createArray(5);

        createArray(10);

        createArray(1000);

        createArray(100000000);


         */

        /*
        1. init (int i = 0) : this is where we are setting the stage, waiting for something to happen.
                                No one has knocked on the door yet
         2. condition i < 5 : this is setting the expectation for how many times we have to count
                                I'm waiting for 5 knocks
        3. iterator i++ : this is how we are counting (either one at a time with i++, or two at a time with i +=2, or counting down i--, etc.
         */
        for(int i = 0; i < 5; i++) {
            System.out.println("knock");
        }

        System.out.println("open the door");

        int[] checks = {20, 50, 100, 20};
        int accountBalance = 0;


        //deposit each check

        for(int i = 0; i < checks.length; i++ ) {

            // += is shorthand and means the same thing as accountBalance = accountBalance + checks[i];
            accountBalance += checks[i];

        }

        System.out.println("Our account balance is " + accountBalance);
    }

    public static void createArray(int numOfElements) {

        String[] myArray = new String[numOfElements];
        System.out.println("Length of my new array is " + myArray.length);

    }

}
