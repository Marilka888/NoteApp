<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Your Notes</title>
</head>
<body>
<h1 style="text-align: center">Мои заметки</h1>
<hr>
<h2><a style="text-align: center; width: 100%">
        Добавить новую заметку
    </a></h2>
<hr>
<form action="/notes/create" method="post">
    <label for="title">Заголовок</label>
    <input type="text" id="title" name="title">
    <br><br>
    <label for="description">Описание</label>
    <textarea id="description" name="description"></textarea>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <br><br>
    <button type="submit">Добавить</button>
</form>
<hr>
<a href="/profile">
    <button type="submit" style="width: 100%; text-align: center">Профиль</button>
</a>
<#if notes??>
    <#list notes as note>
        <a href="/note/${note.id}">
            <h5>${note.title}</h5>
            <form action="/note/delete/${note.id}" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit">Удалить</button>
            </form>
        </a>
    <#else >
        <h1 style="text-align: center">Не найдено</h1>
    </#list>
</#if>
</body>
</html>