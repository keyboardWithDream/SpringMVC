<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--
  User: Harlan
  Date: 2020-8-23
  Time: 下午 5:07
--%>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h1>Hello SpringMVC!</h1>
<h2>${requestScope.get("msg")}</h2>
<h2>${sessionScope.get("msg")}</h2>
</body>
</html>
