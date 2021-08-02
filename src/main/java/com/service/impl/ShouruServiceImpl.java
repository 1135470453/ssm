package com.service.impl;

import com.entity.Shouru;
import com.entity.Yue;
import com.repository.ShouruRepository;
import com.repository.YueRepository;
import com.service.ShouruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ShouruServiceImpl implements ShouruService {
    @Autowired
    ShouruRepository shouruRepository;
    @Autowired
    YueRepository yueRepository;
    @Override
    public void insertShouru(Shouru shouru) {
        System.out.println("ShouruServiceImpl----insertzhichu---"+shouru.toString());
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("ShouruServiceImpl----insertzhichu---simpleDateFormat.format(date)"+simpleDateFormat.format(date));
        shouru.setTime(simpleDateFormat.format(date));
        System.out.println("ShouruServiceImpl----insertzhichu---"+shouru.toString());
        shouruRepository.insertShouru(shouru);
        Yue yue = new Yue();
        double d;
        if (yueRepository.getLastYue() != null){
            yue.setMoney(yueRepository.getLastYue().doubleValue() +shouru.getMoney());
        }else {
            yue.setMoney(shouru.getMoney());
        }
        yue.setTime(simpleDateFormat.format(date));
        yueRepository.insertYue(yue);
    }

    @Override
    public double getShouruMonth() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,1);
        String first = simpleDateFormat.format(calendar.getTime());
        calendar.set(Calendar.DATE,1);
        calendar.roll(Calendar.DATE,-1);
        String last = simpleDateFormat.format(calendar.getTime());
        System.out.println("ShouruServiceImpl---getShouruMonth---first day:"+first+",last day:"+last);
        if (shouruRepository.getShouruMonth(first,last)!=null){
            return shouruRepository.getShouruMonth(first,last).doubleValue();
        }else {
            return 0.00;
        }
    }

    @Override
    public List<Shouru> getShouruByMonth(String date3) {
        return shouruRepository.getShouruByMonth(date3);
    }

    @Override
    public void deleteShouruByTime(String time) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Yue yue = new Yue();
        double d = 0;
        if (yueRepository.getLastYue()!=null){
            d +=  yueRepository.getLastYue().doubleValue();
        }
        if (shouruRepository.getShouruByTime(time)!= null){
            d -= shouruRepository.getShouruByTime(time).doubleValue();
        }
        yue.setMoney(d);
        yue.setTime(simpleDateFormat.format(date));
        yueRepository.insertYue(yue);
        shouruRepository.deleteShouruByTime(time);
    }
}
