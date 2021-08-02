package com.service;

import com.entity.Zhichu;

import java.util.List;

public interface ZhichuService {
    public void insertzhichu(Zhichu zhichu);
    public double getZhichuMonth();
    public List<Zhichu> getpipizhichu(String date2);
    public List<Zhichu> getbaicaizhichu(String date1);
    public void deleteBaicaiZhichu(String time);
    public void insertchuxujilu(Zhichu zhichu);
    public List<Zhichu> getOurChuxu(String time);
    public void deleteChuxuJilu(String time);
}
