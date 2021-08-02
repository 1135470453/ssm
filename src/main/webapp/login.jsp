
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form:form modelAttribute="account" action="/ssm/validator/login" method="post">
        姓名: <form:input path="name"/><form:errors path="name"></form:errors> <br>
        密码: <form:input path="password"/><form:errors path="password"></form:errors> <br>
        <input type="submit" value="登陆">
    </form:form>
</body>
</html>
