package com.entity;

public class JwSale {
    private int id;
    private String name;
    private double purchase;
    private double sale;
    private String remarks;
    private String sale_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchase() {
        return purchase;
    }

    public void setPurchase(double purchase) {
        this.purchase = purchase;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSale_time() {
        return sale_time;
    }

    public void setSale_time(String sale_time) {
        this.sale_time = sale_time;
    }

    @Override
    public String toString() {
        return "JwSale{" +
                "name='" + name + '\'' +
                ", purchase=" + purchase +
                ", sale=" + sale +
                ", remarks='" + remarks + '\'' +
                ", sale_time='" + sale_time + '\'' +
                '}';
    }
}
