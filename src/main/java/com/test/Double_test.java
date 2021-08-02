package com.test;

import com.service.impl.ZhichuServiceImpl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Double_test {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<String,Object>();
        DecimalFormat format = new DecimalFormat("#.00");
        ZhichuServiceImpl zhichuService = new ZhichuServiceImpl();
        System.out.println(format.format(zhichuService.getZhichuMonth()));
    }
}
