<%--
  Created by IntelliJ IDEA.
  User: Harlan
  Date: 2020/9/12
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>拦截器</title>
</head>
<body>
<h1>此方法被拦截器拦截了!</h1>
<%
    System.out.println("error.jsp执行了...");
    System.out.println("======================");
%>
</body>
</html>
