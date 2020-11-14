<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2020/10/14
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>详情</title>

    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

    <style>
        body {
            background: black;
        }

        .card {
            border-radius: 50px;
            box-shadow: #8CD4F5 15px 10px 10px;
        }

    </style>
</head>

<body>

<div class="card" style="width: 622px;left: 360px;">
    <img style=" border-radius: 50px;width: 600px;margin-left: 10px; " src="images/${images.image_address}"
         class="card-img-top " alt="...">
    <br>
    <div class="card-body">


        <form role="form" action="add_message">
            <c:if test="${sessionScope.user!=null}">
                <div class="form-group">
                    <textarea placeholder="请输入你的评论" name="message" class="form-control" rows="3"></textarea>
                    <input type="hidden" name="ImageId" value="${images.image_id}">
                    <a style="border-radius: 50px;width: 100px;margin-left: 380px;margin-top: 20px;"
                       href="images/${images.image_address}" download class="btn btn-outline-danger"
                       name="submit">下载</a>
                    <button style="border-radius: 50px;width: 100px;margin-left: 500px;margin-top: -38px;"
                            class="btn btn-outline-danger" name="submit">提交
                    </button>
                </div>
            </c:if>
            <c:if test="${sessionScope.user==null}">
                <div class="form-group">
                    <textarea placeholder="请登录后进行评论和下载" readonly="readonly" name="message" class="form-control"
                              rows="3"></textarea>
                </div>
            </c:if>
        </form>
        <c:forEach items="${requestScope.messages}" var="images" varStatus="status">
            ${images.user_name}：<br>
            <div style="text-indent: 2rem"> ${images.message}</div>
            <div style="right: 100px;width: 400px;margin-left: 380px;">${images.message_time}</div>
            <hr style="background: cyan ">
        </c:forEach>

    </div>
</div>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
<script src="js/popper.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>


</body>
</html>
