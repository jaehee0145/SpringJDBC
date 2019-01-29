<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <meta charset="UTF-8">
    <title>view</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
    <style>
        a:link, a:visited {
            text-decoration: none;
            color: azure;
        }
    </style>
</head>

<body>
<div class="container">
    <div class="jumbotron">
        <h1>게시판 만들기</h1>
        <p>2019.01.07~2019.01.11</p>
        <p>박재희</p>
    </div>
</div>

<div class="container">
    <div class="panel panel-default">
        <%--<c:forEach items="${requestScope.list}" var="board">--%>
        <input type="hidden" name="id" id = "id" value="${board.id}" />
        <div class="panel-heading">제목     ${board.title} </div>
        <div class="panel-heading">작성자     ${board.nickname} </div>
        <div class="panel-heading"> ${board.regdate} </div>
        <div class="panel-body"> ${board.content} </div>
        <%--</c:forEach>--%>
    </div>


    <button type="button" class="btn btn-success"><a href="/board/list">목록</a></button>
    <div class="btn-group pull-right">
        <button type="button" class="btn btn-warning"><a href="/board/modify?id=${board.id}">수정</a></button>
        <button type="button" class="btn btn-danger"><a href="/delete?id=${board.id}">삭제</a></button>
    </div>

</div>
<br>
<br>
<br>

</body>

</html>