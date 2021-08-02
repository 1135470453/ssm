package com.service.impl;

import com.entity.Chuxu;
import com.repository.ChuxuRepository;
import com.service.ChuxuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuxuServiceImpl implements ChuxuService {

    @Autowired
    private ChuxuRepository chuxuRepository;

    @Override
    public void insertChuxu(Chuxu chuxu) {
        chuxuRepository.insertChuxu(chuxu);
    }

    @Override
    public List<Chuxu> getChuxu() {
        return chuxuRepository.getChuxu();
    }

    @Override
    public void updateChuxu(Chuxu chuxu) {
        chuxuRepository.updateChuxu(chuxu);
    }
}
