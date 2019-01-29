<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>list</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
    <style>
        button {
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
    <button type="button" class="btn btn-warning pull-right"><a href="/write"> 글쓰기 </a></button>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>날짜</th>
            <th>조회수</th>
        </tr>
        </thead>
        <tbody>
        Welcome!
        <c:if test="${sessionScope.logininfo != null}">
            ${sessionScope.logininfo.nickname}&nbsp;
        </c:if>
        <br>
        <c:forEach items="${boards}" var="board">
            <tr>
                <td>${board.id}</td>
                <td><a href="/view?id=${board.id}">${board.title}</a></td>
                <td>${board.nickname}</td>
                <td>${board.regdate}</td>
                <td>${board.readCount}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <hr/>

    <div class="text-center">
        <ul class="pagination">
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
        </ul>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.nin.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>