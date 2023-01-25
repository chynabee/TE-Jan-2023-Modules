package com.techelevator;

public class Scratch {



    public static void main(String[] args) {

        withdraw (500, false, 400);
        /*
        int age = 38;
        boolean isOver16 = age > 16;

        boolean hasCar = false;
        boolean uber = true;


        //check that a driver is over 16 and has a car, or check if they have an uber
        System.out.println( (isOver16 && hasCar) || uber );



        {
            String spiderman = "Tom Holland";
            String ironMan = "Robert Downey Jr.";

        }
        {
            String spiderman = "Tobey Maguire";
        }
        {
            String spiderman = "Andrew Garfield";
        }
*/



        int balance = 1000;
        int withdraw = 20;
        boolean isKeyBankAtm = false;

        balance = withdraw(balance, isKeyBankAtm, withdraw);
        balance = withdraw(balance, isKeyBankAtm, 50);
        balance = withdraw(balance, isKeyBankAtm, 300);
    }

    public static int withdraw(int balance, boolean isKeyBankAtm, int withdraw){

        int minimumBalance = balance - 5;

        // check if our withdraw amount is less than or equal to our balance and that this is a keybank atm
        if( withdraw <= balance && isKeyBankAtm) {

            balance = balance - withdraw;

            //if this is a keybank atm , then thank the customer
            if (isKeyBankAtm) {
                System.out.println("Thank you for banking at KeyBank!");
            } else {

            }


        }
        else if (withdraw <= minimumBalance) {
            balance = balance - withdraw;
        }
        else {
            System.out.println("You don't have a sufficient balance");
        }




        System.out.println("Our balance is: $" + balance);
        return balance;

    }

}
