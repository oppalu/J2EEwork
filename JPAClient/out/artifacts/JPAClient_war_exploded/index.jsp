<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2016/12/21
  Time: 00:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>成绩查询系统</h3>
<form action="<%=request.getContextPath() + "/Login"%>" method="post">
    学号:<input type="text" name="uname"><br>
    密码:  <input type="password" name="upass"><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>

<%
    ServletContext context = session.getServletContext();
    int counter = (Integer)context.getAttribute("counter");
    int visitor = (Integer) context.getAttribute("visitor");
    counter++;
    visitor++;
    context.setAttribute("counter", counter);
    context.setAttribute("visitor",visitor);
%>

<div>
    访问总人数:
    <%=counter%>
</div>
<div>
    当前在线登录用户总数:
    <%=context.getAttribute("onlineCounter")%>
</div>
<div>
    当前在线游客总数:
    <%=visitor%>
</div>
</body>
</html>
