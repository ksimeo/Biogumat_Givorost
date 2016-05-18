<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<script type="text/javascript" src="../script/jquery-1.9.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="../content/css/style.css"/>
<link rel="shortcut icon" href="../img/givorost.ico" type="image/x-ico"/>
<head>
    <title>Осуществление заказа - Биогумат ЖИВОРОСТ</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="../img/givorost.ico" type="image/x-icon">
    <script type="text/javascript">
        var defaultValue;
        onload = function onLoad() {

            var p_url = location.search.substring(1);
            document.getElementById('number').value = p_url;

        };

    </script>
</head>
<body class="systbody" onload="onLoad()">
<form action="/ordering" method="post">
    <div id="orderplank">
        <table>
            <tr>
                <td>
                    <h3>Для совершения заказа заполните<br/>форму ниже и нажмите "Заказать"</h3>
                    <br>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h4>Ваш контактный номер телефона: &nbsp; &nbsp; <input type="tel" name="telnumber" size="9"
                                                                            required="true" placeholder="обязательно"/>
                    </h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h4>Ваше имя: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; <input type="text" name="ordername" size="20" placeholder="желательно"/></h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h4>Ваш електронный адрес: &nbsp; <input type="email" name="address" size="19"
                                                             placeholder="желательно"/>
                    </h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h4>Ваш регіон: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp;
                        <select size="1" name="region">
                            <option value="Крим">АР Крым</option>
                            <option value="Віннічина">Винницкая обл.</option>
                            <option value="Волинщина">Волынская обл.</option>
                            <option value="Дніпропетровщина">Днепропетровская обл.</option>
                            <option value="Донеччина">Донецкая обл.</option>
                            <option value="Житомирщина">Житомирская обл.</option>
                            <option value="Закарпаття">Закарпатская обл.</option>
                            <option value="Запоріжчина">Запорожская обл.</option>
                            <option value="Івано-Франківщина">Ивано-Франковская обл.</option>
                            <option value="Київщина">Киевская обл.</option>
                            <option value="Кіровоградчина">Кировоградская обл.</option>
                            <option value="Луганщина">Луганская обл.</option>
                            <option value="Львівщина">Львовская обл.</option>
                            <option value="Миколаївщина">Николаевская обл.</option>
                            <option value="Одесчина">Одесская обл.</option>
                            <option value="Полтавщина">Полтавская обл.</option>
                            <option value="Рівненщина">Ровненская обл.</option>
                            <option value="Сумщина">Сумская обл.</option>
                            <option value="Тернопільщина">Тернопольская обл.</option>
                            <option value="Харківщина">Харьковская обл.</option>
                            <option value="Херсонщина">Херсонская обл.</option>
                            <option value="Хмельниччина">Хмельницкая обл.</option>
                            <option value="Черкасчина">Черкасская обл.</option>
                            <option value="Чернівеччина">Черновецкая обл.</option>
                            <option value="Чернігівщина">Черниновская обл.</option>
                            <option value=" " selected="true"></option>
                        </select>
                    </h4>
                </td>
            </tr>
            <tr>
                <td>
                    <h4>Укажите тип и количество биогумата, которое<br/>
                        вам нужно: &nbsp;
                        <select id="prod" name="product" size="1">
                            <c:forEach items="${products}" var="item">
                                <option name="type"
                                        value="${item.name}" ${item.id == prodType ? 'selected="selected"' : ''}>${item.name}</option>
                            </c:forEach>
                        </select>
                        <input type="number" id="number" name="number" min="1" max="999999" required="true"
                               placeholder="обязательно" value="${number}"/> л
                    </h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <%--<h5>* - Поля обов'язкови для заповнення</h5>--%>
                    <h3><input type="submit" value="Заказать">
                        &nbsp; &nbsp; <a href="/agrocalc">Вернуться к рассчету количества</a>
                    </h3>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <p style="color:indianred">
                        ${Error}
                    </p>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>