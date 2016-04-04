<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!--
Description: 成绩管理页面
author:     mayuan
date:        2015.8.17 -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">	
		<title>学生管理系统--成绩管理</title>
		<link rel="stylesheet" type="text/css" href='<c:url value="/css/common/common.css"></c:url>'>
		<link rel="stylesheet" type="text/css" href='<c:url value="/css/base/reset.css"></c:url>'>
		<script type="text/javascript" src='<c:url value="/js/site-config.js"></c:url>'></script>
		<script src="http://pui.pandawork.net/1.1/lib/kissy/seed.js"></script>
		<link rel="stylesheet" type="text/css" href="../resources/css/user_manager.css">
	</head>
	<body>
		<!--#include file="/pages/common/header.html"-->
		<div class="header">
			<a class="header_log">学生管理系统</a>
		</div>
		<div class="continer clearfix">
			<!--#include file="/pages/common/sidebar.html"-->
			<!-- sidebar start -->
			<div class="sidebar">
				<div class="meneu "> 功能菜单</div>
				<div class="submenu "><a  href=${website}Student>学生信息</a></div>
				<div class="submenu active"><a  href=${website}Score>成绩管理</a></div>
				<div class="submenu"><a  href=${website}Course>课程管理</a></div>
				<div class="submenu"><a  href=${website}System> 系统设置</a></div>
			</div>
			<div class="content">
				<!-- welInfor start -->
				<div class="wel_peo wel_peo_ind clearfix">
					<div class="wel_inf">你好:
						<span class="">${currentUser.userName}</span>
					</div>
					<div class="wel_ext"><a href=${website}toLogin>退出</a></div>
				</div>
				<form class="block_form">
					<div class="block">
                     已录入成绩课程：<br>
						<c:forEach items="${listt}" var="listt">
							${listt.courseName}：<a href=${website}queryScore?id=${listt.id}>查看成绩</a><br>
						</c:forEach><br>
                     未录入成绩课程：<br>
						<c:forEach items="${listn}" var="listn">
							${listn.courseName}：<a href=${website}newScore?id=${listn.id}>录入成绩</a><br>
						</c:forEach>

					</div>
				</form>
			</div>
		</div>

	</body>
</html>