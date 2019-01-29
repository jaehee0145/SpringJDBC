<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>joinform</title>
</head>
<body>
<h1>joinform</h1>

<br><br>

<form method="post" action="/join">
    이름: <input type="text" name = "name"><br>
    닉네임: <input type="text" name = "nickname"><br>
    이메일: <input type="text" name = "email"><br>
    암호: <input type="text" name = "passwd"><br>
<input type="submit">
</form>

</body>
</html>