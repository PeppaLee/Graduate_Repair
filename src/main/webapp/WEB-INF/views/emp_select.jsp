<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
          <form action="/empid.do">
            <input type="text" placeholder="请输入员工编号" name="empno" class="input" style="width:250px; line-height:17px;display:inline-block" />
            <input type="submit" value="根据员工编号搜索" class="button border-main icon-search">
          </form>
        </li>
        <li>
          <form action="/empname.do">
            <input type="text" placeholder="请输入员工名字" name="ename" class="input" style="width:250px; line-height:17px;display:inline-block" />
            <input type="submit" value="根据员工名字模糊搜索" class="button border-main icon-search">
          </form>
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
      </tr>
      
     <c:forEach var="emp" items="${empList}" >
        <tr>
          <td style="text-center；padding-left:20px;">${emp.empno }</td>
          <td style="text-center；padding-left:20px;">${emp.ename }</td>
          <td>${emp.gender }</td>
          <td>${emp.grade }</td>
          <td>${emp.sal }</td>
          <td><fmt:formatDate value="${emp.hiredate }" type="date" pattern="yyyy-MM-dd"/></td>
          <td>${emp.partid }</td>
        </tr>
     </c:forEach>
    </table>
  </div>
<script type="text/javascript">

//搜索
function changesearch(){	
		
}

//单个删除
function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){
		
	}
}


</script>
</body>
</html>