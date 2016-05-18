<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
<link rel="stylesheet" type="text/css" href="../../content/css/style.css"/>
<script type="text/javascript" src="../../script/jquery.tablesorter.min.js"></script>
<script type="text/javascript" src="../script/createusr.js"></script>
<script type="text/javascript" src="../script/deleteProduct.js"></script>
<script type="text/javascript" src="../script/correctProduct.js"></script>
<head>
    <title>Біогумат ЖИВОРОСТ - Лист користувачів</title>
    <link rel="shortcut icon" href="../../img/worms.ico" type="image/x-icon">
</head>

<script type="text/javascript">
    var i = 1;

    $(document).ready(function () {
                $("#tableAllUsers").tablesorter({sortList: [
                    [0, 0],
                    [1, 0]
                ]});
            }
    );

    function ajaxDeleteUser(userId) {

        document.getElementById('currentUser-' + userId).style.display = "none";
        var paramData = "userId" + userId;

        $.ajax({
            type: 'POST',
            url: '/deluser',
            data: userId,
            success: function (servletResult) {
            }
        });
    }

    function CreateUsr() {
        document.location = "/secure/createnewusr.jsp";
    }

    $(document).ready(function () {
                $("#allTasks").tablesorter({sortList: [
                    [0, 0],
                    [1, 0]
                ]});
            }
    );


</script>
<body class="systbody">
<table id="t1">
    <tr>
        <td align="center">
            <div class="table-userdata" align="center">
                <br/>
                <br/>
                <center>
                    <h2>Реєстр користувачів системи</h2>
                </center>
                <table class="tablesorter">
                    <thead>
                    <tr class="column-view">
                        <th class="column-viewHeader">П/п</th>
                        <th class="column-viewHeader">Логін</th>
                        <th class="column-viewHeader">Як звати</th>
                        <th class="column-viewHeader">Cтатус адміністратору</th>
                        <th class="column-viewHeader"></th>
                    </tr>
                    </thead>
                    <tbody class="stripy">
                    <c:forEach var="item" items="${users}">
                        <tr class="column-view">
                            <td class="column-view-center">${item.id}</td>
                            <td class="column-view">${item.login}</td>
                            <td class="column-view">${item.name}</td>
                            <td class="column-view-center">${item.admin}</td>
                            <td class="column-view-center">
                                <form action="/deluser" method="POST">
                                    <input type="hidden" name="userid" value="${item.id}"/>
                                    <input type="submit" value="Видалити"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <br/>

                <p>
                    <input type="button" value="Додати користувача" onclick="CreateUsr()"/> &nbsp; &nbsp; &nbsp; <a
                        href="/secure/adminspage?page=1">Повернутися до головної сторинки адмінистратору</a>
                </p>
            </div>
        </td>
    </tr>
</table>
</body>
</html>