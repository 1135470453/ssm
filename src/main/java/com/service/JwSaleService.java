package com.service;

import com.entity.JwSale;
import com.entity.Shouru;
import com.entity.Statistics;

import java.util.List;

public interface JwSaleService {
    public void insertSale(JwSale jwSale);
    public List<JwSale> getsales(String date);
    public void deleteSaleById(String id);
    public String getSaleByDay(String date);
    public String getSale2ByDay(String date);
    public String getSaleByMonth(String date);
    public String getSale2ByMonth(String date);
}
