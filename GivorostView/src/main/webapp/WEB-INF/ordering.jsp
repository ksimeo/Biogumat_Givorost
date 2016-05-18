<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<script type="text/javascript" src="../script/jquery-1.9.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="../content/css/style.css"/>
<link rel="shortcut icon" href="../img/givorost.ico" type="image/x-ico"/>
<head>
    <title>Біогумат Живорост - Здійснення замовлення</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="../img/givorost.ico" type="image/x-icon">
    <script type="text/javascript">
        var defaultValue;
        onload = function onLoad() {
            var p_url = location.search.substring(1);
            document.getElementById('number').value = p_url;
        }
        }
        ;

    </script>
</head>
<body class="systbody" onload="onLoad()">
<form action="/ordering" method="post">
    <div id="orderplank">
        <table>
            <tr>
                <td>
                    <h3>Для здійснення замовлення заповніть<br/>форму нижче та натисніть "Замовити"</h3>
                    <br>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h4>Ваш контактний номер телефону: &nbsp; &nbsp; <input type="tel" name="telnumber" size="9"
                                                                            required="true" placeholder="обов`язково"/>
                    </h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h4>Ваше ім'я: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; <input type="text" name="ordername" size="20" placeholder="бажано"/></h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h4>Ваша електронна адреса: &nbsp; <input type="email" name="address" size="19"
                                                              placeholder="бажано"/>
                    </h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h4>Ваш регіон: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        &nbsp; &nbsp; &nbsp; &nbsp;
                        <select size="1" name="region">
                            <option value="Крим">АР Крим</option>
                            <option value="Віннічина">Віннічина</option>
                            <option value="Волинщина">Волинщина</option>
                            <option value="Дніпропетровщина">Дніпропетровщина</option>
                            <option value="Донеччина">Донеччина</option>
                            <option value="Житомирщина">Житомирщина</option>
                            <option value="Закарпаття">Закарпаття</option>
                            <option value="Запоріжчина">Запоріжчина</option>
                            <option value="Івано-Франківщина">Івано-Франківщина</option>
                            <option value="Київщина">Киівщина</option>
                            <option value="Кіровоградчина">Кіровоградчина</option>
                            <option value="Луганщина">Луганщина</option>
                            <option value="Львівщина">Львівщина</option>
                            <option value="Миколаївщина">Миколаївщина</option>
                            <option value="Одесчина">Одесчина</option>
                            <option value="Полтавщина">Полтавщина</option>
                            <option value="Рівненщина">Рівненщина</option>
                            <option value="Сумщина">Сумщина</option>
                            <option value="Тернопільщина">Тернопільщина</option>
                            <option value="Харківщина">Харківщина</option>
                            <option value="Херсонщина">Херсонщина</option>
                            <option value="Хмельниччина">Хмельниччина</option>
                            <option value="Черкасчина">Черкасчина</option>
                            <option value="Чернівеччина">Чернівеччина</option>
                            <option value="Чернігівщина">Чернігівщина</option>
                            <option value=" " selected="true"></option>
                        </select>
                    </h4>
                </td>
            </tr>
            <tr>
                <td>
                    <h4>Вкажіть тип та кількість биогумату, яке<br/>
                        вам потрібно: &nbsp;
                        <select id="prod" name="product" size="1">
                            <c:forEach items="${products}" var="item">
                                <option name="type"
                                        value="${item.name}" ${item.id == prodType ? 'selected="selected"' : ''}>${item.name}</option>
                            </c:forEach>
                        </select>
                        <input type="number" id="number" name="number" min="1" max="999999" required="true"
                               placeholder="обов'язково" value="${number}"/> л
                    </h4>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <h3><input type="submit" value="Замовити">
                        &nbsp; &nbsp; <a href="/agrocalc">Повернутися до розрахунку кількості</a>
                    </h3>
                </td>
            </tr>
            <tr class="fieldsName">
                <td>
                    <p style="color:indianred">
                        ${error}
                    </p>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>