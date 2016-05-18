<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Розрахунок необхоідної кількості продукту - Біогумат ЖИВОРОСТ</title>
    <link rel="shortcut icon" href="../img/givorost.ico" type="image/x-ico"/>
    <link rel="stylesheet" type="text/css" href="../content/css/style.css"/>
</head>
<script type="text/javascript">
    function changeText0() {
        var res = 1;
        var z = document.getElementsByName('agroculture');
        for (var i = 0; i < z.length; i++) {
            if (document.getElementsByName('agroculture')[i].checked == true) {
                if (i == 0) res = 1.23;
                else if (i == 1) res = 2.84;
                else if (i == 2) res = 1.8;
                else if (i == 3) res = 0.7;
                else if (i == 4) res = 1.2;
                else if (i == 5) res = 2.4;
                else if (i == 6) res = 0.5;
            }
        }
        if (res != 1) {
            var type = document.getElementById('producttype').options[document.getElementById('producttype').selectedIndex].value;
            var razmern = parseInt(document.getElementById('razmern').value);
            var number = parseFloat(document.getElementById('number').value);
            var prod;
            if (number > 0 && number != "NaN") {
                res *= number;
                res *= razmern;
                prod = type;
                res *= prod;
                res = Math.round(res);
                var id = document.getElementById('producttype').options[document.getElementById('producttype').selectedIndex].id;
                document.getElementById('result').innerHTML = '<hr/><h2><p style="color: #006942;"> Вам знадобиться ' + res +
                        'л биогумату </p></h2> <h2><p><a href="ordering?numb=' + res + '&type=' + id + '">' +
                        'Здійснити замовлення</a>&nbsp; <a href="../index.jsp">Повернутися на головну</a> </p></h2>';
            }

        } else {
            document.getElementById('result').innerHTML = '<hr/><h2><p style="color: indianred;"> Ви ввели не всі дані! </p></h2>';
        }
    }
</script>

<body class="systbody">
<form onsubmit="return false;" oninput="changeText0()">
    <div id="agrocalcplank">
        <table>
            <tr>
                <td>
                    <p>

                    <h3>Ви можете розрахувати кількість біогумату, який знадобиться
                        <br> для ваших цілей, для цього, просто, заповніть форму нижче</h3></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p><h4>Виберіть тип рослинної культури:</h4></p>
                </td>
            </tr>
            <tr>
                <td>
                    <table>
                        <tr>
                            <td align="left">
                                <input type="radio" name="agroculture" value="r1" onchange="changeText0()">Зернові
                                культури</input><br/>
                                <input type="radio" name="agroculture" value="r2"
                                       onchange="changeText0()">Кукурудза</input><br/>
                                <input type="radio" name="agroculture" value="r3"
                                       onchange="changeText0()">Соняшник</input><br/>
                                <input type="radio" name="agroculture" value="r4"
                                       onchange="changeText0()">Ріпак </input><br/>
                                <input type="radio" name="agroculture" value="r5" onchange="changeText0()">Соя</input>
                                <br/>
                                <input type="radio" name="agroculture" value="r6"
                                       onchange="changeText0()">Картопля</input><br/>
                                <input type="radio" name="agroculture" value="r7"
                                       onchange="changeText0()">Морква</input>
                            </td>
                            <td align="left">
                                <input type="radio" name="agroculture" value="r8"
                                       onchange="changeText0()">Огірки</input><br/>
                                <input type="radio" name="agroculture" value="r9"
                                       onchange="changeText0()">Капуста</input><br/>
                                <input type="radio" name="agroculture" value="r10"
                                       onchange="changeText0()">Пасльонові</input><br/>
                                <input type="radio" name="agroculture" value="r11" onchange="changeText0()">Сади</input>
                                <br/>
                                <input type="radio" name="agroculture" value="r12"
                                       onchange="changeText0()">Виноград</input><br/>
                                <input type="radio" name="agroculture" value="r13" onchange="changeText0()">Ягідні
                                культури</input><br/>
                                <input type="radio" name="agroculture" value="r14" onchange="changeText0()">Кімнатні
                                рослини</input>
                            </td>
                        </tr>
                    </table>
                </td>

            </tr>
            <tr>
                <td>
                    <br/>
                    <h4>Вкажіть конкретний тип біогумату і засаджуєму площу:</h4>
                    <select id="producttype" name="products" size="1" onchange="changeText0()">
                        <option name="type" id="0" value="0">-Выберите-марку-продукта-</option>
                        <c:forEach items="${products}" var="item">
                            <option name="type" id="${item.id}" value="${item.factor}">${item.name}</option>
                        </c:forEach>
                    </select>
                    <input type="number" name="products" id="number" min="1" max="999999" required
                           oninput="changeText0()">
                    <select id="razmern" name="products" size="1">
                        <option value="1">Га</option>
                        <option value="100">Ар</option>
                        <option value="10000">кв.м</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <output id="result"></output>
                </td>
            </tr>
            <tr>
                <td>
                    <%--<div class=""><h6>&#169;2015 Ksimeo`s services(Development web&corp. services. e-mail: ksimeo@gmail.com)</h6></div>--%>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>