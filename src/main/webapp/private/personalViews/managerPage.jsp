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
        <h2>Личный кабинет менеджера</h2>
        <div class="fakeimg" style="height:290px;"><img src = "../../pictures/The-Book-of-Boba-Fett.jpg" width="250" height="250"/></div>

    </div>
    <div class="main">
        <h2>Персональные данные</h2>
        <table>
            <tr>
                <th>ID персонала</th>
                <td>${manager.userId}</td>
            </tr>
            <tr>
                <th>Должность</th>
                <td>${manager.personalType}</td>
            </tr>
            <tr>
                <th>Имя</th>
                <td>${manager.userFirstName}</td>
            </tr>
            <tr>
                <th>Фамилия</th>
                <td>${manager.userLastName}</td>
            </tr>
            <tr>
                <th>Возраст</th>
                <td>${manager.userAge}</td>
            </tr>

        </table>
    </div>
</div>

<div class="footer">
    <h3>Сегодня <%= new java.util.Date() %></h3>
</div>

</body>
</html>