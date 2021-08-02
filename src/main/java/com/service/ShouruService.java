package com.service;

import com.entity.Shouru;

import java.util.List;

public interface ShouruService {
    public void insertShouru(Shouru shouru);
    public double getShouruMonth();
    public List<Shouru> getShouruByMonth(String date3);
    public void deleteShouruByTime(String time);
}
