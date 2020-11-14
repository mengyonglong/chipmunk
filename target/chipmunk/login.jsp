<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2020/10/12
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Chipmunk</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style.css">

    <style>
        .box {
            position: relative;
        }

    </style>


</head>
<body>

<form class="box" action="" method="get">
    <select name="lang" onchange="document.forms[0].submit()">
        <option value="">语言</option>
        <option value="zh_CN">汉语</option>
        <option value="en_US">英语</option>
    </select>
</form>
<fmt:setLocale value="${param.lang}"/>
<div class="gtco-loader"></div>

<div id="page">
    <fmt:bundle basename="res">
    <div class="page-inner">
        <nav class="gtco-nav" role="navigation">
            <div class="gtco-container">
                <div class="row">
                    <div class="col-sm-4 col-xs-12">
                        <div id="gtco-logo"><a href="index.html">Chipmunk <em>.</em></a></div>
                    </div>
                </div>

            </div>
        </nav>

        <header id="gtco-header" class="gtco-cover" role="banner" style="background-image: url(images/background.png)">
            <div class="overlay"></div>
            <div class="gtco-container">
                <div class="row">
                    <div class="col-md-12 col-md-offset-0 text-left">
                        <div class="row row-mt-15em" style="  margin-top: 100px;">
                            <div class="col-md-7 mt-text animate-box" data-animate-effect="fadeInUp">

                                <h1><fmt:message key="title"/></h1>


                            </div>
                            <div class="col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
                                <div class="form-wrap">
                                    <div class="tab">
                                        <ul class="tab-menu">
                                            <li class="active gtco-first"><a href="#" data-tab="signup"><fmt:message
                                                    key="register"/></a></li>
                                            <li class="gtco-second"><a href="#" data-tab="login"><fmt:message
                                                    key="login"/></a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div class="tab-content-inner active" data-content="signup">
                                                <form action="/Chipmunk/register" >
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label><fmt:message key="user_name"/> </label>

                                                            <input type="text" class="form-control" name="user_name">
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label><fmt:message key="user_password"/> </label>
                                                            <input type="password" class="form-control"
                                                                   name="user_password">
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label><fmt:message key="user_sex"/> </label>
                                                                <%--                                                            <label>性别</label>--%>
                                                            <input type="text" class="form-control" name="user_sex">
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label><fmt:message key="user_phone"/> </label>
                                                                <%--                                                            <label>手机号</label>--%>
                                                            <input type="text" class="form-control" name="user_phone">
                                                        </div>
                                                    </div>
                                                    <div class="row form-group ">
                                                        <div class="col-md-12  ">
                                                            <label><fmt:message key="user_hobby"/> </label>
                                                                <%--                                                            <label>爱好</label>--%>

                                                            <div class="form-check form-check-inline  ">
                                                                <input class="form-check-input" type="checkbox"
                                                                       id="inlineCheckbox1" value="风景"
                                                                       name="user_hobby">
                                                                <label class="form-check-label"
                                                                       for="inlineCheckbox1"><fmt:message
                                                                        key="seeing"/></label>
                                                            </div>
                                                            <div class="form-check form-check-inline ">
                                                                <input class="form-check-input" value="动漫"
                                                                       type="checkbox" name="user_hobby"
                                                                       id="inlineCheckbox2">
                                                                <label class="form-check-label"
                                                                       for="inlineCheckbox2"><fmt:message
                                                                        key="animal"/></label>
                                                            </div>
                                                            <div class="form-check ">
                                                                <input class="form-check-input" type="checkbox"
                                                                       name="user_hobby"
                                                                       id="inlineCheckbox3" value="二次元">
                                                                <label class="form-check-label"
                                                                       for="inlineCheckbox3"><fmt:message
                                                                        key="cartoon"/></label>
                                                            </div>
                                                            <div class="form-check ">
                                                                <input class="form-check-input" type="checkbox"
                                                                       name="user_hobby"
                                                                       id="inlineCheckbox4" value="艺术">
                                                                <label class="form-check-label"
                                                                       for="inlineCheckbox4"><fmt:message
                                                                        key="art"/></label>
                                                            </div>

                                                        </div>
                                                    </div>


                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <input onclick="regis()"  type="submit" class="btn btn-primary"
                                                                   value="<fmt:message key="register"/>">
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>

                                            <div class="tab-content-inner" data-content="login">
                                                <form action="/Chipmunk/login ">
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label><fmt:message key="user_name"/></label>
                                                            <input type="text" class="form-control" name="user_name">
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label><fmt:message key="user_password"/></label>
                                                            <input type="password" class="form-control"
                                                                   name="user_password"
                                                                   value="<fmt:message key="register"/>">
                                                        </div>
                                                    </div>

                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <a href="login"><input type="submit" class="btn btn-primary"
                                                                                   value="<fmt:message key="login"/>"></a>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
            </fmt:bundle>
        </header>


        <script src="js/jquery.min.js"></script>

        <script src="js/jquery.easing.1.3.js"></script>

        <script src="js/bootstrap.min.js"></script>

        <script src="js/jquery.waypoints.min.js"></script>

        <script src="js/owl.carousel.min.js"></script>

        <script src="js/main.js"></script>
        <script src="js/popper.min.js"></script>
<script>
    function regis() {
        alert("注册成功，请您登录");
        location.href = "searchs?search=" + searches;
    }
</script>

    </div>
</body>
</html>
