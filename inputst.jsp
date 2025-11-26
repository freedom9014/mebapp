<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>

<html>
<head><title>身体測定</title></head>
<body>
    <h1>身体測定データ登録</h1>
    <form method='get' action='studentservlet'>
    名前<input type='text' name='name'><br>
    ID<input type='text' name='studentid'><br>
    身長<input type='text' name='height'><br>
    体重<input type='text' name='weight'><br>
    <input type='submit' value='登録'>
    </form>
</body>
</html>