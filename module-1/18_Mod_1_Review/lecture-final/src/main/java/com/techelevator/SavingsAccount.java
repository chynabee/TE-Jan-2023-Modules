package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount{

    //constants
    private final BigDecimal MIN_BALANCE = new BigDecimal("10");

    //instance variables
    private boolean requestedSavingsCard;
    private BigDecimal interestRate;

    //constructors
    public SavingsAccount(String name, BigDecimal interestRate){
        super(name);
        this.interestRate = interestRate;
    }

    public SavingsAccount(String name, BigDecimal balance, BigDecimal interestRate){
        super(name, balance);
        this.interestRate = interestRate;
    }

    //getters and setters

    public boolean isRequestedSavingsCard() {
        return requestedSavingsCard;
    }

    public void setRequestedSavingsCard(boolean requestedSavingsCard) {
        this.requestedSavingsCard = requestedSavingsCard;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
