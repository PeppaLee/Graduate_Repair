<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>增加维修记录</title>
	<link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery.js"></script>
	<script src="js/pintuer.js"></script>
</head>

<body>

<div class="panel admin-panel">
	<div class="panel-head"><strong><span class="icon-key"></span>增加维修记录</strong></div>
	<div class="body-content">
		<form action="/recordsave.do" method="post" class="form-x" >
			<div class="form-group">
				<div class="label">
					<label>维修员编号：</label>
				</div>
				<div class="field">
					<input type="text" name="empno" class="input w50" autofocus/>
				</div>
			</div>

			<div class="form-group">
				<div class="label">
					<label >维修手机编号：</label>
				</div>
				<div class="field">
					<input type="text" name="phoneid" class="input w50"/>
				</div>
			</div>

			<div class="form-group">
				<div class="label">
					<label>维修开始日期：</label>
				</div>
				<div class="field">
					<input type="date" name="startday" class="input w50"/>
				</div>
			</div>

			<div class="form-group">
				<div class="label">
					<label>维修结束日期：</label>
				</div>
				<div class="field">
					<input type="date" name="endday" class="input w50"/>
				</div>
			</div>

			<div class="form-group">
				<div class="label">
					<label >收费：</label>
				</div>
				<div class="field">
					<input type="text" name="charge" class="input w50"/>
				</div>
			</div>

			<div class="form-group">
				<div class="label">
					<label>维修结果：</label>
				</div>
				<div class="field">
					<input type="text" name="result" class="input w50" />
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