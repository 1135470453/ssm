package com.repository;

import com.entity.Zhichu;

import java.util.List;

public interface ZhichuRepository {
    public void insertZhichu(Zhichu zhichu);
    public Double getZhichuMonth(String first,String last);
    public List<Zhichu> getpipizhichu(String date2);
    public List<Zhichu> getbaicaizhichu(String date1);
    public void deleteBaicaiZhichu(String time);
    public Double getZhichuByTime(String time);
    public void insertchuxujilu(Zhichu zhichu);
    public List<Zhichu> getOurChuxu(String time);
}
