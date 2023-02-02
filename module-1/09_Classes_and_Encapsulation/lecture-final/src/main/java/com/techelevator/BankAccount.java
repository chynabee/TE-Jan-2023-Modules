package com.techelevator;

public class BankAccount {

    // Constants:
    //static means that you don't have to declare an individual
    //instance to use the variable or method. You can call it off
    //the class directly
    public static final String CHECKING = "1A";
    public static final String SAVINGS = "2B";

    private String accountNumber;
    private String routingNumber;
    private double balance;
    private String typeOfAccount;

    //Constructor - always named after the class
    // How we initialize a class with default values as soon as we
    // create it.
    // If we have constructors or methods that are named the same
    // but have different parameters - we call that overloading
    public BankAccount(){
        //empty constructor
    }

    public BankAccount(String accountNumber, String routingNumber) {
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    public BankAccount(String accountNumber, String routingNumber, String type){
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
        typeOfAccount = type;

        //or we could call our existing setter
        //setTypeOfAccount(type);
    }

    // Getters
    public String getAccountNumber(){
        return "**********" + accountNumber.substring(accountNumber.length() - 4);
    }

    public String getRoutingNumber(){
        return routingNumber;
    }

    public double getBalance(){
        return balance;
    }

    public String getTypeOfAccount(){
        return typeOfAccount;
    }

    //anytime that we are writing a getter, if it's a boolean
    //we say is instead of get.
    //This is also a example of a derived property which means
    //we are not just returning a variable but calculating it
    // on the fly
    public boolean isQualifiedForKeyBankPrivate(){
        return balance > 100000;
    }


    //Setters
    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setTypeOfAccount(String type) {
        typeOfAccount = type;
    }

    //Instance Methods
    public void deposit(double amount) {
        balance += amount;
    }


}
