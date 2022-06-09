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
        <h4 style="text-align: center;"><em>Предлагаем Вам ознакомиться с нашими ведущими продуктами, ведь только от Вас зависит наш профит!</em></h4>
        <p><span style="text-decoration: underline;">1. Самые выгодные счета!</span></p>
        <table style="height: 72px; width: 85%; border-collapse: collapse; border-style: solid;" border="1">
            <tbody>
            <tr style="height: 18px;">
                <td style="width: 4.54545%; text-align: center; height: 18px;"><strong>№</strong></td>
                <td style="width: 26.4203%; text-align: center; height: 18px;"><strong>Название</strong></td>
                <td style="width: 48.8637%; text-align: center; height: 18px;"><strong>Условия</strong></td>
                <td style="width: 20.1705%; text-align: center; height: 18px;"><strong>Ссылочка</strong></td>
            </tr>
            <tr style="height: 18px;">
                <td style="width: 4.54545%; text-align: center; height: 18px;"><strong>1</strong></td>
                <td style="width: 26.4203%; height: 18px; text-align: center;">Ненакопительный</td>
                <td style="width: 48.8637%; height: 18px;">
                    <ul>
                        <li style="text-align: left;">на 33 года без возможности досрочного снятия;</li>
                        <li style="text-align: left;">0,0001% годовых.</li>
                    </ul>
                </td>
                <td style="width: 20.1705%; height: 18px; text-align: center;"><a href="https://yandex.ru/">Беру!</a></td>
            </tr>
            <tr style="height: 18px;">
                <td style="width: 4.54545%; height: 18px; text-align: center;"><strong>2</strong></td>
                <td style="width: 26.4203%; height: 18px; text-align: center;">Инфляционный</td>
                <td style="width: 48.8637%; height: 18px;">
                    <ul>
                        <li style="text-align: left;">без возможности пополнения;</li>
                        <li style="text-align: left;">ежемесячно уменьшается на процент годовой инфляции.</li>
                    </ul>
                </td>
                <td style="width: 20.1705%; height: 18px; text-align: center;"><a href="https://yandex.ru/">Хочу!</a></td>
            </tr>
            <tr style="height: 18px;">
                <td style="width: 4.54545%; height: 18px; text-align: center;"><strong>3</strong></td>
                <td style="width: 26.4203%; height: 18px; text-align: center;">До востребования</td>
                <td style="width: 48.8637%; height: 18px;">
                    <ul>
                        <li style="text-align: left;">доживи и будь богат! (нет)</li>
                    </ul>
                </td>
                <td style="width: 20.1705%; height: 18px; text-align: center;"><a href="https://yandex.ru/">Дайте два!</a></td>
            </tr>
            </tbody>
        </table>
        <p style="text-align: center;">&nbsp;</p>
        <p><span style="text-decoration: underline;">2. Умопомрачительные карты!</span></p>
        <table style="height: 136px; width: 85%; border-collapse: collapse;" border="1">
            <tbody>
            <tr style="height: 18px;">
                <td style="width: 4.7671%; text-align: center; height: 18px;"><strong>№</strong></td>
                <td style="width: 26.4556%; text-align: center; height: 18px;"><strong>Название</strong></td>
                <td style="width: 48.7264%; text-align: center; height: 18px;"><strong>Условия</strong></td>
                <td style="width: 20.0509%; text-align: center; height: 18px;"><strong>Ссылочка</strong></td>
            </tr>
            <tr style="height: 100px;">
                <td style="width: 4.7671%; text-align: center; height: 100px;"><strong>1</strong></td>
                <td style="width: 26.4556%; height: 100px; text-align: center;">Комиссионная</td>
                <td style="width: 48.7264%; height: 100px;">
                    <ul>
                        <li style="text-align: left;">не имеет ничего общего с комиссионными магазинами;</li>
                        <li style="text-align: left;">пополнение, снятие, перевод - все по фиксированной ставке 15%.</li>
                    </ul>
                </td>
                <td style="width: 20.0509%; height: 100px; text-align: center;"><a href="https://yandex.ru/">Несите!</a></td>
            </tr>
            <tr style="height: 18px;">
                <td style="width: 4.7671%; text-align: center; height: 18px;"><strong>2</strong></td>
                <td style="width: 26.4556%; height: 18px; text-align: center;">Золотая</td>
                <td style="width: 48.7264%; height: 18px;">
                    <ul>
                        <li style="text-align: left;">таки карта с кешбеком! Вернем 0,01%&nbsp; в конце месяца при сумме покупок по карте не менее 1 млн рублей. Остаток&nbsp; на карте - не менее 1 млн рублей.</li>
                    </ul>
                </td>
                <td style="width: 20.0509%; height: 18px; text-align: center;"><a href="https://yandex.ru/">Дорохо-бохато!</a></td>
            </tr>
            </tbody>
        </table>
        <p style="text-align: left;">&nbsp;</p>
        <p><span style="text-decoration: underline;">3. Не имеющие аналогов кредиты!</span></p>
        <table style="width: 85%; border-collapse: collapse;" border="1">
            <tbody>
            <tr>
                <td style="width: 4.97159%; text-align: center;"><strong>№</strong></td>
                <td style="width: 26.5625%; text-align: center;"><strong>Название</strong></td>
                <td style="width: 48.5795%; text-align: center;"><strong>Условия</strong></td>
                <td style="width: 19.8864%; text-align: center;"><strong>Ссылочка</strong></td>
            </tr>
            <tr>
                <td style="width: 4.97159%; text-align: center;"><strong>1</strong></td>
                <td style="width: 26.5625%; text-align: center;">Цезарь (не салат!)</td>
                <td style="width: 48.5795%; text-align: left;">
                    <ul>
                        <li style="text-align: left;">Гай Юлий мог заниматься несколькими делами одновременно, а Вы сможете найти дополнительную работу!</li>
                        <li style="text-align: left;">срок кредита 33 года;</li>
                        <li style="text-align: left;">сумма ежемесячного платежа = сумме вашего дохода за месяц на основной работе.</li>
                    </ul>
                </td>
                <td style="width: 19.8864%; text-align: center;"><a href="https://yandex.ru/">Что ж...</a></td>
            </tr>
            <tr>
                <td style="width: 4.97159%; text-align: center;"><strong>2</strong></td>
                <td style="width: 26.5625%; text-align: center;">Наполеон (не торт!)</td>
                <td style="width: 48.5795%; text-align: left;">
                    <ul>
                        <li style="text-align: left;">поистине императорские условия!</li>
                        <li style="text-align: left;">срок кредита - 51 год;</li>
                        <li style="text-align: left;">процентная ставка - 14% ежемесячно*</li>
                    </ul>
                    <p>&nbsp;</p>
                    <p>* все правильно, 14*12 = 168% годовых, как рост знаменитого императора!</p>
                </td>
                <td style="width: 19.8864%; text-align: center;"><a href="https://yandex.ru/">Je suis d'accord</a></td>
            </tr>
            </tbody>
        </table>
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
    <p style="text-align: center;"><strong>И запомните: не пытайтесь нас обмануть!</strong></p>
    <p style="text-align: center;"><strong>Мы все равно Вас засудим.</strong></p>
    <h3>Сегодня <%= new java.util.Date() %></h3>
</div>

</body>
</html>