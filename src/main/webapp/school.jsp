<%--
  Created by IntelliJ IDEA.
  User: zjw
  Date: 2020/8/13
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>school</title>
</head>
<body>
    <form action="/ssm/user/makeschool" method="post">
        学生1的id:<input type="text" name="school[0].id"><br>
        学生1的name<input type="text" name="school[0].name"><br>
        学生2的id:<input type="text" name="school[1].id"><br>
        学生2的name<input type="text" name="school[1].name"><br>
        学生3的id:<input type="text" name="school[2].id"><br>
        学生3的name<input type="text" name="school[2].name"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
