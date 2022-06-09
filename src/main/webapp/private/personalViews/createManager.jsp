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
    <a href="/bankProducts.jsp">Банковские продукты</a>
    <a href="/about.jsp" class="right">О нас</a>
    </div>

    <div class="row">
        <div class="main">
        <h3>Создать менеджера</h3>
            <form method="post">
                <label>Firstname</label><br>
                <input name="firstname"/><br><br>
                <label>Lastname</label><br>
                <input name="lastname"/><br><br>
                <label>Age</label><br>
                <input name="age" type="number" min="18" /><br><br>
                <label>Password</label><br>
                <input name="password"/><br><br>
                <input type="submit" value="Save" />
            </form>
        </div>
    </div>

<div class="footer">
    <h3>Сегодня <%= new java.util.Date() %></h3>
</div>

</body>
</html>