<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
<link rel="stylesheet" type="text/css" href="../../content/css/style.css"/>
<script type="text/javascript" src="../../script/jquery.tablesorter.min.js"></script>
<%--<script type="text/javascript" src="../script/createusr.js"></script>--%>
<script type="text/javascript" src="../script/deleteProduct.js"></script>
<script type="text/javascript" src="../script/correctProduct.js"></script>
<script type="text/javascript" src="../script/users.js"></script>
<head>
    <title>Біогумат ЖИВОРОСТ - Лист користувачів</title>
    <link rel="shortcut icon" href="../img/givorost.ico" type="image/x-icon">
</head>
<script type="text/javascript">
    var count = 1;

    function rowCounter() {
        count_numb = "<strong>" + count + ". </strong>";
        count++;
        if (document.layers) {
            document.layers.row_number.document.write(count_numb);
            document.layers.row_number.document.close();
        }
        else document.getElementById("row_number").innerHTML = count_numb;
    }

    var row = 1;
            function myFunction() {
                document.getElementById("row_number").innerHTML = row;
                row = row + 1;

            }
</script>
<body class="systbody">
    <div id="stripe" align="right">
        <p>
        <img src="../img/usr2.png"/>
        <b style="color: grey">${usrlogin}</b>
        <input type="button" value="Змінити пароль" onclick="ChangePassw()">
        <input type="submit" value="Вийти з системи" onclick="LogOut()"> &nbsp;
        </p>
    </div>
    <div align="center">
        <h2>Перелік користувачів системи</h2>
        <table class="tablesorter1">
            <thead>
                <tr class="column-view">
                    <th class="column-viewHeader1" width="5%">П/п</th>
                    <th class="column-viewHeader2">Логін</th>
                    <th class="column-viewHeader">Як називати</th>
                    <th class="column-viewHeader" width="5%">Адмін</th>
                    <th class="column-viewHeader">E-mail</th>
                    <th class="column-viewHeader">Дата реєстрації</th>
                    <th class="column-viewHeader" width="8%"></th>
                    </tr>
                    </thead>
                    <tbody class="stripy">
                    <c:forEach var="item" items="${users}">
                        <tr class="column-view">
                            <td class="column-view-center" width="5%">${users.indexOf(item) + 1}</td>
                            <td class="column-view"><p><img src="../img/usr1.png"/>${item.login}</p></td>
                            <td class="column-view">${item.name}</td>
                            <td class="column-view-center" width="7%">${item.admin == true ? 'Так' : 'Ні'}</td>
                            <td class="column-view">${item.email}</td>
                            <td class="column-view-center" width="15%">
                                <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${item.registered}"/></td>
                            <td class="column-view-center">
                                    <%--<input type="hidden" name="userid" value="${item.id}" />--%>
                                    <input type="button" value="Видалити" onclick="RemoveUsr(${item.id})"/>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <br/>
                <input type="button" value="Додати нового користувача" onclick="CreateUsr()"/> &nbsp; &nbsp;
                <a href="main.do?p=1">Повернутися до сторинки адмінистратору</a>
        </div>
    </div>
</body>
</html>