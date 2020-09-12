<%--
  Created by IntelliJ IDEA.
  User: 13536
  Date: 2020/9/11
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Test</title>
    <script src="WEB-INF/js/jquery-3.5.1.js" type="text/javascript"></script>
</head>
<body>
<h1>Test</h1>
<a href="/test/test">运行测试</a>
<form action="/test/guessNum" method="post">
    <label for="num">输入:</label><input type="text" name="num" id="num">
    <input type="submit" value="GO" id="go">
    <input type="text" name="result" id="result">
</form>
<script>
    $().onload(function (){
        $("#go").click($.post("/test/guessNum", $("#num").innerText, function (data){
            $("#result").innerText = data;
        }))
    })
</script>
</body>
</html>
