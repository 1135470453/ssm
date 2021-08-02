package com.work.sd2;

public class Employee extends Person{
    private int empID;
    private double salary;

    public Employee(String first, String middle, String last,int empID,double salary) {
        super(first, middle, last);
        this.empID = empID;
        this.salary = salary;
        type = "Employee";
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
