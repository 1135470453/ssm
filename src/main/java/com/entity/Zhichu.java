package com.entity;

public class Zhichu {
    private double money;
    private String type;
    private String person;
    private String time;
    private String zhichutime;
    private String chuxutime;
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

    public String getZhichutime() {
        return zhichutime;
    }

    public void setZhichutime(String zhichutime) {
        this.zhichutime = zhichutime;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getChuxutime() {
        return chuxutime;
    }

    public void setChuxutime(String chuxutime) {
        this.chuxutime = chuxutime;
    }

    @Override
    public String toString() {
        return "Zhichu{" +
                "money=" + money +
                ", type='" + type + '\'' +
                ", person='" + person + '\'' +
                ", time='" + time + '\'' +
                ", zhichutime='" + zhichutime + '\'' +
                ", chuxutime='" + chuxutime + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
