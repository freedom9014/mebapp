<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head><title>登録データ</title></head>
    <body>
    <h1>登録データ</h1>
    <table border="1">
        <tr><th>名前</th><th>ID</th><th>身長</th><th>体重</th></tr>
        <c:forEach var="st" items="${studentlist}">
            <tr><td>${st.name}</td><td>${st.studentID}</td><td>${st.height}</td><td>${st.weight}</td></tr>
        </c:forEach>
    </table>
    </body>
</html>