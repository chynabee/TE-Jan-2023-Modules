package com.techelevator.loans;

public class SubLoan extends Loan{

    public SubLoan(){
       // can't do this because the list is private
        //  this.myList

        //I can see this String because it's protected
        //System.out.println(this.myProtectedString);
    }

}
