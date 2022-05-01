<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Your Notes</title>
</head>
<body>
<h1 style="text-align: center">Регистрация</h1>
<hr>
<form action="/registration" method="post">
    <label for="name">Имя пользователя</label>
    <input type="text" required id="name" name="name">
    <br>
    <label for="phoneNumber">Номер телефона</label>
    <input type="text" id="number" required name="number">
    <br>
    <label for="password">Пароль</label>
    <input type="password" id="password" required name="password">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <button type="submit" style="width: 100%">Зарегистрироваться</button>
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>