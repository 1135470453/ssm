<%--
  Created by IntelliJ IDEA.
  User: zjw
  Date: 2020/8/14
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
    <form action="/ssm/file/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="img">
        <input type="submit" value="上传">
    </ >
</body>
</html>
