<%--
  Created by IntelliJ IDEA.
  User: yanglin
  Date: 2017/3/6
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link href="${pageContext.request.contextPath}/common/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/common/dist/css/flat-ui.css" rel="stylesheet">
    <title>shareYourIMG</title>
</head>
<body>
    <div class="container">

        <c:if test="${openid!=null}">
            <h3 class="text-center" >上传图片</h3>
            <div class="row">
                <div class="col-xs-4">
                    <img src="<%=basePath%>/img/1409573908774972.jpg"  id="img1" class="img-responsive img-rounded" />
                </div>
                <div class="col-xs-4">
                    <img src="<%=basePath%>/img/1409573908774972.jpg" id="img2" class="img-responsive img-rounded" />
                </div>
                <div class="col-xs-4">
                    <img src="<%=basePath%>/img/1409573908774972.jpg" id="img3" class="img-responsive img-rounded" />
                </div>
            </div>

            <div class="row">
                <div class="col-xs-6 col-xs-offset-3" style="margin-top: 5px;">
                    <button class="btn btn-block btn-lg btn-primary" id="chooseImage">选择图片</button>
                    <button class="btn btn-block btn-lg btn-danger" id="uploadImage">上传图片</button>
                    <button class="btn btn-block btn-lg btn-success" id="downloadImage">下载图片</button>
                </div>
            </div>
        </c:if>
        <c:if test="${openid==null}">
            <div class="row">
                <h3 class="text-center">亲爱的用户请先关注公众号</h3>
            </div>
        </c:if>

    </div>

<input type="hidden" id="pageid" value="${page.id}">
<input type="hidden" id="imgUrl" value="${page.imgurl}">
<input type="hidden" id="title" value="${page.title}">
<input type="hidden" id="openid" value="${openid}">
<input type="hidden" id="desc" value="${page.desc}">
</body>

<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/common/dist/js/flat-ui.min.js"></script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="${pageContext.request.contextPath}/js/wechat.js"></script>
</html>
