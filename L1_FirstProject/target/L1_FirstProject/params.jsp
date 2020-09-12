<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  User: Harlan
  Date: 2020-8-23
  Time: 下午 7:24
--%>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>
<a href="param/testParam?username=harlan&password=Hhn004460">请求参数绑定</a>
<hr>
<form action="param/save" method="post">
    <input type="text" name="username" placeholder="username">
    <br>
    <input type="password" name="password" placeholder="password">
    <br>
    <input type="text" name="money" placeholder="money">
    <br>
    <input type="text" name="user.uname" placeholder="uname">
    <br>
    <input type="password" name="user.age" placeholder="age">
    <br>
    <input type="submit" value="提交">
</form>
<hr>
<a href="param/testServletApi?username=harlan&password=Hhn004460">获取ServletApi</a>
</body>
</html>
