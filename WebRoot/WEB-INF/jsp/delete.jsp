<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    
    <title>删除学生信息</title>
    <%String path = request.getContextPath(); %>
    <script type="text/javascript">
    	function back(){
    		window.location.href='<%=path%>/index.jsp';
    	}
    </script>
  </head>
  
  <body style="text-align:center;">
    <form action="${pageContext.request.contextPath}/servlet/DeleteServletD" method="post">
    	学号：<input type="text" name="ID"/><font color="red">${message }</font><br/>
    	<input type="submit" value="删除"/><input type="button" value="返回" onclick="back()"/>
    </form>
  </body>
</html>
