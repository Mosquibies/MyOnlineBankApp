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
    <a href="/bankProducts.jsp">Банковские продукты</a>
    <a href="/about.jsp" class="right">О нас</a>
</div>

<div class="row">
    <div class="side">
        <button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Войти в личный кабинет</button>

        <div id="id01" class="modal">

            <form class="modal-content animate" method="post" action="/private/authorization">

                <div class="container">
                    <label for="userFirstName"><b>Имя</b></label>
                    <input type="text" placeholder="Введите имя" name="userFirstName" required>

                    <label for="userLastName"><b>Фамилия</b></label>
                    <input type="text" placeholder="Введите фамилию" name="userLastName" required>

                    <label for="userPassword"><b>Пароль</b></label>
                    <input type="password" placeholder="Введите пароль" name="userPassword" required>

                    <label>Вход для персонала:
                        <input type="checkbox" checked name="isManager"/><br />
                    </label>

                    <button type="submit">Войти</button>
                </div>

                <div class="container" style="background-color:#f1f1f1">
                    <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Отмена</button>
                </div>
            </form>
        </div>
    </div>

    <div class="main">
        <div>
            <br /> Только у нас Вы сможете:
        </div>
        <div>
            <br /> 1. Открыть счет, баланс которого может меняться независимо от Вас.
        </div>
        <div>
            <br /> 2. Взять кредит на максимально некомфортных условиях.
        </div>
        <div>
            <br /> 3. Открыть карту, данные которой обязательно попадут третьим лицам.
        </div>
        <div>
            <br /> 4. Осуществлять переводы и платежи с комиссиями, которые Вам даже не снились.
        </div>
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