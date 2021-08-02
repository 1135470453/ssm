package com.test;

import java.util.ArrayList;
import java.util.List;

public class ABTest {
    public static void main(String[] args) {
        List<A> aList = new ArrayList<A>();
        B b = new B();
        b.setAge(12);
        A a = new A();
        a.setName("haha");
        aList.add(a);
        aList.add(b);
        System.out.println(aList.get(0).getName());
        B bb = (B)aList.get(1);
        bb.getAge();
    }
}
