package com.techelevator;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Budget {

    //psvm
    public static void main(String[] args) {

        //compile types of expenses into appropriate categories

        System.out.print("Please enter the path of the file:");

        //Create a scanner to read in from the console
        // Scanner means we are going to read from external sources
        // System.in indicates the external source is our console
        // so we are making this to read input from our console
        Scanner consoleInput = new Scanner(System.in);

        //nextLine() paused the program and waits until someone enters text
        //into the console and presses enter
        String fileName = consoleInput.nextLine();

        System.out.println("You entered: " + fileName);

        //They gave us a file name, so let's create a file object
        File file = new File(fileName);

        //Because the file is an external resource and may have been deleted at some point,
        // or the user gave us the wrong path - we want to make sure this is in a try
        // because there is an opportunity for it to throw an exception
        try(Scanner fileScanner = new Scanner(file)){

            Map<String, Integer> budgetMap = new HashMap<>();

            //As long as there is a line of text in the file to read,
            // keep reading it
            while(fileScanner.hasNextLine()) {

                //Get the individual line of text
                String line = fileScanner.nextLine();

                // break the line into separate parts based on where the space is
                String[] splitLine = line.split(" ");

                //get the category
                String category = splitLine[0];

                //get the amount. Because it's a string, we need to convert to integer
                int amount = Integer.parseInt(splitLine[1]);


                //does our map already have the category?
                if(budgetMap.containsKey(category)){
                    //if so, add to the existing amount
                    int categoryAmount = budgetMap.get(category);
                    categoryAmount += amount;
                    budgetMap.put(category, categoryAmount);
                } else {
                    //otherwise input directly into our map
                    budgetMap.put(category, amount);
                }

            }

            //Iterate through our map and print out all of our categories and totals
            for(Map.Entry<String, Integer> entry : budgetMap.entrySet()){
                System.out.println(entry.getKey() + ": $" + entry.getValue());
            }

        }
        // We can do the specific exception, and then give specific feedback
        // or we can do the catch all where we just look for Exception because it
        // is the parent class of all Exceptions
        // catch(FileNotFoundException ex) {
        catch(Exception exception) {
            System.out.println("Something went wrong");
        }

    }

}
