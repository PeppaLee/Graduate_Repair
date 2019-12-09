<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>更新维修进度记录</title>
		<link rel="stylesheet" href="css/pintuer.css">
		<link rel="stylesheet" href="css/admin.css">
		<script src="js/jquery.js"></script>
		<script src="js/pintuer.js"></script>
	</head>

	<body>
		
		<div class="panel admin-panel">
			<div class="panel-head"><strong><span class="icon-key"></span>更新维修进度记录</strong></div>
			<div class="body-content">
				<form onsubmit="return confirm('确定更新吗？')" action="/scheduleupdate.do" method="get" class="form-x" >
					<div class="form-group">
						<div class="label">
							<label>维修进度编号：</label>
						</div>
						<div class="field">
							<span style="font-size: x-large">${schedule.schid}</span><input type="hidden" name="schid" value="${schedule.schid}" class="input w50" />
						</div>
					</div>
					
					<div class="form-group">
						<div class="label">
							<label>维修手机编号：</label>
						</div>
						<div class="field">
							<input type="text" name="phoneid" value="${schedule.phoneid}" class="input w50" autofocus/>
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<label >维修进度：</label>
						</div>
						<div class="field">
							<input type="text" name="repairschdeule" value="${schedule.repairschdeule}" class="input w50" />
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<label>预估结果：</label>
						</div>
						<div class="field">
							<input type="text" name="expectresult" value="${schedule.expectresult}" class="input w50" />
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<label>说明：</label>
						</div>
						<div class="field">
							<input type="textarea" name="declares" value="${schedule.declares}" class="input w50"   />
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