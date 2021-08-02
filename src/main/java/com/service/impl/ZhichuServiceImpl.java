package com.service.impl;

import com.entity.Yue;
import com.entity.Zhichu;
import com.repository.YueRepository;
import com.repository.ZhichuRepository;
import com.service.ZhichuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ZhichuServiceImpl implements ZhichuService {
    @Autowired
    private ZhichuRepository zhichuRepository;
    @Autowired
    private YueRepository yueRepository;
    @Override
    public void insertzhichu(Zhichu zhichu) {
        System.out.println("zhichuServiceImpl---insertzhichu---"+zhichu.toString());
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("insertzhichu---simpleDateFormat.format(date)"+simpleDateFormat.format(date));
        zhichu.setTime(simpleDateFormat.format(date));
        System.out.println("zhichuServiceImpl---insertzhichu---"+zhichu.toString());
        zhichuRepository.insertZhichu(zhichu);
        Yue yue = new Yue();
        if (yueRepository.getLastYue()!= null){
            yue.setMoney(yueRepository.getLastYue().doubleValue()-zhichu.getMoney());
        }else {
            yue.setMoney(zhichu.getMoney());
        }
        yue.setTime(simpleDateFormat.format(date));
        yueRepository.insertYue(yue);
    }

    @Override
    public double getZhichuMonth() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,1);
        String first = simpleDateFormat.format(calendar.getTime());
        calendar.set(Calendar.DATE,1);
        calendar.roll(Calendar.DATE,-1);
        String last = simpleDateFormat.format(calendar.getTime());
        System.out.println("ZhichuServiceImpl---getZhichuMonth---first day:"+first+",last day:"+last);
        double zhichu =0.00;
        if (zhichuRepository.getZhichuMonth(first,last) == null){
            zhichu = 0.00;
        }else {
            zhichu = zhichuRepository.getZhichuMonth(first,last).doubleValue();
        }
        return zhichu;
    }

    @Override
    public List<Zhichu> getpipizhichu(String date2) {
        return zhichuRepository.getpipizhichu(date2);
    }

    @Override
    public List<Zhichu> getbaicaizhichu(String date1) {
        return zhichuRepository.getbaicaizhichu(date1);
    }

    @Override
    public void deleteBaicaiZhichu(String time) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Yue yue = new Yue();
        double d = 0;
        if (yueRepository.getLastYue()!=null){
            d +=  yueRepository.getLastYue().doubleValue();
        }
        if (zhichuRepository.getZhichuByTime(time)!= null){
            d+= zhichuRepository.getZhichuByTime(time).doubleValue();
        }
        yue.setMoney(d);
        yue.setTime(simpleDateFormat.format(date));
        yueRepository.insertYue(yue);
        zhichuRepository.deleteBaicaiZhichu(time);
    }

    @Override
    public void insertchuxujilu(Zhichu zhichu) {
        zhichuRepository.insertchuxujilu(zhichu);
    }

    @Override
    public List<Zhichu> getOurChuxu(String time) {
        return zhichuRepository.getOurChuxu(time);
    }

    @Override
    public void deleteChuxuJilu(String time) {
        zhichuRepository.deleteBaicaiZhichu(time);

    }
}
