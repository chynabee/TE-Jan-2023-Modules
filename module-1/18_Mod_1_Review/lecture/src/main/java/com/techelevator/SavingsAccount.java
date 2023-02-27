package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {

    //constants
    private final BigDecimal MIN_BALANCE = new BigDecimal("10.00");

    //instance variables
    private boolean requestedSavingsCard;
}
