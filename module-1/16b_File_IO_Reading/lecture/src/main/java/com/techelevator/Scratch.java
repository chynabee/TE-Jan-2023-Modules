package com.techelevator;

import java.util.Scanner;

public class Scratch {
    //psvm
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //sout
        System.out.println("Please enter how much money you would like to withdraw");

        String userEnteredNum = input.nextLine();

        try {
            int num = Integer.parseInt(userEnteredNum);

            //silly example to print out usernames first initial but its going to
            //throw a null pointer exception
            String username = null;
            System.out.println(username.substring(0, 1));


            System.out.println("We are dispensing " + num + " dollars now");

        } catch (NumberFormatException ex) {
            System.out.println("An error has occurred - Please make sure you only enter numbers and no letters");
        } catch (NullPointerException ex) {
            System.out.println("An error has occurred - please try again");
        } finally {
            //finally is completely optional, we only need to include it if we want it
            //it will always run whether the code was successful or threw an exception
            System.out.println("You are now being signed out");
        }

        System.out.println("You are now signed out. Please sign in with your PIN if you want to perform another transaction");
    }

}




