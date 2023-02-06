package com.techelevator;

import java.time.LocalDateTime;

public class Deposit {

    //instance variables - always make these private
    private double amount;
    private LocalDateTime dateDeposited;
    private boolean posted;

    //Constructors
    //typically always public. No return type. The name is the same
    //as the class. We can accept different parameters to initialize our
    //instance variables
    public Deposit(double amount, LocalDateTime dateDeposited) {
        this.amount = amount;
        this.dateDeposited = dateDeposited;
    }

    //Overloading: when you have the same name for a method or constructor
    //but they accept different parameters
    public Deposit(double amount, LocalDateTime dateDeposited, boolean posted) {
        this.amount = amount;
        this.dateDeposited = dateDeposited;
        this.posted = posted;
    }

    //Getters - methods that let us make our instance variables
    // available to outside classes. Typically always public
    public double getAmount(){
        return amount;
    }

    public LocalDateTime getDateDeposited(){
        return dateDeposited;
    }

    //if the variable is a boolean, for getters instead of using
    //get we say is
    public boolean isPosted(){
        return posted;
    }

    //Setters - methods that let outside classes modify the instance
    //variables in our class
    public void setPosted(boolean posted){
        //this means "my" - a reference to the class itself
        //notice that it turns color once it references the instance variable
        this.posted = posted;
    }

    //Instance methods
    public void chargeMaintenanceFee(double fee) {
        amount -= fee;
    }

}
