package com.techelevator;

public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String department;
    private double annualSalary;

    //Constructors
    public Employee( int employeeId, String firstName, String lastName, double annualSalary){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;

    }
    //Getters
    public int getEmployeeId() {
        return employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return lastName + ", " + firstName;
    }
    public String getDepartment() {
        return department;
    }
    public double getAnnualSalary() {
        return annualSalary;
    }

    //Setters

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment (String department) {
        this.department = department;
    }



    //Method

    public void raiseSalary (double percent) {
        this.annualSalary = (annualSalary * (percent / 100)) + annualSalary;


    }

}
