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
  <div class="head-l"> &nbsp;&nbsp;
    <a class="button button-little bg-red" href="login.jsp">
      <span class="icon-power-off"></span> 退出登录</a>
    <a class="button button-little bg-green" href="/loginrouter.do?router=adminpwd" target="right">
      <span class="icon-power-off"></span> 更改密码</a>
  </div>
</div>
<div class="leftnav" >
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-pencil-square-o"></span>维修员管理</h2>
  <ul>
    <li><a href="/emppage.do?userid=${sessionScope.login.userid }" target="right"><span class="icon-caret-right"></span>维修员数据</a></li>
    <li><a href="/emprouter.do?router=emp_add" target="right"><span class="icon-caret-right"></span>增加维修员</a></li>
    <li><a href="/emprouter.do?router=emp_select" target="right"><span class="icon-caret-right"></span>查维修员</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>维修记录管理</h2>
  <ul>
    <li><a href="/recordpage.do" target="right"><span class="icon-caret-right"></span>维修记录数据</a></li>
    <li><a href="/recordrouter.do?router=record_add" target="right"><span class="icon-caret-right"></span>增加维修记录</a></li>
    <li><a href="/recordrouter.do?router=record_select" target="right"><span class="icon-caret-right"></span>查看维修记录</a></li>
  </ul>  
  <h2><span class="icon-pencil-square-o"></span>维修报价管理</h2>
  <ul>
    <li><a href="/offerpage.do" target="right"><span class="icon-caret-right"></span>维修报价数据</a></li>
    <li><a href="/offerrouter.do?router=offer_add" target="right"><span class="icon-caret-right"></span>添加维修报价</a></li>
    <li><a href="/offerrouter.do?router=offer_select" target="right"><span class="icon-caret-right"></span>查询维修报价</a></li>
  </ul>  
  <h2><span class="icon-pencil-square-o"></span>维修进度管理</h2>
  <ul>
    <li><a href="/schedulepage.do" target="right"><span class="icon-caret-right"></span>查看维修进度</a></li>
    <li><a href="/schedulerouter.do?router=schedule_select" target="right"><span class="icon-caret-right"></span>查找维修进度</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>维修员评级管理</h2>
  <ul>
    <li><a href="/gradepage.do" target="right"><span class="icon-caret-right"></span>维修员等级数据</a></li>
    <li><a href="/graderouter.do?router=grade_add" target="right"><span class="icon-caret-right"></span>添加维修员等级</a></li>
    <li><a href="/graderouter.do?router=grade_select" target="right"><span class="icon-caret-right"></span>查询维修员等级</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>手机零件管理</h2>
  <ul>
    <li><a href="/componentPage.do" target="right"><span class="icon-caret-right"></span>手机零件数据</a></li>
    <li><a href="/componentrouter.do?router=component_add" target="right"><span class="icon-caret-right"></span>添加手机零件</a></li>
    <li><a href="/componentrouter.do?router=component_select" target="right"><span class="icon-caret-right"></span>查找手机零件</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>登录管理</h2>
  <ul>
    <li><a href="/loginpage.do" target="right"><span class="icon-caret-right"></span>登录数据</a></li>
    <li><a href="/loginrouter.do?router=login_add" target="right"><span class="icon-caret-right"></span>添加登录数据</a></li>
    <li><a href="/loginrouter.do?router=login_select" target="right"><span class="icon-caret-right"></span>查找登录数据</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>维修手机管理</h2>
  <ul>
    <li><a href="/phonepage.do" target="right"><span class="icon-caret-right"></span>维修手机数据</a></li>
    <li><a href="/phonerouter.do?router=phone_add" target="right"><span class="icon-caret-right"></span>添加维修手机数据</a></li>
    <li><a href="/phonerouter.do?router=phone_select" target="right"><span class="icon-caret-right"></span>查找维修手机数据</a></li>
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
<ul class="bread" >

  <li><b>当前时间：</b><span style="color:red;" id="time"></span>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="" name="right" width="100%" height="100%"></iframe>
</div>

<script type="text/javascript">
    function show() {
        //创建内置Date对象
        var date = new Date();
        //获取当前年份
        var year = date.getFullYear();
        //获取当前的月份,范围是0-11
        var month = date.getMonth() + 1;
        //获取该月的第几天
        var day = date.getDate();
        //getDay方法获取当前是这个星期的第几天范围是0-6
        //周日对应0，123456分别是对应的星期几
        var week = "日一二三四五六".charAt(date.getDay());
        //获取当前小时分钟和秒
        var hour = date.getHours();
        var minute = date.getMinutes();
        var second = date.getSeconds();
        //选择id为time的标签
        var element = document.getElementById("time");
        element.innerHTML = year+"年"+month+"月"+day+"日"+"星期"+week+"	"+hour+"时"+minute+"分"+second+"秒";
    }
    show();
    //每间隔1000毫秒执行一次程序，保证时间动态显示
    setInterval("show()",1000);
</script>
</body>
</html>