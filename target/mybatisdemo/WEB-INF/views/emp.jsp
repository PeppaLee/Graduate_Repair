<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />--%>
<%--<meta name="renderer" content="webkit">--%>
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
        <th width="100" style="text-align:left; padding-left:20px;">维修员编号</th>
        <th width="10%">维修员名字</th>
        <th>性别</th>
        <th width="10%">等级</th>
        <th>工资</th>
        <th>入职日期</th>
        <th>维修部分</th>
        <th width="310">操作</th>
      </tr>

      <c:forEach var="emp" items="${pageBean.list }" >
        <tr>
          <td style="text-center；padding-left:20px;">${emp.empno }</td>
          <td style="text-center；padding-left:20px;">${emp.ename }</td>
          <td>${emp.gender }</td>
          <td>${emp.grade }</td>
          <td>${emp.sal }</td>
          <td>${emp.hiredate }</td>
          <td>${emp.partid }</td>
          <td><div class="button-group"> <a class="button border-main" href="/empid.do?empno=${emp.empno}&type=update"><span class="icon-edit"></span> 修改</a>
          	<a class="button border-red" href="/empdelete.do?empno=${emp.empno}" onclick="return confirm('确定删除吗?')"><span class="icon-trash-o"></span> 删除</a> </div></td>
        </tr>
      </c:forEach>

      <tr>
        <td colspan="8">
        	<div class="pagelist">
        		<a href="/emppage.do?currentPage=1">首页</a>
        		<a href="/emppage.do?currentPage=${pageBean.currentPage - 1}">上一页</a>
        		<a href="/emppage.do?currentPage=${pageBean.currentPage + 1}">下一页</a>
        		<a href="/emppage.do?currentPage=${pageBean.totalPage}">尾页</a> </div></td>
      </tr>
    </table>
  </div>
</form>

</body>
</html>