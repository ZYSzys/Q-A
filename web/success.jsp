<%--
  Created by IntelliJ IDEA.
  User: zyszys
  Date: 21/03/2018
  Time: 7:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'success.jsp' starting page</title>
</head>
<body>
${xiaoxi} <br>
<a href="Searchall">查看所有用户</a>
<a href="Searchallquestion">查看所有问题</a>
</body>
</html>
