<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2020/10/10
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">

    <meta name="author" content="">
    <meta name="keyword" content=" template, html5, css3, bootstrap4">
    <meta name="description" content="HTML5 and CSS3 Template Based on Bootstrap 4">
    <title>chipmunk</title>
    <link rel="stylesheet" href="ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="sweetalert/dist/sweetalert.css">
    <link rel="stylesheet" href="css/stisla.css">
    <link rel="icon" href="favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/default.css">

    <style type="text/css">
        /*瀑布流 CSS样式*/
        #gallery-wrapper {
            position: relative;
            width: 100%;
            margin: 50px auto;
        }

        img.thumb {
            width: 100%;
            max-width: 100%;
            height: auto;
        }

        .white-panel {
            position: absolute;
            background: black;
            border-radius: 5px;
            box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.3);
            padding: 10px;
            margin-top: -20px;
            border-radius: 50px;
        }

        .white-panel h1 {
            font-size: 1em;
        }

        .white-panel h1 a {
            color: #A92733;
        }

        .white-panel:hover {
            box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.5);
            margin-top: -5px;
            -webkit-transition: all 0.3s ease-in-out;
            -moz-transition: all 0.3s ease-in-out;
            -o-transition: all 0.3s ease-in-out;
            transition: all 0.3s ease-in-out;
        }
    </style>
    <!--[if IE]>
    <script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
    <![endif]-->
</head>

<body>

<nav class="navbar navbar-expand-lg main-navbar">

    <div class="container-fluid">
        <a class="navbar-brand" href="query">
            <h4 style="color:white;">Hello Chipmunk!</h4>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon">
			<i class="ion-navicon"></i>
		</span>
        </button>
        <div class="collapse navbar-collapse " id="navbarNav">
            <div class="mr-auto"></div>
            <ul class="navbar-nav ">
                <form action="" method="get">
                    <select name="lang" onchange="document.forms[0].submit()">
                        <option value="">语言</option>
                        <option value="zh_CN">汉语</option>
                        <option value="en_US">英语</option>
                    </select>
                </form>
                <fmt:setLocale value="${param.lang}"/>
                <fmt:bundle basename="res">
                <li class="nav-item ">
                    <a class="nav-link smooth-link" href="#hero"><fmt:message key="home"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link smooth-link" href="#features"><fmt:message key="classify"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link smooth-link" href="#blog"><fmt:message key="label"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link smooth-link" href="#project"><fmt:message key="about"/></a>
                </li>
            </ul>
            <c:if test="${sessionScope.user!=null}">
                <form class="form-inline">
                    <a href="logout" class="btn smooth-link align-middle btn-primary"><fmt:message key="logout"/></a>
                    <a href="querycollect" class="btn smooth-link align-middle btn-primary"><i
                            class="icon ion-star"></i><fmt:message key="favorite"/><span
                            class="badge badge-light">${requestScope.collectViewListCount}</span></a>
                </form>
            </c:if>
            <c:if test="${sessionScope.user==null}">
                <form class="form-inline">
                    <a href="login.jsp"  class="btn smooth-link align-middle btn-primary"><fmt:message key="login"/></a>
                    <a href="querycollect" class="btn smooth-link align-middle btn-primary"><i
                            class="icon ion-star"></i><fmt:message key="favorite"/><span
                            class="badge badge-light">${requestScope.collectViewListCount}</span></a>
                </form>
            </c:if>

        </div>
    </div>
</nav>

<section class="hero bg-overlay" id="hero" data-bg="https://picsum.photos/1920/1281?">
    <div class="text">
        <p class="lead">No one and you.</p>

        <h1 class="animate__animated animate__bounce" style="font-size: 100px"><fmt:message key="chipmunk"/></h1>
        <div class="col-12 col-md-6">
            <form class="subscribe" action="searchs?searches=${searches}">

                <input type="text" style="margin-top: 40px;padding-right: 130px;margin-left: 60px;width: 609px;"
                       name="searches" class="form-control" placeholder="<fmt:message key="inputs"/>">
                <button type="submit"
                        style="left: 520px;margin-top: 38px;margin-left: 36px;padding-right: 38px;height: 48px;padding-left: 20px;width: 105px;border-left-width: 9px;"
                        class="btn btn-primary">Search
                </button>
            </form>
        </div>
        <div style="margin-top: 30px">
            <p class="lead"><fmt:message key="echo"/></p>
        </div>
    </div>
