<%--
  Created by IntelliJ IDEA.
  User: zjw
  Date: 2020/8/14
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>uploads</title>
</head>
<body>
    <form action="/ssm/file/uploads" method="post" enctype="multipart/form-data">
        图片<input type="file" name="imgs"><br>
        图片<input type="file" name="imgs"><br>
        <input type="submit" value="提交">
    </form>
    <c:forEach items="${files}" var="file">
        <img src="/ssm${file}" width="300px">
    </c:forEach>
</body>
</html>
