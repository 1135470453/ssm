package com.controller;

import com.entity.*;
import com.service.ChuxuService;
import com.service.ShouruService;
import com.service.YueService;
import com.service.ZhichuService;
import com.service.impl.ZhichuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;

@Controller
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private ZhichuService zhichuService;
    @Autowired
    private ShouruService shouruService;
    @Autowired
    private YueService yueService;
    @Autowired
    private ChuxuService chuxuService;

    @RequestMapping("/getChuxu")
    @ResponseBody
    public List<Chuxu> getChuxu(HttpServletRequest httpServletRequest){
        List<Chuxu> chuxus = new ArrayList<>();
        chuxus = chuxuService.getChuxu();
        HttpSession httpSession = httpServletRequest.getSession();
        for (Chuxu chuxu: chuxus){
            httpSession.setAttribute(chuxu.getTime(),chuxu);
        }
        for (Chuxu chuxu:chuxus){
            System.out.println(httpSession.getAttribute(chuxu.getTime()).toString());
        }

        return chuxus;
    }

    @RequestMapping("/chuxuDetial")
    @ResponseBody
    public void chuxuDetial(HttpServletRequest httpServletRequest){
        String time = httpServletRequest.getParameter("time");
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("detial",time);
        System.out.println(httpSession.getAttribute("detial"));
    }

    @RequestMapping("/getChuxuName")
    @ResponseBody
    public Map<String,String> getChuxuName(HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession();
        Map<String,String> map = new  HashMap<String,String>();
        String time = (String) httpSession.getAttribute("detial");
        Chuxu chuxu = (Chuxu) httpSession.getAttribute(time);
        map.put("name",chuxu.getName());
        System.out.println(map.get("name"));
        return map;
    }

    @RequestMapping("/getpipizhichu")
    @ResponseBody
    public List<Zhichu> getpipizhichu(HttpServletRequest httpServletRequest){
        String date2 = httpServletRequest.getParameter("date2");
        List<Zhichu> zhichus;
        if (date2.equals("")||date2==null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
            Calendar calendar = Calendar.getInstance();
            date2 = simpleDateFormat.format(calendar.getTime());
        }
        zhichus = zhichuService.getpipizhichu(date2);
        for (Zhichu zhichu:zhichus){
            System.out.println("AccountHandler----getpipizhichu----"+zhichu.toString());
            switch (zhichu.getType()){
//                校园卡,交通,社交,约会,加餐,衣服,零食,彩妆,学习,运动,话费,医药
                case "0":   zhichu.setType("校园卡");
                            break;
                case "1":   zhichu.setType("交通");
                            break;
                case "2":   zhichu.setType("社交");
                            break;
                case "3":   zhichu.setType("约会");
                            break;
                case "4":   zhichu.setType("加餐");
                            break;
                case "5":   zhichu.setType("衣服");
                            break;
                case "6":   zhichu.setType("零食");
                            break;
                case "7":   zhichu.setType("彩妆");
                            break;
                case "8":   zhichu.setType("学习");
                            break;
                case "9":   zhichu.setType("运动");
                            break;
                case "10":   zhichu.setType("话费");
                            break;
                case "11":   zhichu.setType("医药");
                            break;
            }
        }
        return zhichus;
    }

    @RequestMapping("/getbaicaizhichu")
    @ResponseBody
    public List<Zhichu> getbaicaizhichu(HttpServletRequest httpServletRequest){
        String date1 = httpServletRequest.getParameter("date1");
        List<Zhichu> zhichus = new ArrayList<>();
        if (date1.equals("")||date1==null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
            Calendar calendar = Calendar.getInstance();
            date1 = simpleDateFormat.format(calendar.getTime());
        }
        zhichus = zhichuService.getbaicaizhichu(date1);
        for (Zhichu zhichu:zhichus){
            System.out.println("AccountHandler----getbaicaizhichu----"+zhichu.toString());
            switch (zhichu.getType()){
//                校园卡,交通,社交,约会,加餐,衣服,零食,彩妆,学习,运动,话费,医药
                case "0":   zhichu.setType("校园卡");
                    break;
                case "1":   zhichu.setType("交通");
                    break;
                case "2":   zhichu.setType("社交");
                    break;
                case "3":   zhichu.setType("约会");
                    break;
                case "4":   zhichu.setType("加餐");
                    break;
                case "5":   zhichu.setType("衣服");
                    break;
                case "6":   zhichu.setType("零食");
                    break;
                case "7":   zhichu.setType("彩妆");
                    break;
                case "8":   zhichu.setType("学习");
                    break;
                case "9":   zhichu.setType("运动");
                    break;
                case "10":   zhichu.setType("话费");
                    break;
                case "11":   zhichu.setType("医药");
                    break;
            }
        }
        return zhichus;
    }

    @RequestMapping("/getShouruByMonth")
    @ResponseBody
    public List<Shouru> getShouruByMonth(HttpServletRequest httpServletRequest){
        String date3 = httpServletRequest.getParameter("date3");
        List<Shouru> shourus = new ArrayList<>();
        if (date3.equals("")||date3==null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
            Calendar calendar = Calendar.getInstance();
            date3 = simpleDateFormat.format(calendar.getTime());
        }
        shourus = shouruService.getShouruByMonth(date3);
        for (Shouru shouru:shourus){
            System.out.println("AccountHandler----getShouruByMonth----"+shouru.toString());
            switch (shouru.getType()){
//                收入:生活费,奖学金,兼职,理财,红包
                case "0":   shouru.setType("生活费");
                    break;
                case "1":   shouru.setType("奖学金");
                    break;
                case "2":   shouru.setType("兼职");
                    break;
                case "3":   shouru.setType("理财");
                    break;
                case "4":   shouru.setType("红包");
                    break;
            }
            switch (shouru.getPerson()){
                case "0": shouru.setPerson("大猪皮");
                          break;
                case "1": shouru.setPerson("小白菜");
                          break;
            }
        }
        return shourus;
    }

    @RequestMapping("/index")
    @ResponseBody
    public Map<String,Object> index(){
        System.out.println("index---start");
        Map<String,Object> map = new HashMap<String,Object>();
        DecimalFormat format = new DecimalFormat("#.00");
        String yue;
        double a = yueService.getLastYue();
        if (a == 0.00){
            yue = "0.00";
        }else {
            yue = format.format(yueService.getLastYue());
        }
        System.out.println("index---yue:"+yue);
        map.put("yue",yue);
        String zhichu;
        double d = zhichuService.getZhichuMonth();
        if (d == 0.00){
            zhichu = "0.00";
        }else {
            zhichu = format.format(d);
        }
        System.out.println("index---zhichu:"+zhichu);
        map.put("zhichu",zhichu);
        String shouru;
        double b = shouruService.getShouruMonth();
        if (b == 0.00){
            shouru = "0.00";
        }else {
            shouru = format.format(shouruService.getShouruMonth());
        }
        System.out.println("index---shouru:"+shouru);
        map.put("shouru",shouru);
        return map;
    }



    @RequestMapping("/deleteBaicaiZhichu")
    @ResponseBody
    public void deleteBaicaiZhichu(HttpServletRequest httpServletRequest){
        String time = httpServletRequest.getParameter("time");
        zhichuService.deleteBaicaiZhichu(time);
    }

    @RequestMapping("/deleteShouruByTime")
    @ResponseBody
    public void deleteShouruByTime(HttpServletRequest httpServletRequest){
        String time = httpServletRequest.getParameter("time");
        shouruService.deleteShouruByTime(time);
    }

    @RequestMapping("/deleteChuxuJilu")
    @ResponseBody
    public void deleteChuxuJilu(HttpServletRequest httpServletRequest){
        String time = httpServletRequest.getParameter("time");
        String money = httpServletRequest.getParameter("money");
        zhichuService.deleteChuxuJilu(time);
        HttpSession httpSession = httpServletRequest.getSession();
        String time2 = (String) httpSession.getAttribute("detial");
        Chuxu chuxu = (Chuxu) httpSession.getAttribute(time2);
        chuxu.setNow(chuxu.getNow()-Double.valueOf(money));
        httpSession.setAttribute(time2,chuxu);
        chuxuService.updateChuxu(chuxu);
    }

    @RequestMapping("/zhichuRecord")
    @ResponseBody
    public void zhichuRecord(HttpServletRequest httpServletRequest){
        System.out.println("zhichuRecord------start");
        Map<String,Object> map = new HashMap<String,Object>();
        Zhichu zhichu = new Zhichu();
        String money = httpServletRequest.getParameter("number1");
        String type = httpServletRequest.getParameter("type1");
        String person = httpServletRequest.getParameter("person1");
        String zhichutime = httpServletRequest.getParameter("zhichuTime");
        String other = httpServletRequest.getParameter("other1");
        zhichu.setMoney(Double.valueOf(money));
        zhichu.setType(type);
        zhichu.setPerson(person);
        zhichu.setZhichutime(zhichutime);
        zhichu.setOther(other);
        System.out.println("zhichuRecord----zhichu"+zhichu.toString());
        zhichuService.insertzhichu(zhichu);
    }

    @RequestMapping("/getOurChuxu")
    @ResponseBody
    public List<Zhichu> getOurChuxu(HttpServletRequest httpServletRequest){
        List<Zhichu> zhichus = new ArrayList<Zhichu>();
        HttpSession httpSession = httpServletRequest.getSession();
        String time = (String) httpSession.getAttribute("detial");
        zhichus = zhichuService.getOurChuxu(time);
        return zhichus;
    }

    @RequestMapping("/chuxuJiluRecord")
    @ResponseBody
    public void chuxuJiluRecord(HttpServletRequest httpServletRequest){
        System.out.println("chuxuJiluRecord------start");
        Zhichu zhichu = new Zhichu();
        String money = httpServletRequest.getParameter("number");
        String zhichutime = httpServletRequest.getParameter("zhichutime");
        String other = httpServletRequest.getParameter("other");
        HttpSession httpSession = httpServletRequest.getSession();
        String time = (String) httpSession.getAttribute("detial");
        Chuxu chuxu = (Chuxu) httpSession.getAttribute(time);
        chuxu.setNow(chuxu.getNow()+Double.valueOf(money));
        httpSession.setAttribute(time,chuxu);
        chuxuService.updateChuxu(chuxu);
        zhichu.setChuxutime(chuxu.getTime());
        zhichu.setType("12");
        zhichu.setPerson("0");
        zhichu.setMoney(Double.valueOf(money));
        zhichu.setZhichutime(zhichutime);
        zhichu.setOther(other);
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("insertzhichu---simpleDateFormat.format(date)"+simpleDateFormat.format(date));
        zhichu.setTime(simpleDateFormat.format(date));
        System.out.println("chuxuJiluRecord----chuxu"+zhichu.toString());
        zhichuService.insertchuxujilu(zhichu);

    }

    @RequestMapping("/chuxuRecord")
    @ResponseBody
    public void chuxuRecord(HttpServletRequest httpServletRequest){
        System.out.println("chuxuRecord------start");
        Map<String,Object> map = new HashMap<String,Object>();
        Chuxu chuxu = new Chuxu();
        String name = httpServletRequest.getParameter("name4");
        String money = httpServletRequest.getParameter("money4");
        String other = httpServletRequest.getParameter("other4");
        chuxu.setMoney(Double.valueOf(money));
        chuxu.setName(name);
        chuxu.setOther(other);
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        chuxu.setTime(simpleDateFormat.format(date));
        System.out.println("chuxuRecord----chuxu"+chuxu.toString());
        chuxuService.insertChuxu(chuxu);
    }

    @RequestMapping("/zhichuyanzheng")
    @ResponseBody
    public Map<String,Object> zhichuyanzheng(HttpServletRequest httpServletRequest){
        System.out.println("zhichuyanzheng----start");
        Map<String,Object> map = new HashMap<String,Object>();
        String number1 = httpServletRequest.getParameter("number1");
        String zhichuTime = httpServletRequest.getParameter("zhichuTime");
        /*判断输入的金额和时间是否正确*/
        if (zhichuTime.equals("")||zhichuTime==null){
            System.out.println("zhichuyanzheng-----no zhichutimr");
            map.put("result","NozhichuTime");
            return map;
        }
        if (number1.equals("")||number1==null){
            System.out.println("zhichuyanzheng-----no number1");
            map.put("result","Nonumber1");
            return map;
        }
        System.out.println("zhichuyanzheng-------zhichutime right:"+zhichuTime);
        try {
            double number = Double.valueOf(number1);
            map.put("result","right");
            System.out.println("zhichuyanzheng--------right number1:"+number);
            return map;
        }catch (Exception e){
            map.put("result","errornumber1");
            System.out.println("zhichuyanzheng-----error number1");
            return map;
        }
    }

    @RequestMapping("/chuxuyanzheng")
    @ResponseBody
    public Map<String,Object> chuxuyanzheng(HttpServletRequest httpServletRequest){
        System.out.println("chuxuyanzheng----start");
        Map<String,Object> map = new HashMap<String,Object>();
        String number = httpServletRequest.getParameter("number");
        String zhichuTime = httpServletRequest.getParameter("zhichutime");
        /*判断输入的金额和时间是否正确*/
        if (zhichuTime.equals("")||zhichuTime==null){
            System.out.println("zhichuyanzheng-----no zhichutimr");
            map.put("result","NozhichuTime");
            return map;
        }
        if (number.equals("")||number==null){
            System.out.println("zhichuyanzheng-----no number");
            map.put("result","Nonumber");
            return map;
        }
        System.out.println("zhichuyanzheng-------zhichutime right:"+zhichuTime);
        try {
            double n = Double.valueOf(number);
            map.put("result","right");
            System.out.println("zhichuyanzheng--------right number:"+n);
            return map;
        }catch (Exception e){
            map.put("result","errornumber");
            System.out.println("zhichuyanzheng-----error number");
            return map;
        }
    }


    @RequestMapping("/newChuxuCheck")
    @ResponseBody
    public Map<String,Object> newChuxuCheck(HttpServletRequest httpServletRequest){
        System.out.println("newChuxuCheck----start");
        Map<String,Object> map = new HashMap<String,Object>();
        String name = httpServletRequest.getParameter("name4");
        String money = httpServletRequest.getParameter("money4");
        /*判断输入的金额和名称是否正确*/
        if (name.equals("")||name==null){
            System.out.println("zhichuyanzheng-----no name");
            map.put("result","NoName");
            return map;
        }
        if (money.equals("")||money==null){
            System.out.println("zhichuyanzheng-----no money");
            map.put("result","NoMoney");
            return map;
        }
        System.out.println("zhichuyanzheng-------name right:"+name);
        try {
            double number = Double.valueOf(money);
            map.put("result","right");
            System.out.println("zhichuyanzheng--------right money:"+money);
            return map;
        }catch (Exception e){
            map.put("result","ErrorMoney");
            System.out.println("zhichuyanzheng-----error money");
            return map;
        }
    }

    @RequestMapping("/shouruyanzheng")
    @ResponseBody
    public Map<String,Object> shouruyanzheng(HttpServletRequest httpServletRequest){
        System.out.println("shouruyanzheng----start");
        Map<String,Object> map = new HashMap<String,Object>();
        String number2 = httpServletRequest.getParameter("number2");
        String shouruTime = httpServletRequest.getParameter("shouruTime");
        /*判断输入的金额和时间是否正确*/
        if (shouruTime.equals("")||shouruTime==null){
            System.out.println("shouruyanzheng-----no shouruTime");
            map.put("result","NoshouruTime");
            return map;
        }
        System.out.println("shouruyanzheng-------zhichutime right:"+shouruTime);
        if (number2.equals("")||number2==null){
            System.out.println("shouruyanzheng-----no number2");
            map.put("result","Nonumber2");
            return map;
        }
        try {
            double number = Double.valueOf(number2);
            map.put("result","right");
            System.out.println("shouruyanzheng--------right number2:"+number);
            return map;
        }catch (Exception e){
            map.put("result","errornumber2");
            System.out.println("shouruyanzheng-----error number2");
            return map;
        }
    }

    @RequestMapping("/shouruRecord")
    @ResponseBody
    public void shouruRecord(HttpServletRequest httpServletRequest){
        System.out.println("shouruRecord------start");
        Map<String,Object> map = new HashMap<String,Object>();
        Shouru shouru = new Shouru();
        String money = httpServletRequest.getParameter("number2");
        String type = httpServletRequest.getParameter("type2");
        String person = httpServletRequest.getParameter("person2");
        String shourutime = httpServletRequest.getParameter("shouruTime");
        String other = httpServletRequest.getParameter("other2");
        shouru.setMoney(Double.valueOf(money));
        shouru.setType(type);
        shouru.setShourutime(shourutime);
        shouru.setPerson(person);
        shouru.setOther(other);
        System.out.println("shouruRecord----shouru"+shouru.toString());
        shouruService.insertShouru(shouru);
    }
}
