package com.test;

public class String_test {
    public static void main(String[] args) {
        try {
            String a = "123.1a";
            double b;
            b = Double.valueOf(a);
            System.out.println(b);
        }catch (Exception e){
            System.out.println("error");
        }

    }
}
