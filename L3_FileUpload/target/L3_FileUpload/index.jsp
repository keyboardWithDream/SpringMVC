<%--
  Created by IntelliJ IDEA.
  User: 13536
  Date: 2020/9/8
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h1>传统方式上传</h1>
<form action="/user/fileUpload" enctype="multipart/form-data" method="post">
    <label for="file">选择文件：</label><input type="file" name="file" id="file">
    <input type="submit" value="上传">
</form>
<hr>
<h1>SpringMVC方式上传</h1>
<form action="/user/mvcUpload" enctype="multipart/form-data" method="post">
    <label for="file">选择文件：</label><input type="file" name="file" id="file">
    <input type="submit" value="上传">
</form>
<hr>
<h1>跨服务器文件上传</h1>
<form action="/user/fileUpload" enctype="multipart/form-data" method="post">
    <label for="file">选择文件：</label><input type="file" name="file" id="file">
    <input type="submit" value="上传">
</form>
</body>
</html>
