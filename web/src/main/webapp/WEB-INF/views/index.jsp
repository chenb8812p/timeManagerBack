<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- **********************************************************************************
*Description: 首页
*author:     mayuan
*date:        2015.8.17
************************************************************************************************* -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>学生管理系统--首页</title>
    <link rel="stylesheet" type="text/css" href='<c:url value="/css/common/common.css"></c:url>'>
    <link rel="stylesheet" type="text/css" href='<c:url value="/css/base/reset.css"></c:url>'>
    <script type="text/javascript" src='<c:url value="/js/site-config.js"></c:url>'></script>
    <script src="http://pui.pandawork.net/1.1/lib/kissy/seed.js"></script>
    <link rel="stylesheet" type="text/css" href='<c:url value="/css/index.css"></c:url>'>
</head>
<body>
<div class="header">
    <a class="header_log">学生管理系统</a>
</div>
<div class="continer">
    <!-- welInfor start -->
    <div class="wel_peo wel_peo_ind clearfix">
        <div class="wel_inf">你好:
            <span class="">${currentUser.userName}</span>
        </div>
        <div class="wel_ext"><a href=${website}toLogin>退出</a> </div>
    </div>
    <div class="block_form block_form_ind">
        <h1>学生管理系统</h1>
        <hr/>
        <ul class="clearfix">
            <li><a class="item_invite" href=${website}Student/Student></a>
                <p>学生信息</p></li>
            <li><a class="item_user" href=${website}Score></a>
                <p>成绩管理</p></li>
            <li><a class="item_key" href=${website}Course></a>
                <p>课程管理</p></li>
            <li><a class="item_open" href=${website}System></a>
                <p>系统设置</p></li>
        </ul>
    </div>
</div>
</body>
</html>

