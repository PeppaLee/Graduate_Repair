<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>增加登录数据</title>
	<link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery.js"></script>
	<script src="js/pintuer.js"></script>
</head>

<body>

<div class="panel admin-panel">
	<div class="panel-head"><strong><span class="icon-key"></span>增加登录数据</strong></div>
	<div class="body-content">
		<form action="/loginsave.do" method="post" class="form-x" >
			<div class="form-group">
				<div class="label">
					<label>用户名：</label>
				</div>
				<div class="field">
					<input type="text" name="username" class="input w50" autofocus/>
				</div>
			</div>

			<div class="form-group">
				<div class="label">
					<label >密码：</label>
				</div>
				<div class="field">
					<input type="text" name="password" class="input w50"  />
				</div>
			</div>

			<div class="form-group">
				<div class="label">
					<label>权限：</label>
				</div>
				<div class="field">
					<select name="pri" class="input w50" />
					<option value="1">管理员</option>
					<option value="2">维修员</option>
					</select>
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