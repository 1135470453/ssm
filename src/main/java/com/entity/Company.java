package com.entity;

public class Company {
/* `serial_number` int NOT NULL,
  `stock_code` int(20) unsigned zerofill DEFAULT NULL,
  `stock_abbre` varchar(20) DEFAULT NULL,
  `company_name` varchar(200) DEFAULT NULL,
  `city` varchar(200) DEFAULT NULL,
  `area` varchar(200) DEFAULT NULL,
  `main_business_income` varchar(200) DEFAULT NULL,
  `net_profit` varchar(200) DEFAULT NULL,
  `employee` varchar(200) DEFAULT NULL,
  `listing_date` date DEFAULT NULL,
  `zhaogushu` varchar(200) DEFAULT NULL,
  `financial_report` varchar(200) DEFAULT NULL,
  `industry_classification` varchar(200) DEFAULT NULL,
  `industry_type` varchar(1000) DEFAULT NULL,
  `main_business` varchar(500) DEFAULT NULL*/
    private int serial_number;
    private int stock_code;
    private String stock_abbre;
    private String company_name;
    private String city;
    private String area;
    private String main_business_income;
    private String net_profit;
    private String employee;
    private String listing_date;
    private String zhaogushu;
    private String financial_report;
    private String industry_classification;
    private String industry_type;
    private String main_business;

    public int getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }

    public int getStock_code() {
        return stock_code;
    }

    public void setStock_code(int stock_code) {
        this.stock_code = stock_code;
    }

    public String getStock_abbre() {
        return stock_abbre;
    }

    public void setStock_abbre(String stock_abbre) {
        this.stock_abbre = stock_abbre;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMain_business_income() {
        return main_business_income;
    }

    public void setMain_business_income(String main_business_income) {
        this.main_business_income = main_business_income;
    }

    public String getNet_profit() {
        return net_profit;
    }

    public void setNet_profit(String net_profit) {
        this.net_profit = net_profit;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getListing_date() {
        return listing_date;
    }

    public void setListing_date(String listing_date) {
        this.listing_date = listing_date;
    }

    public String getZhaogushu() {
        return zhaogushu;
    }

    public void setZhaogushu(String zhaogushu) {
        this.zhaogushu = zhaogushu;
    }

    public String getFinancial_report() {
        return financial_report;
    }

    public void setFinancial_report(String financial_report) {
        this.financial_report = financial_report;
    }

    public String getIndustry_classification() {
        return industry_classification;
    }

    public void setIndustry_classification(String industry_classification) {
        this.industry_classification = industry_classification;
    }

    public String getIndustry_type() {
        return industry_type;
    }

    public void setIndustry_type(String industry_type) {
        this.industry_type = industry_type;
    }

    public String getMain_business() {
        return main_business;
    }

    public void setMain_business(String main_business) {
        this.main_business = main_business;
    }
}
