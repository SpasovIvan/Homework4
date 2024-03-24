<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 19.03.2024
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a  href="index.jsp">Вернуться на главную страницу</a><br>
<label><b>Вывести номера заказов, содержащих заданный товар</b></label><br>
<form method="get" id="searchProd" action="search-servlet">
    <div>
        <label>Введите номер заказа</label><br>
        <input type="number" name="numProd"><br>
    </div>
    <div>
        <input type="submit" value="Send">
    </div>
</form><br>
${searchProd}
</body>
</html>
