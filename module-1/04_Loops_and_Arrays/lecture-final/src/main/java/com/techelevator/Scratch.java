package com.techelevator;

public class Scratch {

    public static void main(String[] args) {


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





    }

    public static void createArray(int numOfElements) {

        String[] myArray = new String[numOfElements];
        System.out.println("Length of my new array is " + myArray.length);

    }

}
