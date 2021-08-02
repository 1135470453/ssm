package com.repository;

import com.entity.Company;
import com.entity.Finance;
import com.entity.NumberOfCity;

import java.util.List;
import java.util.Map;

public interface CompanyRepository {
    public List<NumberOfCity> getNumberOfCity();
    public List<Company> getCompany(String number1,String number2);
    public List<Company> getCompanyByCode(int code);
    public Finance getCompanyFinace(String stock_code, String finance_name);
}
