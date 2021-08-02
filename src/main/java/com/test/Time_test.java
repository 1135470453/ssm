package com.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time_test {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        String first = simpleDateFormat.format(calendar.getTime());
        System.out.println(first);
    }
}
