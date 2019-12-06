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
          <form action="/phoneid.do">
            <input type="text" placeholder="请输入维修手机编号" name="phoneid" class="input" style="width:250px; line-height:17px;display:inline-block" />
            <input type="submit" value="根据维修手机编号搜索" class="button border-main icon-search">
          </form>
        </li>
        <li>
          <form action="/phonetype.do">
            <input type="text" placeholder="请输入维修手机类型" name="ptype" class="input" style="width:250px; line-height:17px;display:inline-block" />
            <input type="submit" value="根据维修手机类型模糊搜索" class="button border-main icon-search">
          </form>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120" >维修手机编号</th>
        <th width="120">维修手机类型</th>
        <th width="120">损坏原因</th>
        <%--<th width="310">操作</th>--%>
      </tr>
      
     <c:forEach var="phone" items="${phoneList}" >
        <tr>
          <td style="text-center；padding-left:20px;">${phone.phoneid}</td>
          <td style="text-center；padding-left:20px;">${phone.ptype}</td>
          <td>${phone.reason}</td>
        </tr>
     </c:forEach>
    </table>
  </div>
</body>
</html>