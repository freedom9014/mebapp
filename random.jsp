<%@ page pageEncoding="UTF-8"
contentType="text/html;charset=UTF-8" %>

<%! int number1 = 0; %>

<%--コメントの例です。--%>

<html>
    <head><title>JSPのテスト</title></head>
    <body>
        <h1>ランダムに取得される0から2までの数値</h1>
        <%
            java.util.Random r = new java.util.Random();
            number1 = r.nextInt(3);
            int number2 = r.nextInt(3);
            int number3 = r.nextInt(3);
            
            Integer intValue = new Integer(number3);
            pageContext.setAttribute("Value", intValue);
        %>
        number1:<p><font size="16"><%= number1 %></font></p>
        number1:<p><font size="16"><%= number2 %></font></p>
        number1:<p><font size="16">${value}</font></p>
    </body>
</html>