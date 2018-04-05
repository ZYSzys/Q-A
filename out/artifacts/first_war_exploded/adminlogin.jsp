<%--
  Created by IntelliJ IDEA.
  User: zyszys
  Date: 25/03/2018
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administrator Login</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        h1 {
            margin-top: 20px;
            font-family: 'DejaVu Sans Mono', monospace;
            text-align: center;
            color: #6f42c1;
        }
        .jumbotron {
            margin-top: 50px;
            border-radius: 2%;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>管理员登录</h1><br><br>
        <form action="DengluAdminServlet" method="post" class="form-horizontal" onsubmit="return check(this)">
            账号：<input type="text" name="name" value="" placeholder="账号" class=""><br><br>
            密码：<input type="password" name="pwd" value="" placeholder="密码"><br><br><br>
            <input type="submit" value="登录" name="denglu" class="btn btn-primary">
        </form>
        <form action="denglu.jsp">
            <button class="btn">返回</button>
        </form>
    </div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
