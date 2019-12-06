<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;"></a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li>
          <form action="/loginname.do">
            <input type="text" placeholder="请输入用户名" name="username" class="input" style="width:250px; line-height:17px;display:inline-block" />
            <input type="submit" value="根据用户名模糊搜索" class="button border-main icon-search">
          </form>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120" >登录编号</th>
        <th width="120">登录名称</th>
        <th width="120">密码</th>
        <th width="10%">权限</th>
        <th width="310">操作</th>
      </tr>
      
     <c:forEach var="login" items="${loginList}" >
        <tr>
          <td style="text-center；padding-left:20px;">${login.userid }</td>
          <td style="text-center；padding-left:20px;">${login.username }</td>
          <td>${login.password }</td>
          <td>${login.pri }</td>
          <td>
            <a class="button border-red" href="/logindelete.do?userid=${login.userid}" onclick="return confirm('确定删除吗?')"><span class="icon-trash-o"></span> 删除</a> </div></td>
        </tr>
     </c:forEach>
    </table>
  </div>
</body>
</html>