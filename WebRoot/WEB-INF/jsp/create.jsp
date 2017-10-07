<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <%String path = request.getContextPath(); %>
    <title>添加学生信息</title>
    <script type="text/javascript">
    	function back(){
    		window.location.href='<%=path%>/index.jsp';
    	}
    </script>

  </head>
  
  <body style="text-align:center;">
    <form action="${pageContext.request.contextPath }/servlet/CreateServletD" method="post">
    	学号：<input type="text" name="ID"/><font color="red">${message }</font><br/>
    	姓名：<input type="text" name="name"/><br/>
    	性别：<input type="radio" name="sex" value="MALE"/>男<input type="radio" name="sex" value="FEMALE"/>女<br/>
    	班级：<input type="text" name="classnumber"/><br/>
    	绩点：<input type="text" name="gpa"/><br/>
    	<input type="submit" value="确定"/><input type="button" value="返回" onclick="back()"/>
    </form>
  </body>
</html>
