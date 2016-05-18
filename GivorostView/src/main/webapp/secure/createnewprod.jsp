<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<script type="text/javascript" src="../script/cancelCreateProd.js"></script>
<head>
    <title>Додавання нового продукту - Біогумат ЖИВОРОСТ </title>
    <link rel="stylesheet" type="text/css" href="../../content/css/style.css"/>
    <link rel="shortcut icon" href="/img/givorost.ico" type="image/x-ico"/>
</head>
<body style="background: #3d503d">
<form action="/addproduct" method="POST">
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
                    <h4>Назва продукту: &nbsp; <input type="text" name="productname" size="14" required="true"/></h4>
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
                        <input type="button" value="Скасувати" onClick="location.href='/secure/productslist'">
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