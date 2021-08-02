package com.utils;

import com.entity.Student;
import org.springframework.core.convert.converter.Converter;

public class StudentConverter implements Converter<String, Student> {

    @Override
    public Student convert(String s) {
        String[] arg = s.split("-");
        Student student = new Student();
        student.setId(Integer.parseInt(arg[0]));
        student.setName(arg[1]);
        return student;
    }
}
