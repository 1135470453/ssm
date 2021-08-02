<%--
  Created by IntelliJ IDEA.
  User: zjw
  Date: 2020/8/10
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>insertUser</title>
</head>
<body>
<div align="center" >
    <img src="1.png" width="553">
    <p>欧尼酱...可...可以给我你的支付宝吗?</p>
    <form action="/ssm/user/insertUser" method="post">
        <div style="margin-top: 50px">
            &nbsp;用户名&nbsp;<input type="text" name="username"/><br/>
        </div>
        <div style="margin-top: 50px">
            登陆密码&nbsp;<input type="text" name="loginpwd"/><br/>
        </div>
        <div style="margin-top: 50px">
            支付密码&nbsp;<input type="text" name="paypwd"/><br/>
        </div>
        <div style="margin-top: 50px">
            <input type="submit" value="好...给你"/>
        </div>
    </form>
    <div style="margin-top: 400px">
        <p>纯属娱乐，请勿输入真实密码</p>
    </div>
</div>

</body>
</html>
