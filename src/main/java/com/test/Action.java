package com.test;

import java.util.Scanner;

public class Action {
    public static void main(String[] args) {
        String man_name;
        String teacher_name;
        String exclamation;
        String number;
        String plural_objects;
        String body_part1;
        String holiday;
        String movie;
        String verb;
        String distance;
        String country;
        String animal;
        String movie_quote;
        String body_part2;
        String song;
        String adjective;
        String option;
        Scanner input = new Scanner(System.in);
        System.out.print("请按提示输入你想到的内容,越离谱越好!");
        System.out.print("\n一个男人名字:");
        man_name = input.next();
        System.out.print("\n你最喜欢的老师名字:");
        teacher_name = input.next();
        System.out.print("\n感叹词:");
        exclamation = input.next();
        System.out.print("\n数字:");
        number = input.next();
        System.out.print("\n一个东西的名字:");
        plural_objects = input.next();
        System.out.print("\n身体部位:");
        body_part1 = input.next();
        System.out.print("\n节日名字:");
        holiday = input.next();
        System.out.print("\n电影名称:");
        movie = input.next();
        System.out.print("\n一个动词:");
        verb = input.next();
        System.out.print("\n一个距离:");
        distance = input.next();
        System.out.print("\n一个国家名称:");
        country = input.next();
        System.out.print("\n动物名称:");
        animal = input.next();
        System.out.print("\n最喜欢的电影台词:");
        movie_quote = input.next();
        System.out.print("\n另一个身体部位:");
        body_part2 = input.next();
        System.out.print("\n儿歌名称:");
        song = input.next();
        System.out.print("\n形容词:");
        adjective = input.next();
        System.out.print("\n选择一个角色(警探or犯人):");
        option = input.next();
        System.out.println("下面开始表演了!!!!!!!!!");
        System.out.println("犯人坐在桌子前,警探敲了敲桌子.\n警探说:我是"+man_name+",警察.你是?");
        System.out.println("犯人摘下帽子,说:"+teacher_name);
        System.out.println("警探坐在他对面,说:我抓你是因为你涉嫌二级抢劫罪.");
        System.out.println("犯人:啊?" +
                "\n警探：就是这样，你在万达偷了"+number+"个"+plural_objects+"现场全是你的"+body_part1+"印" +
                "\n犯人:卧槽!" +
                "\n警探继续质问:"+holiday+"那天你去哪里了?" +
                "\n犯人:在家看"+movie +
                "\n警探问:那为什么监控拍下你在犯罪现场"+distance+"外转圈?" +
                "\n犯人低下了头，警探继续质问:玩够了吧，你哪来的?" +
                "\n犯人说:"+country+
                "\n警探说：我觉得也是，做警探最好的一点就是就是我可以把像你这样的犯人抓起来，然后回家陪伴家人和"+animal+",然后说"+movie_quote+
                "\n犯人说:行，就是我抢的，但是是因为我需要钱，去装一个"+body_part2+"假肢" +
                "\n警探说：我就知道，我就知道。每次案子破了，都要唱我最喜欢的歌" +
                "\n警探开始唱"+song+
                "\n犯人跟着一起唱" +
                "\n唱完之后犯人说:你唱的真的"+adjective+",我就是愿意听你唱歌!");
    }
}
