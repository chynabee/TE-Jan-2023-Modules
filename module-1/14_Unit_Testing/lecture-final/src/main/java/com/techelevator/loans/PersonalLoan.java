package com.techelevator.loans;

public class PersonalLoan extends Loan{

    private int creditScore;


    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }
}
