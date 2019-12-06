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
  </div>
  <table class="table table-hover text-center">
    <tr>
      <th width="120" >维修进度编号</th>
      <th width="120">维修手机编号</th>
      <th width="10%">维修进度</th>
      <th width="10%">预估结果</th>
      <th width="10%">说明</th>
      <!--<%--<th width="310">操作</th>--%>-->
    </tr>

    <c:forEach var="schedule" items="${scheduleList}" >
      <tr>
        <td style="text-center；padding-left:20px;">${schedule.schid }</td>
        <td>${schedule.phoneid }</td>
        <td>${schedule.repairschdeule }</td>
        <td>${schedule.expectresult }</td>
        <td>${schedule.declares }</td>
        <td><div class="button-group"> <a class="button border-main" href="/empid.do?empno=${emp.empno}&type=update"><span class="icon-edit"></span> 修改</a>
          <a class="button border-red" href="/empdelete.do?empno=${emp.empno}" onclick="return confirm('确定删除吗?')"><span class="icon-trash-o"></span> 删除</a> </div></td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>