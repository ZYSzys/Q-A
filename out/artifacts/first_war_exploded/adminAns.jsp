<%--
  Created by IntelliJ IDEA.
  User: zyszys
  Date: 25/03/2018
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>回答细节</title>
</head>
<body>
<h2>${xiaoxi}</h2>
<ul>
    <c:forEach var="Q" items="${answerAll}"  >
        <!--<form action="UpdateServlet" method="post">-->
        <div class="jumbotron">
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${Q.content}</p><br>
            <p>${Q.createdTime}</p>
        </div>
        <a href="DeleteAnsServlet?id=${Q.id}">删除此条答案</a>
    </c:forEach>
</ul>
</body>
</html>
