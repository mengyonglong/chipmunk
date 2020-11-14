<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2020/10/13
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>收藏夹</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<a href="query"
   style="margin-left: 650px;margin-top: 50px;width: 86px;margin-bottom: 20px;border-bottom-width: 1px;"
   class="btn btn-danger">返回主页
</a>
<c:forEach items="${requestScope.collectViewList}" var="collectView" varStatus="status">
    <c:choose>
        <c:when test="${status.count%2==1}">
            <div class="card mb-3" style="max-width: 1200px;">
                <div class="row no-gutters">
                    <div class="col-md-4">
                        <img src="images/${collectView.image_address}" class="card-img" alt="..."
                             style="margin-left: 80px;">
                    </div>
                    <div class="col-md-8" style="padding-left: 40px;">
                        <div class="card-body">
                            <h1 style="font-weight: bold;margin-left: 100px;" class="card-title">Card title</h1>
                            <p class="card-text" style="margin-left: 100px;">This is a wider card with supporting text
                                below as a natural lead-in to additional content. This content is a little bit
                                longer.</p>
                            <p class="card-text" style=" margin-left: 100px;"><small class="text-muted">Last updated 3
                                mins ago</small></p>
                        </div>
                        <button onclick="delCollect(${collectView.image_id})"
                                style="margin-left: 600px;margin-top: 100px;width: 76px;"
                                class="btn btn-danger">删除
                        </button>
                    </div>
                </div>
            </div>
            <br>
            <br>
            <br>
        </c:when>
        <c:otherwise>
            <div class="card mb-3" style="max-width: 1200px;">
                <div class="row no-gutters">
                    <div class="col-md-8" style="padding-left: 40px;">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.</p>
                            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                            <button onclick="delCollect(${collectView.image_id})"
                                    style="margin-left: 600px;margin-top: 100px;width: 76px;"
                                    class="btn btn-danger">删除
                            </button>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <img src="images/${collectView.image_address}" class="card-img" alt="..."
                             style="margin-left: 30px;">
                    </div>
                </div>
            </div>
            <br>
            <br>
            <br>
        </c:otherwise>
    </c:choose>
</c:forEach>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/popper.min.js"></script>
<script>
    function delCollect(id) {
        if (confirm("确认删除吗?")) {
            location.href = "delete?image_id=" + id;
        }
    }

</script>

</body>
</html>
