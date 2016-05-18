<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Журнал замовлень - Біогумат ЖИВОРОСТ</title>
    <link rel="stylesheet" type="text/css" href="../content/css/style.css"/>
    <link rel="shortcut icon" href="../img/givorost.ico" type="image/x-icon">
</head>
<script type="text/javascript">
    var currentPage = ${page};

    function changePage(increment) {
        var tmp = currentPage + increment;
        if(tmp > 0) {
//            currentPage += increment;
            document.location ="/secure/adminspage?page="+ tmp;
        }
    }

    function pressButtonChangePassword() {
        document.location = "/secure/changepassword";
    }

    $(document).ready(function() {
                $("#tableAllOrders").tablesorter( {sortList: [[0,0], [1,0]]} );
            }
    );

    script.onload = function makeStripy(tabClass) {
        var tabs = document.getElementsByTagName("table");
        for (var e = 0; e < tabs.length; e++)
            if (tabs[e].className == tabClass) {
                var rows = tabs[e].getElementsByTagName("tr");
                for (var i = 0; i < rows.length; i++) // строки нумеруются с 0
                    rows[i].className += ((i % 2) == 0 ? " oddrows" : " evenrows");
            }
    }

    function clock() {
        var d = new Date();
        var month_num = d.getMonth()
        var day = d.getDate();
        var hours = d.getHours();
        var minutes = d.getMinutes();
        var seconds = d.getSeconds();

        month = new Array("ciчня", "лютого", "березня", "квiтня", "травня", "червня", "липня", "серпня", "вересня",
                "жовтня", "листопада", "грудня");

        if (day <= 9) day = "0" + day;
        if (hours <= 9) hours = "0" + hours;
        if (minutes <= 9) minutes = "0" + minutes;
        if (seconds <= 9) seconds = "0" + seconds;

        date_time = "Зараз: <strong>" + hours + ":" + minutes + "&nbsp;/&nbsp;" + day + " " + month[month_num] + " " + d.getFullYear() +
                " р.</strong>";
        if (document.layers) {
            document.layers.doc_time.document.write(date_time);
            document.layers.doc_time.document.close();
        }
        else document.getElementById("doc_time").innerHTML = date_time;
        setTimeout("clock()", 1000);
    }
</script>
<body>
<div id="stripe">
    <form action="/logout" method="POST">
        <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <script language="JavaScript"> day = new Date();
            hour = day.getHours();
            if (hour >= 5 && hour < 12) greeting = "Доброго ранку";
            else {
                if (hour >= 12 && hour < 18) greeting = "Доброго дня";
                else {
                    if (hour >= 18 && hour < 24) greeting = "Добрий вечір";
                    else {
                        if (hour >= 0 && hour < 5) greeting = "Доброї ночі";
                    }
                }
            }
            document.write(greeting); </script>
            </strong>,
            <%= request.getAttribute("username")%>! &nbsp;<span id="doc_time">
 Дата и время
</span>
            <script type="text/javascript">
                clock();
            </script>
            </strong>
            &nbsp; &nbsp; &nbsp; &nbsp;
            <a href="/secure/userslist"><b>Лист користувачів системи</b></a>
            &nbsp;
            <a href="/secure/productslist"><b>Лист пропонуємих товарів</b></a>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <input type="button" value="Змінити пароль" onClick="location.href='/secure/changepassw.jsp'">
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
                                <input type="submit" value="Видалити"/>
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
                <input type="button" value="&lt; &lt;" onclick="changePage(-1)">
                Страница <%= request.getAttribute("page")%>
                <input type="button" value="&gt; &gt;" onclick="changePage(1)">
            </p>
        </td>
    </tr>
</table>
</body>
</html>