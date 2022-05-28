<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authorization Page</title>
    </head>
    <body>
        <div>
            <h1>Вход в личный кабинет</h1>
        </div>
        <img src = "Фон.jpg" align="right" width="700" height="700"/>
            <div>
                <form method="post">
                    <label>Имя пользователя:
                        <input type="text" name="userFirstName"><br />
                    </label>
                    <br />
                    <label>Фамилия пользователя:
                        <input type="text" name="userLastName"><br />
                    </label>
                    <br />
                    <label>Пароль:
                        <input type="password" name="userPassword"><br />
                    </label>
                    <br />
                    <label>Вход для персонала:
                        <input type="checkbox" checked name="isManager"/><br />
                    </label>
                    <br />
                    <button type="submit">Войти</button>
                    <br />
                </form>
            </div>
    </body>
</html>