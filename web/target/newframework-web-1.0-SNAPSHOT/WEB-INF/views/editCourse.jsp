<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>学生管理系统--学生信息</title>
  <link rel="stylesheet" type="text/css" href='<c:url value="/css/common/common.css"></c:url>'>
  <link rel="stylesheet" type="text/css" href='<c:url value="/css/base/reset.css"></c:url>'>
  <script type="text/javascript" src='<c:url value="/js/site-config.js"></c:url>'></script>
  <script src="http://pui.pandawork.net/1.1/lib/kissy/seed.js"></script>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
  <script type="text/javascript" src="http://jquery-json.googlecode.com/files/jquery.json-2.2.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/user/index.js"></script>
  <link rel="stylesheet" type="text/css" href='<c:url value="/css/visitor_invite.css"></c:url>'>
</head>
<body>
<div class="header">
  <a class="header_log">学生管理系统</a>
</div>
<div class="continer clearfix">
  <div class="sidebar">
    <div class="meneu "> 功能菜单</div>
    <div class="submenu active"><a  href=${website}Student>学生信息</a></div>
    <div class="submenu"><a  href=${website}Score>成绩管理</a></div>
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
    <form class="block_form" action="${website}editCourse?id=${course.id}" method="post" >
      <div class="block clearfix">
        <div class="control_area">

          <div class="block">

           课程名<input type="text" name="courseName"  value="${course.courseName}"><br>
            任课教师<input type="text" name="teacher" value="${course.teacher}"><br>
            <input type="submit" value="修改">
          </div>

        </div></div>
    </form>
  </div>
</div>


</body>
</html>
