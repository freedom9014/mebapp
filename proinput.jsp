<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>

<html>
<head><title>連絡先登録</title></head>
<body>
    <h1>連絡先</h1>
    <form method='post' action='proregistservlet'>
    氏名<input type='text' name='name'><br>
    住所<input type='text' name='address'><br>
    電話番号<input type='text' name='tel'><br>
    <input type='submit' value='登録'>
    </form>
</body>
</html>