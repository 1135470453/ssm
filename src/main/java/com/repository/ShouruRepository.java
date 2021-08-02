package com.repository;

import com.entity.Shouru;

import java.util.List;

public interface ShouruRepository {
    public void insertShouru(Shouru shouru);
    public Double getShouruMonth(String first,String last);
    public List<Shouru> getShouruByMonth(String date3);
    public Double getShouruByTime(String time);
    public void deleteShouruByTime(String time);
}
