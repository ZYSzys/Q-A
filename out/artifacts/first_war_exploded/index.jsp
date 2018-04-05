<%--
  Created by IntelliJ IDEA.
  User: zyszys
  Date: 21/03/2018
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>Sorry</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <style type="text/css">
    body {
      position: relative;
    }
    div {
      margin-top: -250px;
      position: absolute;
      top: 50%;
      transform: translateY(-50%);
      left: 50%;
      transform: translateX(-50%);
      text-align: center;
    }
  </style>
</head>
<body>
<div>
<h1>注册或登录失败，账号或密码错误，不能为空</h1>
<h2>Register or Sign in Failed!</h2>
    <br><br>
  <form action="zhuce.jsp">
    <input type="submit" value="重试" class="btn">
  </form>
  <form action="denglu.jsp">
    <input class="btn btn-primary" value="已有账号，去登录" type="submit">
  </form>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
