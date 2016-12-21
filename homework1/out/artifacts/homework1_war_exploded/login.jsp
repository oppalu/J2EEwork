<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2016/12/21
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>成绩查询系统</h3>
<form action="/Login" method="post">
    学号:<input type="text" name="uname"><br>
    密码:  <input type="password" name="upass"><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>

<%
    int counter= Integer.parseInt((String) application.getAttribute("counter"));
    int visitor = (Integer) application.getAttribute("visitor");
//    counter++;
//    visitor++;
//    application.setAttribute("counter", Integer.toString(counter));
//    application.setAttribute("visitor",visitor);
    System.out.println("enter");
%>

<div>
    访问总人数:
    <%=Integer.parseInt((String) application.getAttribute("counter"))%>
</div>
<div>
    当前在线登录用户总数:
    <%=application.getAttribute("onlineCounter")%>
</div>
<div>
    当前在线游客总数:
    <%=application.getAttribute("visitor")%>
</div>
</body>
</html>
