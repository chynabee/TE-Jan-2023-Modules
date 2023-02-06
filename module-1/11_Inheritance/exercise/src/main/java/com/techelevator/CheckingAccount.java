package com.techelevator;

public class CheckingAccount extends BankAccount {

    //Constructor
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override

    //Method
    public int withdraw(int amountToWithdraw) {
        if (getBalance() - amountToWithdraw < 0 && getBalance() - amountToWithdraw > -100) {
            super.withdraw(amountToWithdraw + 10);
            return getBalance();
        }
        if (getBalance() - amountToWithdraw >= 0) {
            super.withdraw(amountToWithdraw);
            return getBalance();
        } else {

            return getBalance();
        }
    }
}






