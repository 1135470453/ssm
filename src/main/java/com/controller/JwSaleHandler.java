package com.controller;

import com.entity.JwSale;
import com.entity.Statistics;
import com.entity.Zhichu;
import com.service.JwSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/jwsale")
public class JwSaleHandler {

    @Autowired
    private JwSaleService jwSaleService;

    @RequestMapping("/verification")
    @ResponseBody
    public Map<String,Object> verification(HttpServletRequest httpServletRequest){
        System.out.println("verification----start");
        Map<String,Object> map = new HashMap<String,Object>();
        String purchase_s = httpServletRequest.getParameter("purchase");
        String sale_s = httpServletRequest.getParameter("sale");
        String sale_time = httpServletRequest.getParameter("sale_time");
        String name = httpServletRequest.getParameter("name");
        /*判断输入的金额和时间是否正确*/
        if (name.equals("")||name==null){
            System.out.println("verification-----no name");
            map.put("result","Noname");
            return map;
        }
        if (sale_time.equals("")||sale_time==null){
            System.out.println("verification-----no sale_time");
            map.put("result","Nosale_time");
            return map;
        }
        if (purchase_s.equals("")||purchase_s==null){
            System.out.println("verification-----no purchase");
            map.put("result","Nopurchase");
            return map;
        }
        if (sale_s.equals("")||sale_s==null){
            System.out.println("verification-----no sale");
            map.put("result","Nosale");
            return map;
        }
        try {
            double purchase = Double.valueOf(purchase_s);
        }catch (Exception e){
            map.put("result","errorpurchase");
            System.out.println("verification-----error purchase");
            return map;
        }
        try {
            double sale = Double.valueOf(sale_s);
            map.put("result","right");
            System.out.println("verification--------right");
            return map;
        }catch (Exception e){
            map.put("result","errorsale");
            System.out.println("verification-----error sale");
            return map;
        }
    }

    @RequestMapping("/saleRecord")
    @ResponseBody
    public void saleRecord(HttpServletRequest httpServletRequest){
        System.out.println("saleRecord------start");
        String purchase_s = httpServletRequest.getParameter("purchase");
        String sale_s = httpServletRequest.getParameter("sale");
        String sale_time = httpServletRequest.getParameter("sale_time");
        String name = httpServletRequest.getParameter("name");
        String remarks = httpServletRequest.getParameter("remarks");
        JwSale jwSale = new JwSale();
        jwSale.setName(name);
        jwSale.setRemarks(remarks);
        jwSale.setPurchase(Double.valueOf(purchase_s));
        jwSale.setSale(Double.valueOf(sale_s));
        jwSale.setSale_time(sale_time);
        System.out.println("saleRecord----jwSale"+jwSale.toString());
        jwSaleService.insertSale(jwSale);
    }

    @RequestMapping("/getSale")
    @ResponseBody
    public List<JwSale> getSale(HttpServletRequest httpServletRequest){
        String date = httpServletRequest.getParameter("date");
        List<JwSale> sales;
        if (date.equals("")||date==null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            date = simpleDateFormat.format(calendar.getTime());
        }
        sales = jwSaleService.getsales(date);
        return sales;
    }

    @RequestMapping("/deleteSaleById")
    @ResponseBody
    public void deleteSaleById(HttpServletRequest httpServletRequest){
        String id = httpServletRequest.getParameter("id");
        jwSaleService.deleteSaleById(id);
    }

    @RequestMapping("/getSaleByDay")
    @ResponseBody
    public List<Statistics> getSaleByDay(HttpServletRequest httpServletRequest){
        int i;
        List<Statistics> statistics = new ArrayList<>();
        String date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7);
        for (i = 0;i<7;i++){
            calendar.add(Calendar.DATE, 1);
            date = simpleDateFormat.format(calendar.getTime());
            Statistics statistics1 = new Statistics();
            statistics1.setTime(date);
            statistics1.setNum1(jwSaleService.getSaleByDay(date));
            statistics1.setNum2(jwSaleService.getSale2ByDay(date));
            statistics.add(statistics1);
        }
        return statistics;
    }

    @RequestMapping("/getSaleByMonth")
    @ResponseBody
    public List<Statistics> getSaleByMonth(HttpServletRequest httpServletRequest){
        int i;
        List<Statistics> statistics = new ArrayList<>();
        String date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -7);
        for (i = 0;i<7;i++){
            calendar.add(Calendar.MONTH, 1);
            date = simpleDateFormat.format(calendar.getTime());
            Statistics statistics1 = new Statistics();
            statistics1.setTime(date);
            statistics1.setNum1(jwSaleService.getSaleByMonth(date));
            statistics1.setNum2(jwSaleService.getSale2ByMonth(date));
            statistics.add(statistics1);
        }
        return statistics;
    }
}
