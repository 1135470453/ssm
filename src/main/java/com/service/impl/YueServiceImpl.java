package com.service.impl;

import com.repository.YueRepository;
import com.service.YueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YueServiceImpl implements YueService {
    @Autowired
    private YueRepository yueRepository;
    @Override
    public double getLastYue() {
        if (yueRepository.getLastYue() != null){
            return yueRepository.getLastYue().doubleValue();
        }
        else{
            return 0.00;
        }
    }
}
