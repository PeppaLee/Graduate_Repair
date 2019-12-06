<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>更新维修记录</title>
		<link rel="stylesheet" href="css/pintuer.css">
		<link rel="stylesheet" href="css/admin.css">
		<script src="js/jquery.js"></script>
		<script src="js/pintuer.js"></script>
	</head>

	<body>
		
		<div class="panel admin-panel">
			<div class="panel-head"><strong><span class="icon-key"></span>更新维修记录</strong></div>
			<div class="body-content">
				<form onsubmit="return confirm('确定更新吗？')" action="/recordupdate.do" method="get" class="form-x" >
					<div class="form-group">
						<div class="label">
							<label>维修记录编号：</label>
						</div>
						<div class="field">
							<span style="font-size: x-large">${record.recordid}</span><input type="hidden" name="recordid" value="${record.recordid}" class="input w50" />
						</div>
					</div>
					
					<div class="form-group">
						<div class="label">
							<label>维修员编号：</label>
						</div>
						<div class="field">
							<input type="text" name="empno" value="${record.empno}" class="input w50" autofocus/>
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<label >维修手机编号：</label>
						</div>
						<div class="field">
							<input type="text" name="phoneid" value="${record.phoneid}" class="input w50" />
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<label>开始时间：</label>
						</div>
						<div class="field">
							<input type="date" name="startday" value="<fmt:formatDate value='${record.startday }' type="date" pattern='yyyy-MM-dd'/>" class="input w50" />
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<label>结束时间：</label>
						</div>
						<div class="field">
							<input type="date" name="endday" value="<fmt:formatDate value='${record.endday }' type="date" pattern='yyyy-MM-dd'/>" class="input w50"   />
						</div>
					</div>
					
					<div class="form-group">
						<div class="label">
							<label>收费：</label>
						</div>
						<div class="field">
							<input type="text" name="charge" value="${record.charge}" class="input w50" />
						</div>
					</div>
					
					<div class="form-group">
						<div class="label">
							<label>结果：</label>
						</div>
						<div class="field">
							<input type="text" name="result" value="${record.result}" class="input w50" />
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<label></label>
						</div>
						<div class="field">
							<button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>

	</body>

</html>