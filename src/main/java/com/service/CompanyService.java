package com.service;

import com.entity.Company;
import com.entity.Finance;
import com.entity.NumberOfCity;

import java.util.List;

public interface CompanyService {
    public List<NumberOfCity> getNumberOfCity();
    public List<Company> getCompany(int page);
    public List<Company> getCompanyByCode(int code);
    public Finance getCompanyFinace(String stock_code, String finance_name);
}
