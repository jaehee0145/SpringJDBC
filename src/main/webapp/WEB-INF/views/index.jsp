<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>test</title>
</head>
<body>
<h1>test</h1>

<br><br>s

<c:forEach items="${users}" var="user">
    name : ${user.name}, email : ${user.email}<br>
</c:forEach>
</body>
</html>