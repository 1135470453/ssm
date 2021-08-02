<%--
  Created by IntelliJ IDEA.
  User: zjw
  Date: 2020/8/13
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json</title>
</head>
<body>
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var student={
                "id":135,
                "name":"赵六"
            };
            $.ajax({
                url:"/user/request",
                data:JSON.stringify(student),
                type:"post",
                contentType:"application/json;charset=UTF-8",
                dataType:"json",
                success:function (data) {
                    alert(data.id+"---"+data.name);
                }
            })
        })
    </script>
</body>
</html>
