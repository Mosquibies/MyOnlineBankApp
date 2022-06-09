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
    <div class="side">
        <a href="/private/personalViews/createClient" > Добавить нового клиента</a>
    </div>
    <div class="main">
        <h2>Список клиентов банка</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Возраст</th>
                <th>Номер телефона</th>
                <th>Счета</th>
                <th>Карты</th>
                <th>Кредиты</th>
                <th></th>
            </tr>
            <c:forEach var="client" items="${clients}">
                <tr>
                    <td>${client.userId}</td>
                    <td>${client.userFirstName}</td>
                    <td>${client.userLastName}</td>
                    <td>${client.userAge}</td>
                    <td>${client.userPhone}</td>
                    <td>${client.invoicesCount}</td>
                    <td>${client.cardsCount}</td>
                    <td>${client.creditCount}</td>
                    <td>
                        <a href="/private/personalViews/editClient?id=${client.userId}" > Редактировать</a>
                    </td>
                    <td>
                        <form method="post" action="/private/personalViews/deleteClient" style="display:inline;">
                            <input type="hidden" name="id" value="${client.userId}">
                            <input type="submit" value="Удалить из базы">
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