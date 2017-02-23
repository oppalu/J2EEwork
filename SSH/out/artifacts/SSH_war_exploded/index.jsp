<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2016/12/21
  Time: 00:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>成绩查询系统</h3>
<%--<form action="<%=request.getContextPath() + "/Login"%>" method="post">--%>
<s:form action="login.action" method="post">
    学号:<s:textfield name="uname" label="Username"/><br>
    密码:  <s:password name="upass" label="Password"/><br>
    <s:submit value="登录"/>
    <s:reset value="重置"/>
</s:form>

</body>
</html>
