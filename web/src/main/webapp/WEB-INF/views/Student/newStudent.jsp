<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!--
Description: 课程管理页面
author:      myuan
date:        2015.8.26 -->
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>学生管理系统——课程管理</title>
  <link rel="stylesheet" type="text/css" href='<c:url value="/css/common/common.css"></c:url>'>
  <link rel="stylesheet" type="text/css" href='<c:url value="/css/base/reset.css"></c:url>'>
  <script type="text/javascript" src='<c:url value="/js/site-config.js"></c:url>'></script>
  <script src='<c:url value="/js/jquery.js"></c:url>'></script>
  <link rel="stylesheet" type="text/css" href='<c:url value="/css/key_manager.css"></c:url>'>
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
    <div class="submenu "><a  href=${website}Student/Student>学生信息</a></div>
    <div class="submenu "><a  href=${website}Score>成绩管理</a></div>
    <div class="submenu active"><a  href=${website}Course>课程管理</a></div>
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
        <div class="block">
          <a href=${website}Student>【返回】</a>
          <form class="block_form" action="${website}Student/newStudent" method="post">

            学号 <input type="text" name="stuNum" id="J_stuNum"><br><br>
            姓名<input type="text" name="stuName"><br><br>
            学院<input type="text" name="stuInstitute"><br><br>
            班级<input type="text" name="stuClass"><br><br>
            <input type="submit" value="提交" style="margin-left: 300px">

          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<script>
  $(document).ready(function(){
    $('#J_stuNum').on('change' , function(){
//        console.log(1);
      var stuNum = $('#J_stuNum').val();
      $.getJSON('${website}Student/ajax/checkusername',{stuNum:stuNum},function(result){
        console.log(result);
      })
    });
  })
</script>
</body>
</html>

