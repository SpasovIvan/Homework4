<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 17.03.2024
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Info</title>
</head>
<body>
<a  href="index.jsp">Вернуться на главную страницу</a><br>
<label><b>Найти товар по ID</b></label>
<form method="get" id="showInf" action="show_info-servlet">
    <div>
        <label>Введите число</label><br>
        <input type="number" name="numOrder">
    </div>
    <div>
        <button type="submit">Send</button>
    </div>
</form>
${showOrder}
</body>
</html>
