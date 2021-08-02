package com.entity;

public class Shouru {
    private double money;
    private String type;
    private String person;
    private String time;
    private String shourutime;
    private String other;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getShourutime() {
        return shourutime;
    }

    public void setShourutime(String shourutime) {
        this.shourutime = shourutime;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Shouru{" +
                "money=" + money +
                ", type='" + type + '\'' +
                ", person='" + person + '\'' +
                ", time='" + time + '\'' +
                ", shourutime='" + shourutime + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
