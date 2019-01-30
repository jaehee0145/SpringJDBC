<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <meta charset="UTF-8">
    <title>modify</title>
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
<form action="/board/modify" method="post">
    <div class="container">
        <h2>글쓰기</h2>

        <div class="form-group">
              <input type="hidden" name="id" id="id" value="${board.id}"/>
              <%--<input type="text" name="id" id="id" value="${id}"/>--%>

              <label for="writer">Name:</label>
              <input type="text" class="form-control" id="writer" value="${board.nickname}" readonly>
          </div>

          <div class="form-group">
              <label for="title">title:</label>
              <input type="text" class="form-control" name="title" id="title" value="${board.title}">
          </div>

          <div class="form-group">
              <label for="content">Comment:</label>
              <textarea class="form-control" rows="5" name="content" id="content">${board.content}</textarea>
          </div>

          <div class="btn-group">
              <input type="submit" class="btn btn-default" value="등록"/>
              <%--<button type="button" class="btn btn-warning"><a href="/board/list">확인</a></button>--%>
            <button type="button" class="btn btn-warning"><a href="/board/list">취소</a></button>
        </div>
    </div>
    <br>
    <br>
    <br>
</form>
</div>
</body>

</html>