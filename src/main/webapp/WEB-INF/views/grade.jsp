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
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;"></a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li>

        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="150" >员工编号</th>
        <th width="150">姓名</th>
        <th width="150">维修次数</th>
        <th width="10%">成功次数</th>
        <th width="150">等级</th>
        <th width="310">操作</th>
      </tr>

      <c:forEach var="grade" items="${pageBean.list }" >
        <tr>
          <td style="text-center；padding-left:10px;">${grade.empno }</td>
          <td style="text-center；padding-left:20px;">${grade.ename }</td>
          <td>${grade.times }</td>
          <td>${grade.successtimes }</td>
          <td>${grade.grade }</td>
          <td><div class="button-group"> <a class="button border-main" href="/gradeid.do?empno=${grade.empno}&type=update"><span class="icon-edit"></span> 修改</a>
          	<a class="button border-red" href="/gradedelete.do?empno=${grade.empno}" onclick="return confirm('确定删除吗?')"><span class="icon-trash-o"></span> 删除</a> </div></td>
        </tr>
      </c:forEach>

      <tr>
        <td colspan="8">
        	<div class="pagelist">
        		<a href="/gradepage.do?currentPage=1">首页</a>
        		<a href="/gradepage.do?currentPage=${pageBean.currentPage - 1}">上一页</a>
        		<a href="/gradepage.do?currentPage=${pageBean.currentPage + 1}">下一页</a>
        		<a href="/gradepage.do?currentPage=${pageBean.totalPage}">尾页</a> </div></td>
      </tr>
    </table>
  </div>
</form>

</body>
</html>