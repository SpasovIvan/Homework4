<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 19.03.2024
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Current Day</title>
</head>
<body>
<a  href="index.jsp">Вернуться на главную страницу</a><br>
<label><b>Вывести номера заказов, не содержащих заданный товар и поступивших в течение текущего дня</b></label><br>
<form method="get" id="currDayOrd" action="curr_day-servlet">
    <div>
        <label>ID продукта, которого не должно быть в заказе</label><br>
        <input type="number" name="notProd">
    </div><br>
    <div>
        <input type="submit" value="Send">
    </div>
</form><br>
${currDay}
</body>
</html>
