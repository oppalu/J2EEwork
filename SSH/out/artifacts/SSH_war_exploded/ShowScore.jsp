<%@ page import="com.phoebe.Model.Score" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/1/4
  Time: 00:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩</title>
</head>
<body>

<jsp:useBean id="score" type="java.util.ArrayList" scope="session"></jsp:useBean>
<jsp:useBean id="student" type="com.phoebe.Model.Student" scope="session"></jsp:useBean>

<h3><jsp:getProperty name="student" property="name"/>&nbsp;<jsp:getProperty name="score" property="sid"/></h3>
<a href="<%=request.getContextPath() + "/Logout" %>" >注销</a><br>

<table border="1">
    <tr>
        <th>课程名称</th>
        <th>成绩</th>
        <th>详细说明</th>
    </tr>

    <%
        boolean allOk = true;
        for (int i = 0;i<score.size();i++) {
            Score s = (Score)score.get(i);
            if(s.getScore() == 0)
                allOk = false;

    %>

    <tr>
        <td><%=s.getCoursename()%></td>
        <td><%=s.getScore()%></td>
        <td><%=s.getDetail()%></td>
    </tr>
</table>

</body>
</html>