<%--
  Created by IntelliJ IDEA.
  User: 13536
  Date: 2020/9/1
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script>
        $(function (){
            $("#btn").click(function (){
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"Harlan","password":"123456","age":24}',
                    dataType:"json",
                    type:"post",
                    success:function (data){
                        $("#username").html(data.username);
                        $("#password").html(data.password);
                        $("#age").html(data.age);
                    }
                });
            });
        })
    </script>
</head>
<body>
<a href="user/testString">返回字符串</a>
<hr>
<a href="user/testVoid">返回Void</a>
<hr>
<a href="user/forwardOrRedirect">使用转发或重定向关键字</a>
<hr>
<a href="user/testModelAndView">返回ModelAndView类型</a>
<hr>
<input type="button" id="btn" value="发送ajax请求">
<p id="username"></p>
<p id="password"></p>
<p id="age"></p>
</body>
</html>
