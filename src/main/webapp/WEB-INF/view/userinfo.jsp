<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link href="${pageContext.request.contextPath}/common/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/common/dist/css/flat-ui.css" rel="stylesheet">
    <title>用户信息</title>
    <style>
        .container{
            border: dashed;
            border-color: yellow;
            border-radius: 25px;
            margin-top: 25px;
        }

        span{
            color:#2C81BA
        }
    </style>
</head>

<body>
<div class="container">
    <div class="row">
        <h3 class="text-center"> 用户信息</h3>
    </div>
    <c:if test="${user!=null}">
        <div class="row">
            <div class="col-xs-10 col-xs-offset-1">
                <div class="form-group has-success">
                    <span>头像</span>
                    <img src="${user.headImgUrl}"class="img-circle col-xs-offset-6" style="height: 50px;"/><br />
                    <span>OpenID</span>
                    <input type="text" class="form-control" value="${user.openId}"/>
                    <span>昵称</span>
                    <input type="text" class="form-control" value="${user.nickname}"/>
                    <span>性别</span>
                    <input type="text" class="form-control" value="${user.sex}"/>
                    <span>省份 </span>
                    <input type="text" class="form-control" value="${user.province}"/>
                    <span>城市 </span>
                    <input type="text" class="form-control" value="${user.city}"/>
                    <span>国家 </span>
                    <input type="text" class="form-control" value="${user.country}"/>
                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${user==null}">
        <div class="row">
            <h3 class="text-center"> 用户没有授权</h3>
        </div>
    </c:if>

</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/common/dist/js/flat-ui.min.js"></script>
</html>
