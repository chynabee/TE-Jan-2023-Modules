package com.techelevator;

public class SavingsAccount extends BankAccount {

    //Constructor
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override

    //Method
    public int withdraw(int amountToWithdraw) {
        if (getBalance() - amountToWithdraw < 150 && getBalance() - (amountToWithdraw + 2) >=0 ) {
        super.withdraw(amountToWithdraw + 2);
        return getBalance();
    }
        if (getBalance() - amountToWithdraw <2) {
            return getBalance();

        }
            super.withdraw(amountToWithdraw);
            return getBalance();


    }
}

