package com.test;

import java.text.DecimalFormat;

public class doubleToString_test {
    public static void main(String[] args) {
        double d = 123456789.50;
        DecimalFormat format = new DecimalFormat("#.00");
        String str= format.format(d);
        System.out.println(str);
    }
}
