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
    <a href="/private/clientViews/clientPage">В личный кабинет</a>
    <a href="/private/clientViews/clientInvoices">Счета</a>
    <a href="/private/clientViews/clientCards">Карты</a>
    <a href="/private/clientViews/clientCredits">Кредиты</a>
    <a href="/private/clientViews/clientRequests">Заявки</a>
    <a href="/private/clientViews/clientCards">Денежные операции</a>
    <a href="/private/clientViews/viewClientHistory">История действий</a>
    <a href="/private/logout" class="right">Выйти</a>
</div>

<div class="row">
    <div class="side">
        <p><a href="/private/clientViews/openCardRequest" > Заявка на открытие карты </a></p>
    </div>
    <div class="main">
        <h2>Мои карты</h2>
        <table>
            <tr>
                <th>Номер карты</th>
                <th>Номер счета</th>
                <th>Баланс</th>
                <th></th>
            </tr>
            <c:forEach var="card" items="${cards}">
            <tr>
                <td>${card.number}</td>
                <td>${card.invoiceNumber}</td>
                <td>${card.balance}</td>
                <td>
                    <form method="post" action="/private/clientViews/closeCardRequest" style="display:inline;">
                    <input type="hidden" name="number" value="${card.number}">
                    <input type="submit" value="Заявка на закрытие карты">
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