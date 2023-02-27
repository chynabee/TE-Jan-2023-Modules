package com.techelevator;

import java.math.BigDecimal;

public class BankAccount {


    //constants- situations that are not going to change such as min opening deposit amt, monthly fees, etc.
    //static means that it belongs on the class level, and we dont need to make an instance
    //private means only this class can see it
    //public means other classes can see it
    private final BigDecimal TRANSFER_LIMIT_AMT = new BigDecimal("25.00");
    public static final BigDecimal MIN_OPENING_DEPOSIT = new BigDecimal("10.00");
    private final BigDecimal MONTHLY_MNT_FEE = new BigDecimal("5.00");
    private final BigDecimal ATM_FEE = new BigDecimal("2.50");


    //declare instance variables FIRST - check for constants and move to the top as private final
    //lets use BigDecimal for money-because it avoids rounding errors
    private BigDecimal balance = new BigDecimal("0.00");
    private String name; //name doesnt need a default value since it could change




    //constructor complete this next- we can have multiple constructors if we want. with multiple parameters means overloading.
    //no return type, typically always public and always matches CLASS NAME
    public BankAccount(String name) {
        this.name = name; //whatever name we give it

    }

    public BankAccount(String name, BigDecimal balance) { //2nd constructor
        //this references our specific class, its internal to us, like saying "my" name
        this.name = name;
        this.balance = balance;
    }

    //getters and setters


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    //if I only provide a getter, that means any other class
    //can only read the name but never change it. Name becomes read-only once we get rid of the setter for name since we
    //dont want to ever set(change) the name again once account created
    public String getName() {
        return name;
    }


}
