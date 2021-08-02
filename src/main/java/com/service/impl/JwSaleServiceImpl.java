package com.service.impl;

import com.entity.JwSale;
import com.entity.Statistics;
import com.repository.JwSaleRepository;
import com.service.JwSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwSaleServiceImpl implements JwSaleService {

    @Autowired
    private JwSaleRepository jwSaleRepository;

    @Override
    public void insertSale(JwSale jwSale) {
        jwSaleRepository.insertSale(jwSale);
    }

    @Override
    public List<JwSale> getsales(String date) {
        return jwSaleRepository.getsales(date);
    }

    @Override
    public void deleteSaleById(String id) {
        jwSaleRepository.deleteSaleById(id);
    }

    @Override
    public String getSaleByDay(String date) {
        return jwSaleRepository.getSaleByDay(date);
    }

    @Override
    public String getSale2ByDay(String date) {
        return jwSaleRepository.getSale2ByDay(date);
    }

    @Override
    public String getSaleByMonth(String date) {
        return jwSaleRepository.getSaleByMonth(date);
    }

    @Override
    public String getSale2ByMonth(String date) {
        return jwSaleRepository.getSale2ByMonth(date);
    }
}
