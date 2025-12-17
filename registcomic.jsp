<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head><title>登録されたマンガ</title></head>
    <body>
    <h1>登録されたマンガ</h1>
    <table border="1">
        <tr><th>出版社</th><th>タイトル</th><th>作者</th></tr>
        <c:forEach var="comic" items="${comiclist}">
            <tr><td>${comic.comicPublisher}</td><td>${comic.comicTitle}</td><td>${comic.comicAuthor}</td></tr>
        </c:forEach>
    </table>
    </body>
</html>