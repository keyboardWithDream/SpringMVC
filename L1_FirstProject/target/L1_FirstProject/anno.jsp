<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  User: Harlan
  Date: 2020-8-25
  Time: 下午 4:06
--%>
<html>
<head>
    <title>常用注解</title>
</head>
<body>
<h1>常用注解</h1>
<a href="anno/testRequestParam?name=Harlan">@RequestParam 注解</a>
<hr>
<p>RequestBody注解</p>
<form action="anno/testRequestBody" method="post">
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
<a href="anno/testPathVariable/harlan">@PathVariable 注解</a>
<hr>
<a href="anno/testRequestHeader">@RequestHeader 注解</a>
<hr>
<a href="anno/testCookieValue">@CookieValue 注解</a>
<hr>
<p>ModelAttribute注解</p>
<form action="anno/testModelAttribute" method="post">
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
<a href="anno/testSessionAttributes">SessionAttributes注解</a>
</body>
</html>
