package com.entity;

public class Chuxu {
    private double money;
    private double now;
    private String time;
    private String name;
    private String other;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getNow() {
        return now;
    }

    public void setNow(double now) {
        this.now = now;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Chuxu{" +
                "money=" + money +
                ", now=" + now +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
