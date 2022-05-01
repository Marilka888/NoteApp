<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Your Notes</title>
</head>
<body>
<h1 style="text-align: center">Авторизация</h1>
<hr>
<form action="/login" method="post">
    Телефон: <input type="number" name="username"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход"/>
</form>
<a style="color: #c2b4e7" href="/registration">Зарегистрироваться</a>
<hr>
</body>
</html>