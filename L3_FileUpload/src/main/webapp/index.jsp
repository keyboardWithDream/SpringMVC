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
<a href="/user/fileUpload">测试文件上传</a>
<form action="/user/fileUpload" enctype="multipart/form-data" method="post">
    <label for="file">选择文件：</label><input type="file" name="file" id="file">
    <input type="submit" value="上传">
</form>
</body>
</html>
