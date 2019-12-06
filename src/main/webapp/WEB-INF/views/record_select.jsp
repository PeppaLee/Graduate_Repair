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
          <form action="/recordid.do">
            <input type="text" placeholder="请输入维修记录编号" name="recordid" class="input" style="width:250px; line-height:17px;display:inline-block" />
            <input type="submit" value="根据维修记录编号搜索" class="button border-main icon-search">
          </form>
        </li>
        <li>
          <form action="/recordemp.do">
            <input type="text" placeholder="请输入员工编号" name="empno" class="input" style="width:250px; line-height:17px;display:inline-block" />
            <input type="submit" value="根据员工编号搜索" class="button border-main icon-search">
          </form>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120" style="text-align:left; padding-left:20px;">维修记录编号</th>
        <th width="10%">维修员编号</th>
        <th>维修手机编号</th>
        <th width="10%">开始时间</th>
        <th>结束时间</th>
        <th>收费</th>
        <th>维修结果</th>
      </tr>
      
     <c:forEach var="record" items="${recordList}" >
        <tr>
          <td style="text-center；padding-left:20px;">${record.recordid }</td>
          <td style="text-center；padding-left:20px;">${record.empno }</td>
          <td>${record.phoneid }</td>
          <td><fmt:formatDate value="${record.startday }" type="date" pattern="yyyy-MM-dd"/></td>
          <td><fmt:formatDate value="${record.endday }" type="date" pattern="yyyy-MM-dd"/></td>
          <td>${record.charge }</td>
          <td>${record.result }</td>
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