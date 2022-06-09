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
    <title>Online-bank</title>
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
    <a href="/private/personalViews/managerPage">В личный кабинет</a>
    <a href="/private/personalViews/viewAllClients">Операции с клиентами</a>
    <a href="/private/personalViews/viewAllActiveRequests">Заявки</a>
    <a href="/private/personalViews/viewAllInvoices">Счета</a>
    <a href="/private/personalViews/viewAllCards">Карты</a>
    <a href="/private/personalViews/viewAllCredits">Кредиты</a>
    <a href="/private/personalViews/viewPersonalHistory">История действий</a>
    <a href="/private/logout" class="right">Выйти</a>
</div>

<div class="row">
    <div class="main">
        <h2>Список всех счетов</h2>
            <table>
                <tr>
                    <th>Number</th>
                    <th>Balance</th>
                    <th>ClientId</th>
                    <th></th>
                </tr>
                <c:forEach var="invoice" items="${invoices}">
                <tr>
                    <td>${invoice.number}</td>
                    <td>${invoice.balance}</td>
                    <td>${invoice.clientId}</td>
                    <td>
                    <form method="get" action="/private/personalViews/viewAllInvoices" style="display:inline;">
                        <input type="hidden" name="" value="">
                        <input type="submit" value="Информация о клиенте">
                    </form>
                    </td>
                </tr>
                </c:forEach>
            </table><br><br>
    </div>
</div>

<div class="footer">
    <h3>Сегодня <%= new java.util.Date() %></h3>
</div>

</body>
</html>