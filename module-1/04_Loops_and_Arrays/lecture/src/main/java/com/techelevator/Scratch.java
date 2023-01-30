package com.techelevator;

public class Scratch {

    public static void main(String[] args) {

        String[] groceries = new String[] {"bread", "milk", "eggs", "cereal"};

        System.out.println(groceries.length);

        //first element
        System.out.println(groceries[0]);

        String last = groceries[ groceries.length-1];
        System.out.println(last);

        for(int i=0; i < 5; i++){
            System.out.println("Hello World "+ i);

        }
        //starting at 0 moving from beginning to end
        for(int i=0; i < groceries.length; i++){
            System.out.println( groceries[i] + " is at index " + i );
        }
        //starting at the last index making sure we dont go past 0 working your way down by 1 each time
        //from end to beginning
        for(int i= groceries.length-1; i >= 0; i--) {
            System.out.println( groceries[i] + " is at index " + i );
        }


        /*


        createArray(5);

        createArray(10);

        createArray(1000);

        createArray(1000000);

                */
    }

    public static void createArray(int numOfElements) {

        String[] myArray = new String[numOfElements];
        System.out.println("Length of my new array is" + myArray.length);
    }

}
