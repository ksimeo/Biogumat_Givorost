/**
 * @author Ksimeo. Created on 06.05.2016 at 20:34 for "Givorost" project.
 * @version 1.0
 * @since 1.0
 */

function CreateProduct() {

    document.location = "/createprod.ado";
}

function CorrProduct(id) {

    document.location="/corrprod.ado?id=" + id;
}

function DelProduct(id) {

    document.location = "/delprod.ado?id=" + id;
}

function LogOut() {

    document.location = "/logout.do";
}