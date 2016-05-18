<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<script type="text/javascript" src="../script/jquery-1.11.1.min.js"></script>
<head>
    <title>Журнал замовлень - Біогумат ЖИВОРОСТ</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../content/css/style.css"/>
    <link rel="shortcut icon" href="../img/givorost.ico" type="image/x-icon">
    <script type="text/javascript" src="../script/main.js"></script>
    <script type="text/javascript" src="jquery.js"></script>
</head>
<script type="text/javascript">
    var currentPage = ${page};

    function DoViewed(id) {
        document.location = "/viewed.do";
    }

    function ajaxDoConsider(orderId) {

        var paramData = "orderId=" + orderId;
        $.ajax({
            type:'POST',
            url:'consider.do',
            data: paramData,
            success: function(servletResult) {
                console.log("Date:" + servletResult.date + "State:" + servletResult.state);
                document.getElementById('considerOrder-' + orderId).innerHTML = '<h6>' + servletResult.date + '<br/>' +
                + 'by ' + ${usrlogin} + servletResult.login + '</h6>';
                document.getElementById("considerOrder-" + orderId).style.display = "true";
                document.getElementById('state-' + orderId).innerHTML = servletResult.state;
            },
            error: function() {
                console.log('error');
            }
        });
    }

                //Функция показа
            function show(state){

                document.getElementById('window').style.display = state;
                document.getElementById('wrap').style.display = state;
            }
</script>
<body class="systbody">
<div id="stripe">
    <form action="logout.do" method="GET">
        <p>&nbsp; &nbsp;
            <script language="JavaScript"> day = new Date();
            hour = day.getHours();
            if (hour >= 5 && hour < 12) greeting = "Доброго ранку,";
            else {
                if (hour >= 12 && hour < 18) greeting = "Доброго дня,";
                else {
                    if (hour >= 18 && hour < 24) greeting = "Добрий вечір,";
                    else {
                        if (hour >= 0 && hour < 5) greeting = "Доброї ночі,";
                    }
                }
            }
            document.write(greeting); </script>
            <strong>
            <%= request.getAttribute("username")%>!</strong> &nbsp;<span id="doc_time">Дата и время</span>
            <script type="text/javascript">
                clock();
            </script>
            &nbsp;
            <a href="users.ado" style="color: forestgreen" ${mark3}><b>До листу користувачів системи</b></a>
            <a href="products.ado" style="color: forestgreen" ${mark3}><b>До листу пропонуємих товарів</b></a>
            &nbsp;
            <img src="../img/usr2.png"/>
            <b style="color: grey">${usrlogin}</b>
            <input type="button" value="Змінити пароль" onclick="ChangePassw()">
            <input type="submit" value="Вийти з системи"></p>
    </form>
</div>
<table id="t">
  <tr>
    <td align="center">
      <h2><strong>Журнал замовлень які надійшли до нашого сервісу</strong></h2>
      <table class="tablesorter">
        <thead>
        <tr class="column-view">
          <th class="column-viewHeader" width="5">№</th>
          <th class="column-viewHeader" width="8">Дата і час</th>
          <th class="column-viewHeader">Ім'я</th>
          <th class="column-viewHeader">Номер телефону</th>
          <th class="column-viewHeader">Електронна адреса</th>
          <th class="column-viewHeader">Регіон</th>
          <th class="column-viewHeader" width="20">Назва товару</th>
          <th class="column-viewHeader">Кількість, л</th>
          <th class="column-viewHeader"></th>
        </tr>
        </thead>
        <tbody class="stripy">
        <c:forEach var="item" items="${orders}">
          <tr class="column-view" ${item.considerDate == null ? 'style="color: grey"' : ' '} >
            <input type="hidden" name="currpage" value="${page}"/>
              <td class="column-view-center">${item.id}</td>
              <td class="column-view"><fmt:formatDate pattern="HH:mm:ss dd.MM.yyyy" value="${item.date}"/></td>
              <td class="column-view">${item.name}</td>
              <td class="column-view">${item.tel}</td>
              <td class="column-view">${item.email}</td>
              <td class="column-view">${item.region}</td>
              <td class="column-view">${item.productName}</td>
              <td class="column-view-center" style="text-align: center;">${item.number}</td>
              <td class="column-view-center">
                  <div id="considerOrder-${item.id}">
                      <c:if test="${empty item.considerDate}">
                          <input id = "orderId-${item.id}" type="button" value="Переглянуто"
                                 onclick="ajaxDoConsider(${item.id})"/>
                      </c:if>
                      <c:if test="${not empty item.considerDate}">
                          <h6><fmt:formatDate pattern="dd-MM-yy HH:mm" value="${item.considerDate}"/><br/>
                          by ${item.considerLogin}</h6>
                          <%--<p>${item.considerDate}</p>--%>
                      </c:if>
                  </div>
                  <%--<input type="button" onclick="DoViewed(${item.id})" value="Переглянуто" ${item.considerDate != null2 ? 'hidden' : ' '}/>--%>
              </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </td>
  </tr>
    <tr>
        <td>
            <p align="center">
                <input type="button" value="&lt; &lt;" onclick="changePage(-1)" ${mark1}>
                <strong>Сторiнка ${page}</strong>
                <%--<%= request.getAttribute("page")%>--%>
                <input type="button" value="&gt; &gt;" onclick="changePage(1)" ${mark2}>
            </p>
        </td>
    </tr>
</table>
</body>
</html>