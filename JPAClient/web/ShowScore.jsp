<%@ page import="Model.Score" %>
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
<%
    ServletContext context = session.getServletContext();
    String name = (String)context.getAttribute("username");
    String id = (String) context.getAttribute("userid");
    int counter= (Integer) context.getAttribute("counter");
    int online= (Integer) context.getAttribute("onlineCounter");
    boolean allOk = true;
    List<Score> score = (List)context.getAttribute("score");
%>

<h3><%=name%>&nbsp;<%=id%></h3>
<a href="<%=request.getContextPath() + "/Logout" %>" >注销</a><br>
<div>
    你是第 <%=counter%> 个访问者
</div>
<div>
    你是第 <%=online%> 个在线用户
</div>

<table border="1">
    <tr>
        <th>课程名称</th>
        <th>成绩</th>
        <th>详细说明</th>
    </tr>

    <%
        for (int i = 0;i<score.size();i++) {
            Score s = score.get(i);
            if(s.getScore() == 0)
                allOk = false;

    %>
    <tr>
        <td><%=s.getCoursename()%></td>
        <td><%=s.getScore()%></td>
        <td><%=s.getDetail()%></td>
    </tr>
    <%
        }
    %>
</table>
<%
    if(allOk == false) {
%>
<h3>注意您所选的课中有未参加的!</h3>
<%
    }
%>
</body>
</html>