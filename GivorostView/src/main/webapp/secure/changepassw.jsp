<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<script type="text/javascript" src="../script/cancelCreateUsr.js"></script>
<head>
    <title>Біогумат ЖИВОРОСТ - Зміна паролю</title>
    <link rel="shortcut icon" href="../img/givorost.ico" type="image/x-ico"/>
    <link rel="stylesheet" type="text/css" href="../content/css/style.css"/>
</head>
<script type="text/javascript" src="/script/isValidEquals.js"></script>
<body style="background-color: #3d503d">
<style>
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
<form name="form" action="/savepassw" method="POST">
    <div id="passwordplank">
        <table>
            <tr>
                <td>
                    <h3>Корегування існуючего паролю</h3>
                    <br>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <%--<input type="hidden" name="id" value="${id}"/>--%>
                    <h4>Старий пароль: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="password"
                                                                                               name="oldpassw" size="10"
                                                                                               required/>
                    </h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h4>Новий пароль: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <input type="password" name="pass1" onKeyUp="passValid('form','pass1','pass12','submit'),
                        isRavno('form','pass1','pass2','pass22','submit')" size="10" required="true"/></h4>
                    <span id="pass11"><span id="pass12"></span></span><br/>
                </td>
            </tr>
            <tr>
                <td>
                    <h4>Ще раз новий пароль: &nbsp;
                        <input type="password" name="pass2" onKeyUp="isRavno('form','pass1','pass2','pass22',
                        'submit')" size="10" required="true"/></h4>
                    <span id="pass22"></span><br/>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h3>
                        <input type="submit" name="submit" value="Готово" disabled>
                        <input type="button" value="Скасувати" onClick="location.href='/secure/adminspage?page=1'">
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