</section>

<section class="padding" id="features" style="padding-top: 20px;background: black; padding-bottom: 15px;">
    <div class="container ">

        <ul class="nav nav-pills nav-fill ">
            <li class="nav-item">
                <a class="nav-link " href="query_tag?tag=二次元 "><fmt:message key="cartoon"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="query_tag?tag=人物 "><fmt:message key="man"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="query_tag?tag=风景 "><fmt:message key="seeing"/></a>
            </li>
            <li class="nav-item" style="color: black">
                <a class="nav-link" href="query_tag?tag=艺术 "><fmt:message key="art"/></a>
            </li>
        </ul>
    </div>
</section>
    <%--瀑布流的HTML结构--%>
<section id="gallery-wrapper">
    <c:forEach items="${requestScope.imagesList}" var="images" varStatus="status">
        <article class="white-panel">
            <a href="addCollect?ImageId=${images.image_id}" style="border-radius: 50px" class="btn btn-outline-dark">
                <i class="icon ion-star"></i>收藏</a>
            <a href="details?ImageId=${images.image_id}" class="btn btn-outline-dark">
                <img src="images/${images.image_address}" class="thumb"></a>
        </article>
    </c:forEach>

    <c:forEach items="${requestScope.imagesLists}" var="images" varStatus="status">
        <article class="white-panel">
            <a href="addCollect?ImageId=${images.image_id}" style="border-radius: 50px"
               class="btn btn-outline-secondary">
                <i class="icon ion-star"></i>收藏</a>
            <a href="details?ImageId=${images.image_id}" class="btn btn-outline-secondary">
                <img src="images/${images.image_address}" class="thumb"></a>
        </article>
    </c:forEach>


</section>


