<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Корегування існуючего продукту - Біогумат ЖИВОРОСТ</title>
    <link rel="stylesheet" type="text/css" href="../content/css/style.css"/>
    <link rel="shortcut icon" href="../img/givorost.ico" type="image/x-ico"/>
    <script type="text/javascript" src="../script/corrprod.js"></script>
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
        <input type="submit" value="Вийти з системи"> &nbsp;
        </p>
    </form>
</div>
<form action="corrprod.ado" method="POST">
    <div id="productplank">
        <table>
            <tr>
                <td>
                    <h3>Відкоригуйте значення полів <br/> та виберить "Зберегти"</h3>
                    <br>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <input type="hidden" name="prodid" value="${prodid}"/>
                    <h4>Назва продукту: &nbsp; <input type="text" name="prodname" size="14" value="${prodname}"/>
                    </h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h4>Вартість: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <input type="text" name="price" size="2" value="${price}"/></h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h4>Коефіцієнт витрати: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <input type="text" name="factor" size="2" value="${factor}"/></h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td align="center">
                    <h3>
                        <br/>
                        <input type="submit" value="Зберегти">
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

