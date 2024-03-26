<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 25.03.2024
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("name", "Bob");
%>
<html>
<head>
    <title>Homework 4</title>
</head>
<body>
<a href="/homework5-servlet">homework5-servlet</a><br>
<a href="/index.jsp">На главную</a><br>
${name}<br>
${requestScope.name}<br>
${secname}<br>
${cookie.food.value}<br>
<b>${header["User-Agent"]}</b><br>
</body>
</html>
