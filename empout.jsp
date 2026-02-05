<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<html>
    <title>emp表</title>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <h1>内容表示</h1>
        <table border="1">
            <c:forEach var="record" items="${empList}">
                <tr>
                    <c:forEach var="data" items="${record}">
                        <td>${data}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>