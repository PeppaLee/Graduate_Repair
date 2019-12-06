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
          <form action="/gradeid.do">
            <input type="text" placeholder="请输入员工编号" name="empno" class="input" style="width:250px; line-height:17px;display:inline-block" />
            <input type="submit" value="根据员工编号搜索" class="button border-main icon-search">
          </form>
        </li>
        <li>
          <form action="/gradename.do">
            <input type="text" placeholder="请输入员工姓名" name="ename" class="input" style="width:250px; line-height:17px;display:inline-block" />
            <input type="submit" value="根据员工姓名模糊搜索" class="button border-main icon-search">
          </form>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120" >维修员编号</th>
        <th width="120">维修员姓名</th>
        <th width="120">维修次数</th>
        <th width="10%">成功次数</th>
        <th width="10%">等级</th>
        <%--<th width="310">操作</th>--%>
      </tr>
      
     <c:forEach var="grade" items="${gradeList}" >
        <tr>
          <td style="text-center；padding-left:20px;">${grade.empno }</td>
          <td style="text-center；padding-left:20px;">${grade.ename }</td>
          <td>${grade.times }</td>
          <td>${grade.successtimes }</td>
          <td>${grade.grade }</td>
        </tr>
     </c:forEach>
    </table>
  </div>
</body>
</html>