package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays_test {
    public static void main(String[] args) {
        String[] nums = {"1","-9","34","asd"};
        //将数字以字符串的形式标识
        System.out.print("原始数组:"+Arrays.toString(nums));
        System.out.println("");
        Arrays.sort(nums);
        System.out.print("重排的数组:");
        for (String i : nums){
            System.out.print(i+" ");
        }
        System.out.println("");
        //用某元素填充整个数组,第二个参数为开始填充的位置,第三个参数为结束填充的位置
        Arrays.fill(nums,0,4,"1");
        System.out.print("填充后的数据:"+Arrays.toString(nums));
        System.out.println("");
        //讲数组转化为List
        List<String> num_list = Arrays.asList(nums);
        System.out.print("遍历转化为List的数组:");
        for (String i:num_list){
            System.out.print(i+" ");
        }
        System.out.println("");
        //num_list.add("new");
        //这样会报错:java.lang.UnsupportedOperationException
        //这样生成的List不可以使用增删操作,必须使用如下方法完成
        List<String> num_list2 = new ArrayList<String>(Arrays.asList(nums));
        num_list2.add("new");
        System.out.print("增加新元素的List:");
        for (String i:num_list2){
            System.out.print(i+" ");
        }
    }
}
