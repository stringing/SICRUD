<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>首页</title>
    <style type="text/css">
    	#c{
    		font-size:20px;
    	}
    	a:link{
    		color:6495ED;
    		text-decoration:none;
    	}
    	a:hover{
    		color:#EE0000;
    		text-decoration:none;
    	}
    	a:visited{
    		color:#6495ED;
    		text-decoration:none;
    	}
    	a:active{
    		color:#6495ED;
    		text-decoration:none;
    	}
    </style>
  </head>
  
  <body style="text-align:center;">
  		<h1>学生信息管理系统</h1><br/><br/>
    	<a id="c" href="${pageContext.request.contextPath }/servlet/CreateServlet">添加学生信息</a><br/>
    	<a id="c" href="${pageContext.request.contextPath }/servlet/DeleteServlet">删除学生信息</a><br/>
    	<a id="c" href="${pageContext.request.contextPath }/servlet/UpdateServlet">修改学生信息</a><br/>
    	<a id="c" href="${pageContext.request.contextPath }/servlet/RetrieveServlet">查询学生信息</a>
  </body>
</html>
