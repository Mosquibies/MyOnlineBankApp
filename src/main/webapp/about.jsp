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
    <link rel="stylesheet" type="text/css" href="css/common.css" />
</head>
<body>

<div class="header">
    <h1>Онлайн-банк "Деньги из воздуха"</h1>
    <h3>Если Вам кажется, что Вас обманули - Вы чертовски правы!</h3>
</div>

<div class="navbar">
    <a href="/index.jsp">На главную</a>
    <a href="/bankProducts.jsp">Банковские продукты</a>
    <a href="/about.html" class="right">О нас</a>
</div>

<div class="row">

    <div class="main">
        <h4 style="text-align: center;"><em>Наша стратегия максимально проста и понятна:</em></h4>
        <h4 style="text-align: center;"><em>Шаг 1: берем деньги под низкий процент.</em></h4>
        <h4 style="text-align: center;"><em>Шаг 2: отдаем деньги под высокий процент.</em></h4>
        <h4 style="text-align: center;"><em>Шаг 3: ???</em></h4>
        <h4 style="text-align: center;"><em>Шаг 4: таки профит!</em></h4>
    </div>
</div>


<script>
        // Get the modal
        var modal = document.getElementById('id01');

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
        if (event.target == modal) {
        modal.style.display = "none";
            }
        }
        </script>

<div class="footer">
    <h3>Сегодня <%= new java.util.Date() %></h3>
</div>

</body>
</html>