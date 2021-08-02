<%--
  Created by IntelliJ IDEA.
  User: zjw
  Date: 2020/9/3
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>log_filter</title>
</head>
<body>
    <p>123</p>
    <br>
    <form action="/ssm/file/log" method="post">
        姓名:<input name="name"><br>
        密码:<input name="password"><br>
        <input type="submit" value="登陆">
    </form>
</body>
</html>
