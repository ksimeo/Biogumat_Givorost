<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<script type="text/javascript" src="../script/cancelCreateUsr.js"></script>
<link rel="stylesheet" type="text/css" href="../../content/css/style.css"/>
<head>
    <title>Біогумат ЖИВОРОСТ - Створення нового користувача</title>
    <link rel="shortcut icon" href="/img/givorost.ico" type="image/x-ico"/>
</head>
<script type="text/javascript" src="/script/isValidEquals.js"></script>
<body>
<style>
    body {
        /*color:#C8C8C8;*/
        background: #3d503d;
        font-family: fantasy;
    }

    /*Блок,в котором плавает индикатор надежности пароля*/
    #pass11 {
        background: #000;
        width: 98px;
        height: 10px;
        border: 1px solid #fff;
        display: block;
        overflow: hidden;
    }

    /*индикатор надежности пароля*/
    #pass12 {
        margin-left: -102px;
        width: 100px;
        height: 8px;
        background: #f00;
        border: 1px solid #fff;
        display: block;
    }

    /*индикатор совпадения паролей*/
    #pass22 {
        padding: 1px 4px;
        width: 136px;
        display: block;
        font-size: 10px;
    }

    input {
        width: 140px;
    }

    a {
        position: absolute;
        bottom: 10px;
        right: 10px;
        font-weight: bold;
        color: #fff;
        font-size: 50px;
    }
</style>
<form name="form" action="/adduser" method="POST">
    <div id="userplank">
        <table>
            <tr>
                <td>
                    <h3>Для створення нового користувача системи, будь<br/>
                        ласка, заповнить усі поля та натисніть "Створити"</h3>
                    <br>
                </td>
            </tr>
            <tr class="fieldsName">
                <td align="center">
                    <h4>Як називати: &nbsp; <input type="text" name="username" size="14" required="true"/></h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td align="center">
                    <h4>Логін: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <input type="text" name="userlogin" size="10" required="true"/></h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td align="center">
                    <h4>Пароль: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <input type="password" name="pass1" onKeyUp="passValid('form','pass1','pass12','submit'),
                        isRavno('form','pass1','pass2','pass22', 'submit')" size="8" required="true"/></h4>
                    <span id="pass11"><span id="pass12"></span></span><br/>
                </td>
            </tr>
            <tr class="fieldsName">
                <td align="center">
                    <h4>Ще раз пароль:
                        <input type="password" onKeyUp="isRavno('form','pass1','pass2','pass22', 'submit')"
                               name="pass2" size="5" required="true"/></h4>
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <span id="pass22"></span><br/>
                </td>
            </tr>
            <tr class="fieldsName">
                <td align="center">
                    <h4>Чи матиме статус &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; <br/>
                        администратору: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <select size="1" name="adminstatus">
                            <option value="true">Так</option>
                            <option value="false">Ні</option>
                        </select>
                        <br/>
                    </h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td align="center">
                    <h3>
                        <br/>
                        <input type="submit" name="submit" value="Створити" disabled>
                        <input type="button" value="Скасувати" onclick="CancelCreateUsr()">
                    </h3>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <p style="color: indianred">
                        ${Error}
                    </p>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
