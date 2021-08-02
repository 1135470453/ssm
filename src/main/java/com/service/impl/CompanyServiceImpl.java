package com.service.impl;

import com.entity.Company;
import com.entity.Finance;
import com.entity.NumberOfCity;
import com.repository.CompanyRepository;
import com.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<NumberOfCity> getNumberOfCity() {
        List<NumberOfCity> numberOfCities = companyRepository.getNumberOfCity();
        numberOfCities.remove(0);
        System.out.println("getNumberOfCity------------------------");
        for (NumberOfCity numberOfCity:numberOfCities){
            System.out.println(numberOfCity.getCity()+numberOfCity.getNumber());
        }
        return numberOfCities;

    }

    @Override
    public List<Company> getCompany(int page) {
        int number1 = (page-1)*10+1;
        int number2 = number1+10;
        String number1_s = String.valueOf(number1);
        String number2_s = String.valueOf(number2);
        return companyRepository.getCompany(number1_s,number2_s);
    }

    @Override
    public List<Company> getCompanyByCode(int code) {
        return companyRepository.getCompanyByCode(code);
    }

    @Override
    public Finance getCompanyFinace(String stock_code, String finance_name) {
        Process proc;
        List<String> datas1;
        List<Float> datas2 = new ArrayList<>();
        String name;
        Map<String,String> map = new LinkedHashMap<>();
        Finance finance = new Finance();
        try {
            String[] args = new String[] { "python ", "D:\\dongxi\\xiangmu\\zongshe3\\data\\Spider3.py",stock_code};
            proc = Runtime.getRuntime().exec(args);// 执行py文件
            System.out.println("爬虫运行成功");
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            System.out.println(in);
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
            if (finance_name.equals("1")){
                name = "商誉";
            }else if (finance_name.equals("2")){
                name = "资本公积";
            }else if (finance_name.equals("3")){
                name = "盈余公积";
            }else{
                name = "其他综合收益";
            }
            stock_code = "company_data_"+stock_code;
            finance = companyRepository.getCompanyFinace(stock_code,name);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Error e){
            e.printStackTrace();
        }

        return finance;
    }
}
