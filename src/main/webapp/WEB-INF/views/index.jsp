
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
    <style>
        a:link, a:visited {text-decoration:none; color:azure; }
    </style>
    <!--모달-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>

<body>
<div class="container">
    <div class="jumbotron">
        <h1>게시판 만들기</h1>
        <p>2019.01.07~2019.01.11</p>
        <p>박재희</p>
    </div>

    <!-- 모달1 -->
    <div class="container">
        <!-- Button to Open the Modal -->
        <button type="button" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#myModal">
            JOIN
        </button>

        <!-- The Modal -->
        <div class="modal" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Modal Heading</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <h3>JOIN</h3>
                        <form method="post" action="/join">
                            name : <input type="text" name="name" size="20"><br>
                            nickname : <input type="text" name="nickname" size="20"><br>
                            email : <input type="text" name="email" size="20"><br>
                            password : <input type="password" name="passwd1" size="20"><br>
                            password 확인 : <input type="password" name="passwd2" size="20"><br>
                            <input type="submit">
                        </form>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                    </div>

                </div>
            </div>
        </div>

        <!--모달2-->
        <!-- Button to Open the Modal -->
        <button type="button" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#loginModal">
            LOGIN
        </button>

        <!-- The Modal -->
        <div class="modal" id="loginModal">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Modal Heading</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <h3>JOIN</h3>
                        <form method="post" action="/login">
                            email : <input type="text" name="email" size="20"><br>
                            password : <input type="password" name="passwd" size="20"><br>
                            <input type="submit">
                        </form>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                    </div>

                </div>
            </div>
        </div>

    </div>
    <button type="button" class="btn btn-warning btn-lg pull-right"><a href="/board/list"> WELCOME </a></button>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.nin.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>

</html>