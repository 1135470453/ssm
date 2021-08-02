package com.controller;

import com.entity.School;
import com.entity.Student;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("list",userService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public String insertUser(User user){
        System.out.println(user);
        userService.insertUser(user);
        return "index";
    }

    @RequestMapping(value = "/test1",params={"name","id=10"})
    public void test1(@RequestParam("name") String name_2, @RequestParam("id") String id_2){
        System.out.println("name_2:"+name_2);
        System.out.println("id_2:"+id_2);
    }

    @RequestMapping("/redirect")
    public String redirect(){
        return "redirect:index";
    }

    @RequestMapping("/basetype")
    @ResponseBody
    public String basetype(int id){
        return id+"";
    }

    @RequestMapping("/makeschool")
    @ResponseBody
    public String makeschool(School school){
        StringBuffer stringBuffer = new StringBuffer();
        for(Student student:school.getSchool()){
            stringBuffer.append(student.getId());
            stringBuffer.append(student.getName());
        }
        return stringBuffer.toString();
    }

    @RequestMapping("/json")
    @ResponseBody
    public Student json(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getName());
        student.setId(123);
        student.setName("hahaha");
        return student;
    }

    @RequestMapping("/request")
    public String request(HttpServletRequest request,@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getName());
        student.setId(student.getId());
        student.setName(student.getName());
        request.setAttribute("student",student);
        return "view";
    }

}
