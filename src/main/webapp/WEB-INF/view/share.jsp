<%--
  Created by IntelliJ IDEA.
  User: yanglin
  Date: 2017/3/6
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>程序员之路</title>
</head>
<body>
<div class="container">
    <h3 class="text-center" >程序员之路</h3>
    <div class="row">
        <div class="col-xs-10 col-xs-offset-1" style="border:dotted">
            <p class="text-center"><small>毕业了找工作了，会是这样的</small></p>
            <img src="<%=basePath%>/img/i1.jpg" class="img-responsive"><br/>
        </div>
    </div>
    <hr />
    <div class="row">
        <div class="col-xs-10 col-xs-offset-1"style="border:dotted">
            <p class="text-center"><small>金融危机失业了，就变这样了</small></p>
            <img src="<%=basePath%>/img/i2.jpg" class="img-responsive"/><br/>
        </div>
    </div>
    <hr/>
    <div class="row">
        <div class="col-xs-10 col-xs-offset-1"style="border:dotted">
            <p class="text-center"><small>找到工作了后的几年是这样的</small></p>
            <img src="<%=basePath%>/img/cxy.jpg" class="img-responsive"/><br/>
        </div>
    </div>
    <hr/>
    <div class="row">
        <div class="col-xs-10 col-xs-offset-1"style="border:dotted">
            <p class="text-center"><small>其实项目经理是这样的</small></p>
            <img src="<%=basePath%>/img/i3.jpg" class="img-responsive"/><br/>
        </div>
    </div>
    <br/>

    <div class="row">
        <div class="col-xs-10 col-xs-offset-1">
            <p class="text-center">分享一下又不会死</p>
        </div>
    </div>

    <input type="hidden" id="pageid" value="${page.id}">
    <input type="hidden" id="imgUrl" value="${page.imgurl}">
    <input type="hidden" id="title" value="${page.title}">
    <input type="hidden" id="desc" value="${page.desc}">
</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/common/dist/js/flat-ui.min.js"></script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="${pageContext.request.contextPath}/js/wechat.js"></script>
</html>
