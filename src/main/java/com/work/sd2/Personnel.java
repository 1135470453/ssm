package com.work.sd2;

import java.util.ArrayList;
import java.util.List;

public class Personnel {
    PersonnelFactory personnelFactory = new PersonnelFactory();
    private List<Person> personList = new ArrayList<Person>();
    public void addPersonnel(String first,String middle,String last,int empID,double salary,String type){
        Person person = personnelFactory.createPersonnel(type,first,last,middle,empID,salary);
        personList.add(person);
    }
    public int getPersonListSize(){
        return personList.size();
    }
    public Person getPersonByOrder(int i){
        return personList.get(i);
    }
    public void addPerson(String first,String middle,String last){
        Person person = new Person(first,middle,last);
        personList.add(person);
    }
}
