<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1>管理员后台管理中心</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="#" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="login.html"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-pencil-square-o"></span>维修员管理</h2>
  <ul style="display:block">
    <li><a href="/emppage.do" target="right"><span class="icon-caret-right"></span>维修员数据</a></li>
    <li><a href="/router.do?router=emp_add" target="right"><span class="icon-caret-right"></span>增加维修员</a></li>
    <li><a href="/router.do?router=emp_select" target="right"><span class="icon-caret-right"></span>查找维修员</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>维修记录管理</h2>
  <ul>
    <li><a href="list.html" target="right"><span class="icon-caret-right"></span>维修记录数据</a></li>
    <li><a href="add.html" target="right"><span class="icon-caret-right"></span>增加记录</a></li>
  </ul>  
  <h2><span class="icon-pencil-square-o"></span>维修报价管理</h2>
  <ul>
    <li><a href="#" target="right"><span class="icon-caret-right"></span>维修报价数据</a></li>
    <li><a href="#" target="right"><span class="icon-caret-right"></span>添加报价</a></li>
  </ul>  
  <h2><span class="icon-pencil-square-o"></span>维修进度管理</h2>
  <ul>
    <li><a href="#" target="right"><span class="icon-caret-right"></span>查看维修进度</a></li>
  </ul> 
  <h2><span class="icon-pencil-square-o"></span>维修员评级管理</h2>
  <ul>
    <li><a href="#" target="right"><span class="icon-caret-right"></span>维修员等级数据</a></li>
    <li><a href="#" target="right"><span class="icon-caret-right"></span>添加维修员等级</a></li>
  </ul> 
  <h2><span class="icon-pencil-square-o"></span>手机零件管理</h2>
  <ul>
    <li><a href="#" target="right"><span class="icon-caret-right"></span>手机零件数据</a></li>
    <li><a href="#" target="right"><span class="icon-caret-right"></span>添加手机零件</a></li>
  </ul>  
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="#" target="right" class="icon-home"> 首页</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</php></span>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="" name="right" width="100%" height="100%"></iframe>
</div>

</div>
</body>
</html>