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
        <h2>Изменение данных клиента</h2>
    </div>
    <div class="main">
        <h2>Редактирование</h2>
        <form method="post">
            <input type="hidden" value="${client.userId}" name="id" />
            <label>Имя</label><br>
            <input name="firstname" value="${client.userFirstName}" /><br><br>
            <label>Фамилия</label><br>
            <input name="lastname" value="${client.userLastName}" /><br><br>
            <label>Возраст</label><br>
            <input name="age" value="${client.userAge}" type="number" min="18" /><br><br>
            <label>Номер телефона</label><br>
            <input name="phone" value="${client.userPhone}" type="number" /><br><br>
            <label>Пароль</label><br>
            <input name="password" value="${client.userPassword}" readonly/><br><br>
            <label>Количество счетов</label><br>
            <input name="invoices" value="${client.invoicesCount}" type="number" min="0" readonly /><br><br>
            <label>Количество карт</label><br>
            <input name="cards" value="${client.cardsCount}" type="number" min="0" readonly /><br><br>
            <label>Количество кредитов</label><br>
            <input name="credits" value="${client.creditCount}" type="number" min="0" readonly /><br><br>

            <input type="submit" value="Применить изменения" />
        </form>
    </div>
</div>

<div class="footer">
    <h3>Сегодня <%= new java.util.Date() %></h3>
</div>

</body>
</html>