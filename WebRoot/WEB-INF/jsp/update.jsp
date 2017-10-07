<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    
    <title>修改学生信息</title>
    <%String path = request.getContextPath(); %>
    <script type="text/javascript">
    	function back(){
    		window.location.href='<%=path%>/index.jsp';
    	}
    </script>

  </head>
  
  <body style="text-align:center;">
    <form action="${pageContext.request.contextPath}/servlet/UpdateServletD" method="post">
    	学号：<input type="text" name="ID"/><font color="red">${message }</font><br/>
    	姓名：<input type="text" name="name"/><br/>
    	性别：<input type="radio" name="sex"  value="MALE"/>男<input type="radio" name="sex" value="FEMALE"/>女<br/>
    	班级：<input type="text" name="classnumber"/><br/>
    	绩点：<input type="text" name="gpa"/><br/>
    	<input type="submit" value="修改"/><input type="button" value="返回" onclick="back()"/>
    </form>
  </body>
</html>
