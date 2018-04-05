<%--
  Created by IntelliJ IDEA.
  User: zyszys
  Date: 22/03/2018
  Time: 3:54 PM
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
    <title>首页</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <style type="text/css">
        .container {
            margin-top: 20px;
            font-size: large;
        }
        .ques {
            display: inline-block;
        }
        .jumbotron {
            margin: 40px;
            margin-left: 40px;
        }
        h4 {
            text-align: center;
        }
        nav {
            position: absolute;
        }
        nav > div > div > a {
            text-align: center;
            margin: 10px;
            padding: 48px;
        }
        #add {
            display: inherit;
        }
        .github-corner:hover .octo-arm {
            animation: octocat-wave 560ms ease-in-out
        }
        @keyframes octocat-wave {
            0%,
            100% {
                transform: rotate(0)
            }
            20%,
            60% {
                transform: rotate(-25deg)
            }
            40%,
            80% {
                transform: rotate(10deg)
            }
        }
        @media (max-width:500px) {
            .github-corner:hover .octo-arm {
                animation: none
            }
            .github-corner .octo-arm {
                animation: octocat-wave 560ms ease-in-out
            }
        }
        footer {
            margin:30px 0 20px;
        }
        footer p {
            text-align: center;
            color: gray;
            font-size: 14px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="Searchallquestion?user=${user}">Q  &  A</a>
            <a href="Searchallquestion?user=${user}">首页</a>
            <a>热门</a>
            <a>发现</a>
            <a>话题</a>
            <a href="#">退出</a>
            <a href="http://zyszys.top/web/Resume" target="_blank">${user}</a>
        </div>
    </div>
</nav>
<div class="container">
    <a href="https://github.com/ZYSzys/IdeaProjects/tree/master/first" class="github-corner" aria-label="View source on Github">
        <svg width="80" height="80" viewBox="0 0 250 250" style="fill:#70B7FD; color:#fff; position: absolute; top: 0; border: 0; right: 0;" aria-hidden="true">
            <path d="M0,0 L115,115 L130,115 L142,142 L250,250 L250,0 Z"></path>
            <path d="M128.3,109.0 C113.8,99.7 119.0,89.6 119.0,89.6 C122.0,82.7 120.5,78.6 120.5,78.6 C119.2,72.0 123.4,76.3 123.4,76.3 C127.3,80.9 125.5,87.3 125.5,87.3 C122.9,97.6 130.6,101.9 134.4,103.2" fill="currentColor" style="transform-origin: 130px 106px;" class="octo-arm"></path>
            <path d="M115.0,115.0 C114.9,115.1 118.7,116.5 119.8,115.4 L133.7,101.6 C136.9,99.2 139.9,98.4 142.2,98.6 C133.8,88.0 127.5,74.4 143.8,58.0 C148.5,53.4 154.0,51.2 159.7,51.0 C160.3,49.4 163.2,43.6 171.4,40.1 C171.4,40.1 176.1,42.5 178.8,56.2 C183.1,58.6 187.2,61.8 190.9,65.4 C194.5,69.0 197.7,73.2 200.1,77.6 C213.8,80.2 216.3,84.9 216.3,84.9 C212.7,93.1 206.9,96.0 205.4,96.6 C205.1,102.4 203.0,107.8 198.3,112.5 C181.9,128.9 168.3,122.5 157.7,114.1 C157.9,116.9 156.7,120.9 152.7,124.9 L141.0,136.5 C139.8,137.7 141.6,141.9 141.8,141.8 Z" fill="currentColor" class="octo-body"></path>
        </svg>
    </a>
<ol>
    <c:forEach var="Q" items="${questionAll}"  >
        <!--<form action="UpdateServlet" method="post">-->
        <div class="jumbotron">
            <div class="title">
                <h4>${Q.title}<a href="SearchallAnswer?id=${Q.id}&user=${user}" target="_blank"><i class="fa fa-paper-plane"></i></a></h4><br>
            </div>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${Q.description}</p>
        </div>
        <!--<td><a href="DeleteServlet">删除</a>  <input type="submit" value="更新"/></td>-->
    </c:forEach>
</ol>
    <div id="add">
    <form action="AskServlet"method="post" style="padding-top:-700px;" class="form-group" onsubmit="return check(this)">
        <label>题目:</label><input type="text" class="form-control" name="ques" placeholder="Title">
        <label>描述:</label><textarea class="form-control" name="desc" placeholder="Description"></textarea><br>
        <input class="btn" type="reset"value="重置">
        <input class="btn btn-primary" type="submit" value="提交问题">
    </form>
    </div>
</div>
<footer>
    <p>Copyright by ZYSzys</p>
</footer>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script color="0,0,255" opacity='0.7' zIndex="-2" count="99" src="js/canvas-nest.min.js"></script>
<script type="text/javascript">
    function check(form) {
        if(form.ques.value == "") {
            alert("题目不能为空！");
            return false;
        }
        return true;
    }
</script>
</body>
</html>