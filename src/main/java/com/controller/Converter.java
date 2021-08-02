package com.controller;

import com.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/converter")
public class Converter {
    @RequestMapping("/date")
    public String date(Date date){
        return date.toString();
    }

    @RequestMapping("/student")
    public String student(Student student){
        return student.getName();
    }
}
