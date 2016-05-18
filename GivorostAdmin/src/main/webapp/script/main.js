/**
 * @author Ksimeo. Created on 03.05.2016 at 13:59 for "Givorost" project.
 * @version 1.0
 * @since 1.0
 */

function changePage(increment) {
    var tmp = currentPage + increment;
    if (tmp > 0) {
//            currentPage += increment;
        document.location ="/main.do?p="+ tmp + "&isfirst=true";
    }
}

function pressButtonChangePassword() {
    document.location = "/changepassw.do";
}

$(document).ready(function() {
        $("#tableAllOrders").tablesorter( {sortList: [[0,0], [1,0]]} );
    }
);

script.onload = function makeStripy(tabClass) {
    var tabs = document.getElementsByTagName("table");
    for (var e = 0; e < tabs.length; e++)
        if (tabs[e].className == tabClass) {
            var rows = tabs[e].getElementsByTagName("tr");
            for (var i = 0; i < rows.length; i++) // строки нумеруются с 0
                rows[i].className += ((i % 2) == 0 ? " oddrows" : " evenrows");
        }
}

function clock() {
    var d = new Date();
    var month_num = d.getMonth()
    var day = d.getDate();
    var hours = d.getHours();
    var minutes = d.getMinutes();
    var seconds = d.getSeconds();
    var day_of_week_num = d.getDay();
    var day_of_week = new Array("неділя", "понеділок", "вівторок", "середа", "четвер", "п'ятниця", "субота");

    month = new Array("ciчня", "лютого", "березня", "квiтня", "травня", "червня", "липня", "серпня", "вересня",
        "жовтня", "листопада", "грудня");

    if (day <= 9) day = "0" + day;
    if (hours <= 9) hours = "0" + hours;
    if (minutes <= 9) minutes = "0" + minutes;
    if (seconds <= 9) seconds = "0" + seconds;

    date_time = "Зараз: <strong>" + hours + ":" + minutes + " / " + day + " " + month[month_num] + " "
        + d.getFullYear() +
        " р. </strong> (" + day_of_week[day_of_week_num] + ")";
    if (document.layers) {
        document.layers.doc_time.document.write(date_time);
        document.layers.doc_time.document.close();
    }
    else document.getElementById("doc_time").innerHTML = date_time;
    setTimeout("clock()", 1000);
}

function ChangePassw() {

    document.location = "/changepassw.do";
}