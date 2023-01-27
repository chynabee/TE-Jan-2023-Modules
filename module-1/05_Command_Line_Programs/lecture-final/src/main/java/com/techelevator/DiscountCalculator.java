package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");

        String discountAmountStr = input.nextLine();

        //To convert the string we got from the console to a double value
        // we can call Double.parseDouble. If we had wanted an int we could have done
        // Integer.parseInt(discountAmountStr)
        double discountAmount = Double.parseDouble(discountAmountStr)/100; //divided by 100 to get the fraction;


        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");

        String pricesStr = input.nextLine();

        // If we want to take that string and convert into an array of prices:
        String[] prices = pricesStr.split(" ");

        for(int i =0; i < prices.length; i++) {

            double price = Double.parseDouble( prices[i] );
            double discountedPrice = price - (price * discountAmount);
            System.out.println("Our original price " + price + " is now discounted to " + discountedPrice);
        }




        System.out.println("Finished");



    }

}