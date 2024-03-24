<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 19.03.2024
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose Order</title>
</head>
<body>
<a  href="index.jsp">Вернуться на главную страницу</a><br>
<label><b>Вывести номера заказов, сумма которых не превосходит заданную, и количество различных товаров равно заданному</b></label><br>
<form method="get" id="chooseOrd" action="choose-servlet">
    <div>
        <label>Сумма стоимости товаров в заказе</label><br>
        <input type="number" step="any" name="sum">
    </div><br>
    <div>
        <label>Количество товаров</label><br>
        <input type="number" name="count">
    </div><br>
    <div>
        <button type="submit">Send</button>
    </div>
</form><br>
${chooseOrder}
</body>
</html>
