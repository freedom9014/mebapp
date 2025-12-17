<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head><title>登録されたユーザー</title></head>

    <body>
    <h1>登録されたユーザー</h1>
    ここはforeachのループに書き換えて、ArrayListの中身を出力
    <table border="1">
        <tr><th>ユーザー名</th><th>パスワード</th></tr>
        <tr><td>${prof.userName}</td><td>${prof.passWord}</td></tr>
    </table>

    <table border="1">
        <tr><th>ユーザー名</th><th>パスワード</th></tr>
        <c:forEach var="prof" items="${userlist}">
            <tr><td>${prof.userName}</td><td>${prof.passWord}</td></tr>
    </c:forEach>
    </table>

    </body>
</html>