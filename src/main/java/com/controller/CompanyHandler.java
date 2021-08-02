package com.controller;


import com.entity.Company;
import com.entity.Finance;
import com.entity.NumberOfCity;
import com.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyHandler {

    @Autowired
    CompanyService companyService;

    @RequestMapping("/getNumberOfCity")
    @ResponseBody
    public List<NumberOfCity> getNumberOfCity(HttpServletRequest httpServletRequest){
        List<NumberOfCity> numberOfCities = new ArrayList<>();
        numberOfCities = companyService.getNumberOfCity();
        return numberOfCities;
    }

    @RequestMapping("/getCompany")
    @ResponseBody
    public List<Company> getCompany(HttpServletRequest httpServletRequest){
        List<Company> companies = new ArrayList<>();
        String page_s =  httpServletRequest.getParameter("page");
        int page = Integer.parseInt(page_s);
        companies = companyService.getCompany(page);
        return companies;
    }

    @RequestMapping("/getCompanyByCode")
    @ResponseBody
    public List<Company> getCompanyByCode(HttpServletRequest httpServletRequest){
        String code_s = (String) httpServletRequest.getAttribute("stock_code");
        int code = Integer.valueOf(code_s);
        return companyService.getCompanyByCode(code);
    }

    @RequestMapping("/getCompanyFinave")
    @ResponseBody
    public Finance getCompanyFinave(HttpServletRequest httpServletRequest){
        String stock_code = httpServletRequest.getParameter("stock_code");
        String finance_name = httpServletRequest.getParameter("finance_name");
        System.out.println(stock_code+","+finance_name);
        return companyService.getCompanyFinace(stock_code,finance_name);
    }
}
