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
          <form action="/componentid.do">
            <input type="text" placeholder="请输入零件编号" name="cid" class="input" style="width:250px; line-height:17px;display:inline-block" />
            <input type="submit" value="根据零件编号搜索" class="button border-main icon-search">
          </form>
        </li>
        <li>
          <form action="/componentname.do">
            <input type="text" placeholder="请输入零件名称" name="cname" class="input" style="width:250px; line-height:17px;display:inline-block" />
            <input type="submit" value="根据零件名称模糊搜索" class="button border-main icon-search">
          </form>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120" >手机零件编号</th>
        <th width="120">零件名称</th>
        <th width="120">价格</th>
        <th width="10%">库存</th>
        <%--<th width="310">操作</th>--%>
      </tr>
      
     <c:forEach var="component" items="${componentList}" >
        <tr>
          <td style="text-center；padding-left:20px;">${component.cid }</td>
          <td style="text-center；padding-left:20px;">${component.cname }</td>
          <td>${component.cprice }</td>
          <td>${component.inventory }</td>
        </tr>
     </c:forEach>
    </table>
  </div>
</body>
</html>