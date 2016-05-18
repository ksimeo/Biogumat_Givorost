<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Службовий вхід до системи - Givorost Admins Server v.2.5 </title>
    <link rel="shortcut icon" href="img/givorost.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="content/css/style.css"/>
</head>
<body id="enterbody">
<form action="login" method="POST">
    <table id="enterform">
        <tr>
            <td>
                <h3 style="color: #232f23">СЛУЖБОВИЙ ВХIД ДО СИСТЕМИ<br/>АДМИНICTPУВАННЯ</h3>
            </td>
        </tr>
        <tr>
            <td>
                <h4>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Логін: &nbsp;
                    <input type="text" name="login" size="14" required="true"/></h4>
            </td>
        </tr>
        <tr>
            <td>
                <h4>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Пароль: &nbsp;
                    <input type="password" name="password" size="12" required="true"/></h4>
            </td>
        </tr>
        <tr>
            <td>
                <h5>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <a href="/forgotpassw?lang=ukr" style="color: #164b2f">Забув пароль!</a>
                    &nbsp; &nbsp; &nbsp;<input type="submit" value="Увійти"/></h5>
            </td>
        </tr>
        <tr>
            <td>
                <p style="color: #954545">
                ${error}
                </p>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
