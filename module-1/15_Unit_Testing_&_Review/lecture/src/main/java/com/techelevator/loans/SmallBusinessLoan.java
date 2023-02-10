package com.techelevator.loans;

import java.time.LocalDateTime;
import java.util.List;

public class SmallBusinessLoan extends Loan {

    private String companyName;
    private int revenue;
    private int pnl;
    private String guarantor;
    private boolean newBusiness;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getPnl() {
        return pnl;
    }

    public void setPnl(int pnl) {
        this.pnl = pnl;
    }

    public String getGuarantor() {
        return guarantor;
    }

    public void setGuarantor(String guarantor) {
        this.guarantor = guarantor;
    }

    public boolean isNewBusiness() {
        return newBusiness;
    }

    public void setNewBusiness(boolean newBusiness) {
        this.newBusiness = newBusiness;
    }
}
