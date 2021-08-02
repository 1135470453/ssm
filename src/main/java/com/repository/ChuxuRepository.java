package com.repository;

import com.entity.Chuxu;

import java.util.List;

public interface ChuxuRepository {
    public void insertChuxu(Chuxu chuxu);
    public List<Chuxu> getChuxu();
    public void updateChuxu(Chuxu chuxu);
}
