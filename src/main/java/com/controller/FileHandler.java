package com.controller;



import com.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileHandler {

    @PostMapping("/log")
    public ModelAndView log(Account account){
        System.out.println("log----start");
        System.out.println(account.getName());
        System.out.println(account.getPassword());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",account.getName());
        modelAndView.addObject("password",account.getPassword());
        modelAndView.setViewName("logsucess");
        return modelAndView;
    }

    @PostMapping("/upload")
    public String upload(MultipartFile img, HttpServletRequest request){
        System.out.println("upload---start");
        if (img.getSize()>0){
            //返回用于存储文件的file的地址
            //较高版本的可以使用request.getServletContext().getRealPath("file");
            System.out.println("file >0");
            HttpSession httpSession = request.getSession();
            System.out.println("获取session");
            String path = httpSession.getServletContext().getRealPath("/picture");
            System.out.println(path);
            String name  = img.getOriginalFilename();
            File file = new File(path,name);
            try {
                img.transferTo(file);
                request.setAttribute("path","/picture/"+name);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("file is empty!");
        }
        return "upload";
    }

    @PostMapping("/uploads")
    public String uploads(MultipartFile[] imgs,HttpServletRequest request){
        List<String> files = new ArrayList<>();
        for (MultipartFile img:imgs){
            HttpSession httpSession = request.getSession();
            String path = httpSession.getServletContext().getRealPath("/picture");
            String name = img.getOriginalFilename();
            File file = new File(path,name);
            try {
                img.transferTo(file);
                files.add("/picture/"+name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("files",files);
        return "uploads";
    }
}
