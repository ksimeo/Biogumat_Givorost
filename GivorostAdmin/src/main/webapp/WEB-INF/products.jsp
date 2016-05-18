<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
<link rel="stylesheet" type="text/css" href="../content/css/style.css"/>
<script type="text/javascript" src="../script/jquery.tablesorter.min.js"></script>
<%--<script type="text/javascript" src="../script/createProduct.js"></script>--%>
<%--<script type="text/javascript" src="../script/deleteProduct.js"></script>--%>

<head>
    <title>Біогумат ЖИВОРОСТ - Лист пропонуємих продуктів</title>
    <link rel="shortcut icon" href="../img/givorost.ico" type="image/x-icon">
    <script type="text/javascript" src="../script/products.js"></script>
</head>
<body class="systbody">
<div id="stripe" align="right">
    <form action="logout.do" method="POST">
        <p>
            <img src="../img/usr2.png"/>
            <b style="color: grey">${usrlogin}</b>
            <input type="button" value="Змінити пароль" onclick="ChangePassw()">
            <input type="button" value="Вийти з системи" onclick="LogOut()"> &nbsp;
        </p>
    </form>
</div>
<div align="center">
    <h2>Перелiк продуктів якi ми пропонуємо клієнтам:</h2>
        <table class="tablesorter1">
                <thead>
                <tr class="column-view">
                    <th class="column-viewHeader" width="5%">П/п</th>
                    <th class="column-viewHeader">Назва</th>
                    <th class="column-viewHeader" width="7%">Вартість, грн</th>
                    <th class="column-viewHeader" width="7%">Коефіцієнт вартості</th>
                    <th class="column-viewHeader" width="15%"></th>
                </tr>
                </thead>
                <tbody class="stripy">
                <c:forEach var="item" items="${products}">
                    <tr class="column-view">
                        <td class="column-view-center">${products.indexOf(item) + 1}</td>
                        <td class="column-view">${item.name}</td>
                        <td class="column-view-center">${item.price}</td>
                        <td class="column-view-center">${item.factor}</td>
                        <td class="column-view-center">
                            <%--<form action="/delproduct" method="POST">--%>
                                <input type="button" value="Змiнити" onclick="CorrProduct(${item.id})"/>
                                <input type="button" value="Видалити" onclick="DelProduct(${item.id})"/>
                            <%--</form>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </td>
        <br/>
    </tr>
    <tr>
        <td align="center">
            <br/>
            <input type="button" value="Додати продукт" onclick="CreateProduct()"/> &nbsp; &nbsp;
            <a href="/main.do?p=1">Повернутися до сторинки адмінистратору</a>
        </td>
    </tr>
</div>
<%--</table>--%>
</body>
</html>