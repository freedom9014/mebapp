<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html>
    <htad>
        <title>ログイン</title>
    </htad>
    <body>
        <h1>ログイン</h1>
        <form action="/mebapp${requestScope.target}" method="post">
            氏名：<input type="text" name="name"><br>
            パスワード：<input type="text" name="pass"><br><br>
            <input type="submit" value="ログイン">
        </form>
    </body>
</html>
