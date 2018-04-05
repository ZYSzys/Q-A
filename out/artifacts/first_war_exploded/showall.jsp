<%--
  Created by IntelliJ IDEA.
  User: zyszys
  Date: 21/03/2018
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>管理页面</title>
    <style type="text/css">
        button {
            position: fixed;
            top: 50px;
            right: 70px;
            height: 40px;
            width: 80px;
        }
    </style>
</head>
<body>
<h1>${xiaoxi}</h1>
<button><a href="denglu.jsp">退出</a> </button>
<table  width="600" border="1" cellpadding="0" >
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>密码</th>
        <th>家乡</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    <c:forEach var="U" items="${userAll}"  >
        <form action="UpdateServlet" method="post">
            <tr>
                <td><input type="text" value="${U.id}" name="id" ></td>
                <td><input type="text" value="${U.name}" name="name"></td>
                <td><input type="text" value="${U.sex}" name="sex"></td>
                <td><input type="text" value="${U.pwd}" name="pwd"></td>
                <td><input type="text" value="${U.home}" name="home"></td>
                <td><input type="text" value="${U.info}" name="info"></td>
                <td><a href="DeleteServlet?id=${U.id}">删除</a>  <input type="submit" value="更新"/></td>
            </tr>
        </form>
    </c:forEach>
</table>
<ul>
<c:forEach var="Q" items="${quesAll}"  >
    <form action="UpdateServlet" method="post">
        <li>
            ${Q.id}
            <textarea cols="70" rows="2" name="title">${Q.title}</textarea>
            <textarea cols="70" rows="2" name="description">${Q.description}</textarea>
            <td><a href="DeleteQuesServlet?id=${Q.id}">删除</a>  <input type="submit" value="更新"/></td>
                <a href="SearchallAnswer?id=${Q.id}&user=${user}" target="_blank">去看答案</a>
        </li>
    </form>
</c:forEach>
</ul>
</body>
</html>