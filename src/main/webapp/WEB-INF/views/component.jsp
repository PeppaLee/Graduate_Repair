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
        <th width="120" >手机零件编号</th>
        <th width="120">零件名称</th>
        <th width="120">价格</th>
        <th width="10%">库存</th>
        <th width="310">操作</th>
      </tr>

      <c:forEach var="component" items="${pageBean.list }" >
        <tr>
          <td style="text-center；padding-left:10px;">${component.cid }</td>
          <td style="text-center；padding-left:20px;">${component.cname }</td>
          <td>${component.cprice }</td>
          <td>${component.inventory }</td>
          <td><div class="button-group"> <a class="button border-main" href="/componentid.do?cid=${component.cid}&type=update"><span class="icon-edit"></span> 修改</a>
          	<a class="button border-red" href="/componentdelete.do?cid=${component.cid}" onclick="return confirm('确定删除吗?')"><span class="icon-trash-o"></span> 删除</a> </div></td>
        </tr>
      </c:forEach>

      <tr>
        <td colspan="8">
        	<div class="pagelist">
        		<a href="/componentPage.do?currentPage=1">首页</a>
        		<a href="/componentPage.do?currentPage=${pageBean.currentPage - 1}">上一页</a>
        		<a href="/componentPage.do?currentPage=${pageBean.currentPage + 1}">下一页</a>
        		<a href="/componentPage.do?currentPage=${pageBean.totalPage}">尾页</a> </div></td>
      </tr>
    </table>
  </div>
</form>

</body>
</html>