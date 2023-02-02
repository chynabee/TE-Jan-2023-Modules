package com.techelevator;

public class Main {

    public static void main(String[] args) {

        // Create a new class, initializing the first name
        // and last name through the constructor
        Person christopher = new Person("Christopher", "Guarnera");
        //christopher.introduceSelf();

        BankAccount savings = new BankAccount();
       BankAccount account = new BankAccount("12355890",
                                "0000234", BankAccount.CHECKING);

       account.setBalance(1000);
       account.deposit(500);
       account.deposit(20);

       System.out.println("Our balance is " + account.getBalance());

    }

}
