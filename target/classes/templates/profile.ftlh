<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Your Notes</title>
</head>
<body>
<h1 style="text-align: center">Your notes</h1>
<hr>
<br>
<#if user.name??>
    <div style="text-align: center">
        <br>
        <br>
        <h2>${user.name}</h2>
        <br>
        Номер телефона: <b>${user.number}</b>
        <br>
        <a style="text-align: center; width: 100%" href="/my/notes">
            Мои заметки
        </a>
    </div>
</#if>
</body>
</html>