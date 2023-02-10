package com.techelevator.loans;

import java.time.LocalDateTime;
import java.util.*;

public abstract class Loan {

    private String personalName;
    private String taxPayerIdOrSSN;
    private String address;
    private LocalDateTime birthDate;
    private List<String> cosigners;

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getTaxPayerIdOrSSN() {
        return taxPayerIdOrSSN;
    }

    public void setTaxPayerIdOrSSN(String taxPayerIdOrSSN) {
        this.taxPayerIdOrSSN = taxPayerIdOrSSN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getCosigners() {
        return cosigners;
    }

    public void setCosigners(List<String> cosigners) {
        this.cosigners = cosigners;
    }
}
