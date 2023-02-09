package com.techelevator.loans;

import java.time.LocalDateTime;

public class StudentLoan extends Loan {

    private int balance;
    private boolean activeEnrollment;
    private int income;
    private String levelOfStudy;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isActiveEnrollment() {
        return activeEnrollment;
    }

    public void setActiveEnrollment(boolean activeEnrollment) {
        this.activeEnrollment = activeEnrollment;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getLevelOfStudy() {
        return levelOfStudy;
    }

    public void setLevelOfStudy(String levelOfStudy) {
        this.levelOfStudy = levelOfStudy;
    }
}
