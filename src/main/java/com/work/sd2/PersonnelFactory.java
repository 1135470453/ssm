package com.work.sd2;



public class PersonnelFactory {
    public Person createPersonnel(String type,String first,String last,String middle,int empID,double salary){
        if (type == null){
            return null;
        }
        if (type.equalsIgnoreCase("EMPLOYEE")){
            return new Employee(first, middle, last, empID, salary);
        }else if (type.equalsIgnoreCase("EXECUTIVE")){
            return new Executive(first,middle,last,empID,salary);
        }else if (type.equalsIgnoreCase("SECURITY")){
            return new Security(first,middle,last,empID,salary);
        }else if (type.equalsIgnoreCase("VOLUNTEER")){
            return new Volunteer(first,middle,last,empID,salary);
        }
        return null;
    }
}
