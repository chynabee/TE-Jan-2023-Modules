package com.techelevator;

public class CreditCardAccount implements Accountable {

    private String accountHolder;
    private String accountNumber;
    private int debt;

   public CreditCardAccount (String accountHolder, String accountNumber) {
       this.accountHolder = accountHolder;
       this.accountNumber = accountNumber;
       this.debt = 0;
   }

   //Getters

    public String getAccountHolder() {return accountHolder;}
    public String getAccountNumber() {return accountNumber;}
    public int getDebt() {return debt;}

    public int getBalance() { return -debt;}

    public int pay (int amountToPay) {
      return debt = debt - amountToPay;
    }
    public int charge (int amountToCharge) {
    return debt = debt + amountToCharge;
    }



}
