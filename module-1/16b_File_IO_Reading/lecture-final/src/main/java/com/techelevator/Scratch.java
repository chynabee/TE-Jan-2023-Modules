package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scratch {

    //psvm
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the file you would like to read from");
        String fileName = input.nextLine();

        // TO OPEN A FILE AND SEARCH THROUGH IT:

        //Step 1: Create a file object in java from our file path and name
        File file = new File(fileName);

        //Step 2: Open a try with resources, and create a scanner to open the file
        try(Scanner fileScanner = new Scanner(file)){

            //Step 3: read from the file as long as there is a new line to read
            while(fileScanner.hasNextLine()) {

                //Step 4: read the line from the file and save it as a string
                String line = fileScanner.nextLine();

                //Step 5: implement an if, or whatever business logic you want
                // in this case, we want to print any check number that starts with "1"
                if(line.startsWith("1")) {
                    System.out.println(line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot find the file");
        }







        /*
        //sout
        System.out.println("Please enter how much money you would like to withdraw");

        String userEnteredNum = input.nextLine();

        try {
            int num = Integer.parseInt(userEnteredNum);

            //silly example to print out username's first initial, but it's going
            // to throw a null pointer exception
            String username = null;
            //System.out.println(username.substring(0,1));

            //we can throw our own Exception if we want
            if(num < 0) {
                throw new Exception("Amount is negative");
            }

            System.out.println("We are dispensing " + num + " dollars now");
        } catch(NumberFormatException numberFormatEx) {
            System.out.println("An error has occurred - please make sure you only enter numbers and no letters");
        } catch(NullPointerException nullPointerEx) {
            System.out.println("An error has occurred - check your work for nulls");
        } catch(Exception ex){ //this is a catch all because all exceptions inherit from Exception
            System.out.println("An error has occurred: " + ex.getMessage());
        } finally{
            // finally is completely optional, we only need to include it if we want it
            // it will always run whether the code was successful or threw an exception
            // we can also have only one finally block even tho we can have many catch blocks
            System.out.println("You are now being signed out");
        }

        System.out.println("You are now signed out. Please sign in with your PIN if you want to perform another transaction");


         */
    }
}
