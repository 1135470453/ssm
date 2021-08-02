package com.service;

import com.entity.Chuxu;

import java.util.List;

public interface ChuxuService {
    public void insertChuxu(Chuxu chuxu);
    public List<Chuxu> getChuxu();
    public void updateChuxu(Chuxu chuxu);
}
