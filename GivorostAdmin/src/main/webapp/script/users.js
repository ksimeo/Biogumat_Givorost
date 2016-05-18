/**
 * @author Ksimeo. Created on 05.05.2016 at 20:37 for "Givorost" project.
 * @version 1.0
 * @sin
 * */

 var i = 1;
 $(document).ready(function () {
                $("#tableAllUsers").tablesorter({sortList: [
                    [0, 0],
                    [1, 0]
                ]});
            }
 );

 function ajaxDeleteUser(userId) {
        document.getElementById('currentUser-' + userId).style.display = "none";
        var paramData = "userId" + userId;
        $.ajax({
            type: 'POST',
            url: '/deluser',
            data: userId,
            success: function (servletResult) {
            }
        });
    }

function CreateUsr() {
    document.location = "/createusr.ado";
}

$(document).ready(function () {
        $("#allTasks").tablesorter({sortList: [
            [0, 0],
            [1, 0]
        ]});
    }
);

function RemoveUsr(userId) {
    document.location = "/delusr.ado?id=" + userId;
}

function Cancel() {
    document.location = "/main.do?p=1";
}