<section class="padding bg-grey" id="blog">
    <div class="container">
        <h2 class="section-title" style="color: black"><fmt:message key="picture"/></h2>
        <p class="section-lead text-muted">Most popular with the masses Pictures of welcome.</p>
        <div class="section-body">
            <div class="row col-spacing">
                <div class="col-12 col-md-6 col-lg-4">
                    <article class="card">
                        <img class="card-img-top" src="https://picsum.photos/672/491" alt="Article Image">
                        <div class="card-body">
                            <div class="card-subtitle mb-2 text-muted">by Workin on August 10, 2020
                            </div>
                            <h4 class="card-title"><a href="#" data-toggle="read" data-id="1">美文摘抄</a></h4>
                            <p class="card-text">我们不肯探索自己本身的价值，我们过分看重他人在自己生命里的参与。于是，
                                孤独不再美好，失去了他人，我们惶惑不安 —— 三毛.</p>
                        </div>
                    </article>
                </div>
                <div class="col-12 col-md-6 col-lg-4">
                    <article class="card">
                        <img class="card-img-top" src="https://picsum.photos/671/490?" alt="Article Image">
                        <div class="card-body">
                            <div class="card-subtitle mb-2 text-muted">by meyolo on October 17, 2020
                            </div>
                            <h4 class="card-title"><a href="#" data-toggle="read" data-id="1">美文摘抄</a></h4>
                            <p class="card-text">不论是多情的诗顺，漂亮的文章，还是闲暇的欢乐，什么都不能代替无比亲密的友情。
                                ——普希金</p>
                            <br>
                        </div>

                    </article>
                </div>
                <div class="col-12 col-md-6 col-lg-4">
                    <article class="card">
                        <img class="card-img-top" src="https://picsum.photos/671/491?" alt="Article Image">
                        <div class="card-body">
                            <div class="card-subtitle mb-2 text-muted">by dkx on October 16, 2020
                            </div>
                            <h4 class="card-title"><a href="#" data-toggle="read" data-id="1">美文摘抄</a></h4>
                            <p class="card-text">竭力为善，爱自由甚于一切，即使为了王座，也永勿欺妄真理 —— 贝多芬</p>
                            <br>
                            <br>
                        </div>

                    </article>
                </div>
                <div class="col-12 col-md-6 col-lg-4">
                    <article class="card">
                        <img class="card-img-top" src="https://picsum.photos/671/492?" alt="Article Image">
                        <div class="card-body">
                            <div class="card-subtitle mb-2 text-muted">by fq on October 15, 2020
                            </div>
                            <h4 class="card-title"><a href="#" data-toggle="read" data-id="1">Extract</a></h4>
                            <p class="card-text">Accept what was and what is, and you’ll have more positive energy to
                                pursue what will be.</p>
                        </div>
                    </article>
                </div>
                <div class="col-12 col-md-6 col-lg-4">
                    <article class="card">
                        <img class="card-img-top" src="https://picsum.photos/669/491?" alt="Article Image">
                        <div class="card-body">
                            <div class="card-subtitle mb-2 text-muted">by fr on October 14, 2020
                            </div>
                            <h4 class="card-title"><a href="#" data-toggle="read" data-id="1">Extract</a></h4>
                            <p class="card-text">There's only one corner of the universe you can be sure of improving,
                                and that's your own self.</p>
                        </div>
                    </article>
                </div>
                <div class="col-12 col-md-6 col-lg-4">
                    <article class="card">
                        <img class="card-img-top" src="https://picsum.photos/672/489?" alt="Article Image">
                        <div class="card-body">
                            <div class="card-subtitle mb-2 text-muted">by fq on October 14, 2020
                            </div>
                            <h4 class="card-title"><a href="#" data-toggle="read" data-id="1">Extract</a></h4>
                            <p class="card-text">The greatest test of courage on earth is to bear defeat without losing
                                heart.</p>
                        </div>
                    </article>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="bg-overlay padding" id="project" data-bg="images/2.jpg">

    <div class="container">
        <div class="row align-items-center">
            <div class="col-12 col-md-6">
                <figure class="projects-picture">
                    <img style="margin-left: -140px;width: 500px;" src="images/chip.jpg" alt="chipmunk">
                </figure>
            </div>
            <div class="col-12 col-md-6">
                <div class="projects-details">
                        <h3>Chipmunk</h3>
                    <h2 class="projects-title">花栗鼠需要你们的爱心</h2>
                    <p class="projects-description">
                        我们提供高清的图片素材，并可以免费使用，但是昂贵的服务器成本使我们力不从心，如果你喜欢花栗鼠，请献出你们的爱心支持我们，你们的爱心将会是我们成长的动力。
                    </p>
                    <div class="projects-cta">
                        <div class="image">
                            <img src="images/weixin.png"
                                 style="width: 150px;margin-left: 280px;margin-top: -40px;">
                        </div>
                        <a href="#hero" class="btn btn-primary" style="margin-left: 450px;">
                            转到顶部
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </fmt:bundle>
</section>


<footer>
    <div class="container">
        <figure>
            <h3 style="margin-left: -15px;">Chipmunk!</h3>
        </figure>
        <p>版权所有：唔西迪西小分队. </p>
    </div>
</footer>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="sweetalert/dist/sweetalert.min.js"></script>
<script src="js/jquery.easeScroll.js"></script>
<script src="js/stisla.js"></script>
<script src="js/popper.min.js"></script>
<%--瀑布流--%>
<script src="js/pinterest_grid.js"></script>

<script type="text/javascript">
    // pinterest_grid()方法来初始化该瀑布流布局jQuery插件。
    $(function () {
        $("#gallery-wrapper").pinterest_grid({
             no_columns: 4,   //网格布局一行的列数。默认值为一行3个网格。
            padding_x: 10,    //网格在X轴方向的padding值。默认值为10像素。
            padding_y: 10,    //网格在Y轴方向的padding值。默认值为10像素。
            margin_bottom: 50,  //网格底部的margin值。默认值为50像素。
            single_column_breakpoint: 700  //指定在视口多大时一行只显示一个网格。
        });

    });



    function Search() {
        alert("触发点击事件");
        let c = $("#searches").value();
        location.href = "searchs?search=" + searches;
    }

</script>


</body>
</html>