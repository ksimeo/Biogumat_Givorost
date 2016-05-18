<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Додавання нового продукту - Біогумат ЖИВОРОСТ</title>
    <link rel="stylesheet" type="text/css" href="../../content/css/style.css"/>
    <link rel="shortcut icon" href="/img/givorost.ico" type="image/x-ico"/>
    <script type="text/javascript" src="../script/createprod.js"></script>
</head>
<body style="background: #3d503d">
<div id="stripe" align="right">
    <form action="/logout.do" method="POST">
        <p>
        &nbsp; &nbsp;
        <b style="color: grey">${usrlogin}</b>
        &nbsp;
        <img src="../img/usr2.png"/>
        <input type="button" value="Змінити пароль" onclick="ChangePassw()">
        <input type="submit" value="Вийти з системи"> &nbsp; </p>
    </form>
</div>
<form action="/createprod.ado" method="POST">
    <div id="productplank">
        <table>
            <tr>
                <td>
                    <h3>Щоб додати новий продукт заповнить
                        <br/>
                        усі поля та виберить "Створити" &nbsp; &nbsp; &nbsp; &nbsp;</h3>
                    <br>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h4>Назва продукту: &nbsp; <input type="text" name="prodname" size="14" required="true"/></h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h4>Вартість: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <input type="text" name="price" size="2" required="true"/></h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h4>Коефіцієнт витрати: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <input type="text" name="factor" size="2" required="true"/></h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td align="center">
                    <h3>
                        <br/>
                        <input type="submit" value="Створити">
                        <input type="button" value="Скасувати" onclick="Cancel()">
                    </h3>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <p style="color: indianred">
                        ${error}
                    </p>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>