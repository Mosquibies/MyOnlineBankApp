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
    <a href="/private/clientViews/clientPage">Денежные операции</a>
    <a href="/private/clientViews/viewClientHistory">История действий</a>
    <a href="/private/logout" class="right">Выйти</a>
</div>

<div class="row">
    <div class="side">
        <h2>Личный кабинет клиента</h2>
        <div class="fakeimg" style="height:290px;"><img src = "../../pictures/Jjportrait.jpg" width="250" height="250"/></div>

    </div>
    <div class="main">
        <h2>Персональные данные</h2>
        <table>
            <tr>
                <th>ID клиента</th>
                <td>${client.userId}</td>
            </tr>
            <tr>
                <th>Имя</th>
                <td>${client.userFirstName}</td>
            </tr>
            <tr>
                <th>Фамилия</th>
                <td>${client.userLastName}</td>
            </tr>
            <tr>
                <th>Возраст</th>
                <td>${client.userAge}</td>
            </tr>
            <tr>
                <th>Номер телефона</th>
                <td>${client.userPhone}</td>
            </tr>
            <tr>
                <th>Счета</th>
                <td>${client.invoicesCount}</td>
            </tr>
            <tr>
                <th>Карты</th>
                <td>${client.cardsCount}</td>
            </tr>
            <tr>
                <th>Кредиты</th>
                <td>${client.creditCount}</td>
            </tr>
        </table>
    </div>
</div>

<div class="footer">
    <h3>Сегодня <%= new java.util.Date() %></h3>
</div>

</body>
</html>