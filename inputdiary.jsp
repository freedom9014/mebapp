<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>

<html>
<head><title>日記</title></head>
<body>
    <h1>日記を書く</h1>
    <form method='post' action='diaryservlet'>
    日付<input type='text' name='date'><br>
    入力<input type='text' name='content'><br>
    <input type='submit' value='完了'>
    </form>
</body>
</html>