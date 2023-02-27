package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Customer {

    //instance variables
    private String name;
    private String address;
    private String taxPayerIdOrSSN;
    private boolean olderThan18OrGuardian;
    private String phone;
    private boolean passedCheckSystems;


    //We can store our accounts as a list or a map
    //list benefits: we can keep the order, simple
    //list cons: if we want to find something, we have to loop through our list to find it
    //NOTE: ALWAYS INITIALIZE YOUR LIST OR MAP RIGHT AWAY TO AVOID NULL POINTER EXCEPTIONS

    List<BankAccount> bankAccounts = new ArrayList<>();//INITIALIZATION OF LIST

    //map benefits: we can give a key (name) and get the account right away without having to loop
    //map cons: a little more complex, it doesn't keep order unless we do a tree map or linked list
    Map<String, BankAccount> bankAccountMap = new TreeMap<>(); // "Treemap"-going to sort itself alphabetically by the key

    //constructors
    public Customer(String name, String taxPayerIdOrSSN) {
        this.name = name;
        this.taxPayerIdOrSSN = taxPayerIdOrSSN;
    }

    //getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxPayerIdOrSSN() {
        return taxPayerIdOrSSN;
    }

    public void setTaxPayerIdOrSSN(String taxPayerIdOrSSN) {
        this.taxPayerIdOrSSN = taxPayerIdOrSSN;
    }

    public boolean isOlderThan18OrGuardian() {
        return olderThan18OrGuardian;
    }

    public void setOlderThan18OrGuardian(boolean olderThan18OrGuardian) {
        this.olderThan18OrGuardian = olderThan18OrGuardian;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isPassedCheckSystems() {
        return passedCheckSystems;
    }

    public void setPassedCheckSystems(boolean passedCheckSystems) {
        this.passedCheckSystems = passedCheckSystems;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    //methods
    //this will let me add one bank account at a time
    public void addBankAccount(BankAccount account) {
        this.bankAccounts.add(account);
    }

    public void addBankAccountToMap(BankAccount account) {//use this if we use the Map instead
        bankAccountMap.put(account.getName(), account);
    }
}
