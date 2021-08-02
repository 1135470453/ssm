<%--
  Created by IntelliJ IDEA.
  User: zjw
  Date: 2020/8/15
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>form</title>
</head>
<body>
    <h1>学生数据</h1>
    <form:form >
        <form:input path="id"></form:input><br>
        <form:input path="name"></form:input>
    </form:form>
</body>
</html>
