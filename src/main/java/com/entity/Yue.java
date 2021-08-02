package com.entity;

public class Yue {
    private double money;
    private String time;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Yue{" +
                "money=" + money +
                ", time='" + time + '\'' +
                '}';
    }
}
