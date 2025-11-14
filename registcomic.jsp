<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<html>
    <head><title>登録されたマンガ</title></head>
    <body>
    <h1>登録されたマンガ</h1>
    <table border="1">
        <tr><th>出版社</th><th>タイトル</th><th>作者</th></tr>
        <tr><td>${cpro.comicPublisher}</td><td>${cpro.comicTitle}</td><td>${cpro.comicAuthor}</td></tr>
    </table>
    </body>
</html>