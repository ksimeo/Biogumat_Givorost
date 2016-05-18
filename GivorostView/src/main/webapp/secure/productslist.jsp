<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
<link rel="stylesheet" type="text/css" href="../../content/css/style.css"/>
<script type="text/javascript" src="../../script/jquery.tablesorter.min.js"></script>
<script type="text/javascript" src="../script/createProduct.js"></script>
<script type="text/javascript" src="../script/deleteProduct.js"></script>
<head>
    <title>Біогумат ЖИВОРОСТ - Лист пропонуємих продуктів</title>
    <link rel="shortcut icon" href="../img/givorost.ico" type="image/x-icon">
</head>
<body class="systbody">
<table id="t2">
    <tr>
        <td align="center">

        </td>
    </tr>
    <tr>
        <td align="center">
            <h2>Перелiк продуктів якi ми пропонуємо </h2>
        </td>
    </tr>
    <tr>
        <td>
            <table class="tablesorter">
                <thead>
                <tr class="column-view">
                    <th class="column-viewHeader">П/п</th>
                    <th class="column-viewHeader">Назва</th>
                    <th class="column-viewHeader">Вартість, грн</th>
                    <th class="column-viewHeader">Коефіцієнт вартості</th>
                    <th class="column-viewHeader"></th>
                </tr>
                </thead>
                <tbody class="stripy">
                <c:forEach var="item" items="${products}">
                    <tr class="column-view">
                        <td class="column-view-center">${item.id}</td>
                        <td class="column-view">${item.name}</td>
                        <td class="column-view-center">${item.price}</td>
                        <td class="column-view-center">${item.factor}</td>
                        <td class="column-view-center">
                            <form action="/delproduct" method="POST">
                                <input type="button" value="Змiнити"
                                       onClick="location.href='/changeproduct?id=${item.id}'"/> &nbsp
                                <input type="hidden" name="prodid" value="${item.id}"/>
                                <input type="submit" value="Видалити">
                            </form>
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
            <a href="/secure/adminspage?page=1">Повернутися до сторинки адмінистратору</a>
        </td>
    </tr>
</table>
</body>
</html>