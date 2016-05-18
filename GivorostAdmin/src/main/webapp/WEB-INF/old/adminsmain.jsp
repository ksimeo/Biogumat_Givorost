<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Журнал замовлень - Біогумат ЖИВОРОСТ</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../../content/css/style.css"/>
    <link rel="shortcut icon" href="../../img/givorost.ico" type="image/x-icon">
    <script type="text/javascript" src="../../script/mainpage.js"></script>
</head>
<script type="text/javascript">
    var currentPage = ${page};
//
//    function changePage(increment) {
//        var tmp = currentPage + increment;
//        if(tmp > 0) {
//            document.location ="/adminsmain.ado?p="+ tmp;
//        }
//    }
</script>
<body>
<div id="stripe">
    <form action="/logout" method="POST">
        <p>&nbsp; &nbsp;
            <script language="JavaScript"> day = new Date();
            hour = day.getHours();
            if (hour >= 5 && hour < 12) greeting = "Доброго ранку,";
            else {
                if (hour >= 12 && hour < 18) greeting = "Доброго дня,";
                else {
                    if (hour >= 18 && hour < 24) greeting = "Доброго вечору,";
                    else {
                        if (hour >= 0 && hour < 5) greeting = "Доброї ночі,";
                    }
                }
            }
            document.write(greeting); </script>
            <strong>
            <%= request.getAttribute("username")%></strong>! &nbsp;<span id="doc_time">
 Дата и время
</span>
            <script type="text/javascript">
                clock();
            </script>
            &nbsp; &nbsp; &nbsp;
            <a href="/users.ado" style="color: forestgreen"><b>До листу користувачів системи</b></a>
            &nbsp;
            <a href="/products.ado" style="color: forestgreen"><b>До листу пропонуємих товарів</b></a>
            &nbsp; &nbsp; &nbsp;
            <input type="button" value="Змінити пароль" onClick="location.href='/changepassw.do'">
            <input type="submit" value="Вийти з системи"></p>
        <%--<hr/>--%>
    </form>
</div>

<table id="t">
    <tr>
        <td align="center">
            <h2><strong>Журнал замовлень які надійшли до нашого сервісу</strong></h2>
            <table class="tablesorter">
                <thead>
                <tr class="column-view">
                    <th class="column-viewHeader">Номер заказу</th>
                    <th class="column-viewHeader">Дата і час</th>
                    <th class="column-viewHeader">Ім'я</th>
                    <th class="column-viewHeader">Номер телефону</th>
                    <th class="column-viewHeader">Електронна адреса</th>
                    <th class="column-viewHeader">Регіон</th>
                    <th class="column-viewHeader">Назва товару</th>
                    <th class="column-viewHeader">Кількість, л</th>
                    <th class="column-viewHeader"></th>
                </tr>
                </thead>
                <tbody class="stripy">
                <c:forEach var="item" items="${orders}">
                    <%--<form action="/delorder" method="POST">--%>
                    <tr class="column-view">
                        <input type="hidden" name="currpage" value="${page}"/>
                        <td class="column-view-center">${item.id}</td>
                        <td class="column-view"><fmt:formatDate pattern="dd.MM.yy HH:mm" value="${item.date}"/></td>
                        <td class="column-view">${item.name}</td>
                        <td class="column-view">${item.tel}</td>
                        <td class="column-view">${item.email}</td>
                        <td class="column-view">${item.region}</td>
                        <td class="column-view">${item.productName}</td>
                        <td class="column-view-center" style="text-align: center;">${item.number}</td>
                        <td class="column-view-center">
                            <form action="/delorder" method="POST">
                                <input type="hidden" name="orderid" value="${item.id}"/>
                                <input type="hidden" name="currpage" value="${page}">
                                <input type="submit" value="Переглянуто"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </td>
    </tr>
    <tr>
        <td>
        <p align="center">
                <input type="button" value="&lt; &lt;" onclick="changePage(-1)" ${mark1}>
                <strong>Сторiнка ${page}</strong>
            <%--<%= request.getAttribute("page")%>--%>
                <input type="button" value="&gt; &gt;" onclick="changePage(1)" ${mark2}>
            </p>
        </td>
    </tr>
</table>
</body>
</html>