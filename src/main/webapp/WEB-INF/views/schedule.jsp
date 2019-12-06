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
        <th width="150" >维修进度编号</th>
        <th width="150">维修员编号</th>
        <th width="150">维修手机编号</th>
        <th width="10%">维修进度</th>
        <th width="150">预估结果</th>
        <th width="150">说明</th>
      </tr>

      <c:forEach var="schedule" items="${pageBean.list }" >
        <tr>
          <td style="text-center；padding-left:10px;">${schedule.schid }</td>
          <td style="text-center；padding-left:20px;">${schedule.empno }</td>
          <td>${schedule.phoneid }</td>
          <td>${schedule.repairschdeule }</td>
          <td>${schedule.expectresult }</td>
          <td>${schedule.declares }</td>
        </tr>
      </c:forEach>

      <tr>
        <td colspan="8">
        	<div class="pagelist">
        		<a href="/schedulepage.do?currentPage=1">首页</a>
        		<a href="/schedulepage.do?currentPage=${pageBean.currentPage - 1}">上一页</a>
        		<a href="/schedulepage.do?currentPage=${pageBean.currentPage + 1}">下一页</a>
        		<a href="/schedulepage.do?currentPage=${pageBean.totalPage}">尾页</a> </div></td>
      </tr>
    </table>
  </div>
</form>

</body>
</html>