<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
isELIgnored="false"
%>
<%
response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
response.setHeader("Pragma", "no-cache");
%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>My online bank</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../../css/common.css" />
</head>
<body>

<div class="header">
    <h1>Онлайн-банк "Деньги из воздуха"</h1>
    <h3>Если Вам кажется, что Вас обманули - Вы чертовски правы!</h3>
</div>

<div class="navbar">
    <a href="/private/clientViews/clientPage">В личный кабинет</a>
    <a href="/private/clientViews/clientInvoices">Счета</a>
    <a href="/private/clientViews/clientCards">Карты</a>
    <a href="/private/clientViews/clientCredits">Кредиты</a>
    <a href="/private/clientViews/clientRequests">Заявки</a>
    <a href="/private/clientViews/clientMoneyOperations">Денежные операции</a>
    <a href="/private/clientViews/viewClientHistory">История действий</a>
    <a href="/private/logout" class="right">Выйти</a>
</div>

<div class="row">
    <div class="side">
        <h2>Досрочное погашение кредита</h2>
        <h4>Сумма: ${credit.sum} </h4>
    </div>
    <div class="main">
        <h2>Выберите счет:</h2>
        <table>
            <tr>
                <th>Номер счета</th>
                <th>Баланс</th>
                <th></th>
            </tr>
            <c:forEach var="invoice" items="${invoices}">
                <tr>
                    <td>${invoice.number}</td>
                    <td>${invoice.balance}</td>
                    <td>
                        <form method="post" action="/private/clientViews/earlyCreditPayment?crdNum=${credit.number}" style="display:inline;">
                            <input type="hidden" name="invNum" value="${invoice.number}">
                            <input type="submit" value="Погасить">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<div class="footer">
    <h3>Сегодня <%= new java.util.Date() %></h3>
</div>

</body>
</html>