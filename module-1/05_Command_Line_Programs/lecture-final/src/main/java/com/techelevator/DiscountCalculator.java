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


        String name = "Christopher";
        String name2 = new String("Christopher");

        String[] names = new String[1000000];

        int person1Age = 19;
        int person2Age = 34;
        int person3Age = 28;
        int person4Age = 50;
        int person5Age = 100;

     //   int averageAge = (person1Age + person2Age + person3Age + person4Age + person5Age) / 5;

        int[] ages = {19,34,28,50,100, 75, 10, 44};
        int sum = 0;

        int count = 0;
        while(count < ages.length) {
            sum += ages[count];
            count++;
        }

        for(int i = 0; i < ages.length; i++) {
            //sum = sum + ages[i];
            sum += ages[i];
        }

        int averageAge = sum / ages.length;




        System.out.println("Finished");



    }

}