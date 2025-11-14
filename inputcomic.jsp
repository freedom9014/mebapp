<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>

<html>
<head><title>マンガ登録</title></head>
<body>
    <h1>マンガ登録</h1>
    <form method='post' action='registcomicservlet'>
    出版社<input type='text' name='publisher'><br>
    タイトル<input type='text' name='title'><br>
    作者<input type='text' name='author'><br>
    <input type='submit' value='登録'>
    </form>
</body>
</html>
