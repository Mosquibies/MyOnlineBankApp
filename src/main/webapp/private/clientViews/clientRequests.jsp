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
    <a href="/private/clientViews/clientRequests">Денежные операции</a>
    <a href="/private/clientViews/viewClientHistory">История действий</a>
    <a href="/private/logout" class="right">Выйти</a>
</div>

<div class="row">
    <div class="side">
        <h1>Мои заявки</h1>
    </div>
    <div class="main">
            <h2>Заявки на счет</h2>
            <table>
                <tr>
                    <th>Номер заявки</th>
                    <th>Тип заявки</th>
                    <th>Статус заявки</th>
                    <th></th>
                </tr>
                <c:forEach var="invoiceRequest" items="${invoiceRequests}">
                <tr>
                    <td>${invoiceRequest.requestNumber}</td>
                    <td>${invoiceRequest.requestType}</td>
                    <td>${invoiceRequest.requestStatus}</td>
                    <td>
                    <form method="post" action="/private/clientViews/deleteRequest" style="display:inline;">
                    <input type="hidden" name="number" value="${invoiceRequest.requestNumber}">
                    <input type="submit" value="Скрыть/Отменить">
                    </form>
                    </td>
                </tr>
                </c:forEach>
            </table><br><br>

            <h2>Заявки на карты</h2>
            <table>
                <tr>
                    <th>Номер заявки</th>
                    <th>Тип заявки</th>
                    <th>Статус заявки</th>
                    <th></th>
                </tr>
                <c:forEach var="cardRequest" items="${cardRequests}">
                <tr>
                    <td>${cardRequest.requestNumber}</td>
                    <td>${cardRequest.requestType}</td>
                    <td>${cardRequest.requestStatus}</td>
                    <td>
                    <form method="post" action="/private/clientViews/deleteRequest" style="display:inline;">
                    <input type="hidden" name="number" value="${cardRequest.requestNumber}">
                    <input type="submit" value="Скрыть/Отменить">
                    </form>
                    </td>
                </tr>
                </c:forEach>
            </table><br><br>

            <h2>Заявки на кредит</h2>
            <table>
                <tr>
                    <th>Номер заявки</th>
                    <th>Тип заявки</th>
                    <th>Сумма кредита</th>
                    <th>Срок</th>
                    <th>Проц. ставка</th>
                    <th>Ежем. платеж</th>
                    <th>Статус заявки</th>
                    <th></th>
                </tr>
                <c:forEach var="creditRequest" items="${creditRequests}">
                <tr>
                    <td>${creditRequest.requestNumber}</td>
                    <td>${creditRequest.requestType}</td>
                    <td>${creditRequest.sum}</td>
                    <td>${creditRequest.time}</td>
                    <td>${creditRequest.percent}</td>
                    <td>${creditRequest.payment}</td>
                    <td>${creditRequest.requestStatus}</td>
                    <td>
                    <form method="post" action="/private/clientViews/deleteRequest" style="display:inline;">
                        <input type="hidden" name="number" value="${creditRequest.requestNumber}">
                        <input type="submit" value="Скрыть/Отменить">
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