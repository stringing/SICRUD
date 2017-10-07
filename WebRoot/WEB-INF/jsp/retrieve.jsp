<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>查询学生信息</title>
    <%String path = request.getContextPath(); %>
    <script type="text/javascript">
    	function back(){
    		window.location.href='<%=path%>/index.jsp';
    	}
    </script>
  </head>
  
  <body style="text-align:center;">
  	<form action="${pageContext.request.contextPath}/servlet/RetrieveServletD" method="post">
    	学号：<input type="text" name="ID"><font color="red">${message }</font><br/>
    	<input type="submit" value="查询"/><input type="button" value="返回" onclick="back()"/><br/><br/>
    	<div>
    		${id }<br/>
    		${name }<br/>
    		${sex }<br/>
    		${classnumber }<br/>
    		${gpa }<br/>
    	</div>
  	</form>
  </body>
</html>
