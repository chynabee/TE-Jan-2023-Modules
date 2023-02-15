package com.techelevator;

import java.math.BigDecimal;

public class BankAccount {


    //constants
    //static means that it belongs on the class level, and we don't need to make an instance
    //private means only this class can see it
    private final BigDecimal TRANSFER_LIMIT_AMT = new BigDecimal("25.00");
    //public means other classes can see it
    public static final BigDecimal MIN_OPENING_DEPOSIT = new BigDecimal("10.00");
    private final BigDecimal MONTHLY_MNT_FEE = new BigDecimal("5.00");
    private final BigDecimal ATM_FEE = new BigDecimal("2.50");


    //instance variables

    //let's use BigDecimal for money
    //because it avoids rounding errors
    // *If you do want
    private BigDecimal balance = new BigDecimal("0.00");
    private String name;


    //constructors (multiple if we want, remember: overloading)
    //no return type, typically always public, and always matches class name
    public BankAccount(String name){
        this.name = name;
    }

    public BankAccount(String name, BigDecimal balance){

        //this references our specific class, it's internal to us, "my" name
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

    // if I only provide a getter, that means any other class
    //can only read the name but never change it. Name becomes read-only
    public String getName() {
        return name;
    }

    //methods

    public BigDecimal deposit(BigDecimal amount){

        this.balance = this.balance.add(amount);
        return this.balance;
    }

    // keep in mind you would want to do validation to make sure that we have enough money
    // for miniminum balances or applying overdraft fees
    public BigDecimal withdraw(BigDecimal amount) {
        if(amount.compareTo(this.balance) <= 0) {
            this.balance = this.balance.subtract(amount);
        }

        return this.balance;
    }

}
