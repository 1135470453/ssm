package com.work.sd2;

public class Person {
    private String first,last,middle;
    String type;
    public Person(String first,String middle,String last){
        this.first = first;
        this.last = last;
        this.middle = middle;
    }
    public void printNameZero(){
        System.out.println(first+" "+middle+" "+last);
    }
    public void printNameFirst(){
        System.out.println(first+" "+last+" "+middle);
    }
    public void printNameSecond(){
        System.out.println(last+" "+first+" "+middle);
    }
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }


}
