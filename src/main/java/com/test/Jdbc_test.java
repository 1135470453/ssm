package com.test;


import java.sql.*;

public class Jdbc_test {
    public static void main(String[] args) {
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取链接
            String url= "jdbc:mysql://localhost:3306/test1?&useSSL=false&serverTimezone=UTC";
            String user="root";
            //我这里本地数据库没有设置密码
            String password="";
            //创建connect
            Connection connection = DriverManager.getConnection(url,user,password);
            //创建sql语句
            String sql1="insert into student (id,name,age) values (6,'龙王','1000')";
            String sql2="select * from student";
            //创建statement
            Statement statement = connection.createStatement();
            //运行sql语句,executeUpdate用于insert,update,delete,返回一个整数，表示影响的行数
            int a = statement.executeUpdate(sql1);
            System.out.println("影响行数:"+a);
            //运行sql语句,executeQuery用于select语句,返回的数据保存到resultSet数据
            ResultSet resultSet = statement.executeQuery(sql2);
            //遍历返回的数据
            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString(2);
                Integer age = resultSet.getInt(3);
                System.out.println(id+"-"+name+"-"+age);
            }
            //关闭
            resultSet.close();
            statement.close();
            connection.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
