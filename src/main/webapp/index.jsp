<%--
  Created by IntelliJ IDEA.
  User: zjw
  Date: 2020/8/8
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${list}" var="user">
        ${user.id}--${user.username}--${user.loginpwd}--${user.paypwd}
        <br>
    </c:forEach>
</body>
</html>
