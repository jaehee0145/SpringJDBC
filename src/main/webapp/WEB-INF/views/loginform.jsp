<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>loginform</title>
</head>
<body>
<h1>loginform</h1>

<br><br>

<form method="post" action="/login">
    이메일: <input type="text" name = "email"><br>
    암호: <input type="text" name = "passwd"><br>
<input type="submit">
</form>

</body>
</html>