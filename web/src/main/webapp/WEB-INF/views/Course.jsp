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

      <div class="block clearfix">
        <div class="control_area">
          <a href=${website}newCourse style="margin-left: 600px">+新增课程</a>
          <div class="block">
            <table >
              <thead>
              <tr>
                <th>编号</th>
                <th>课程名称</th>
                <th>任课教师</th>
                <th>操作</th>
              </tr>
              </thead>
              <tbody >
              <c:forEach items="${list}" var="course" varStatus="stauts">
                <tr>
                  <td>${stauts.count}</td>
                  <td>${course.courseName}</td>
                  <td>${course.teacher}</td>
                  <td><a href=${website}editCourse?id=${course.id}>修改</a>
                    <a href=${website}delCourse?id=${course.id}>删除</a>
                  </td>
                </tr>
              </c:forEach>
              </tbody>
            </table>

          </div>

        </div></div>

  </div>
</div>



</body>
</html>
