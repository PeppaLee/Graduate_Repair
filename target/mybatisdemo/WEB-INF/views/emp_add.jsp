<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>增加维修员</title>
	<link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery.js"></script>
	<script src="js/pintuer.js"></script>
</head>

<body>

<div class="panel admin-panel">
	<div class="panel-head"><strong><span class="icon-key"></span>增加维修员</strong></div>
	<div class="body-content">
		<form action="/empsave.do" method="post" class="form-x" >
			<div class="form-group">
				<div class="label">
					<label>维修员姓名：</label>
				</div>
				<div class="field">
					<input type="text" name="ename" class="input w50" autofocus/>
				</div>
			</div>

			<div class="form-group">
				<div class="label">
					<label >性别：</label>
				</div>
				<div class="field">
					<select name="gender" class="input w50" />
					<option value="male">男</option>
					<option value="female">女</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="label">
					<label>维修等级：</label>
				</div>
				<div class="field">
					<select name="grade" class="input w50" />
					<option value="A">A</option>
					<option value="B">B</option>
					<option value="C">C</option>
					<option value="D">D</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="label">
					<label>工资：</label>
				</div>
				<div class="field">
					<input type="text" name="sal" class="input w50" />
				</div>
			</div>

			<div class="form-group">
				<div class="label">
					<label>入职日期：</label>
				</div>
				<div class="field">
					<input type="date" name="hiredate" class="input w50" />
				</div>
			</div>

			<div class="form-group">
				<div class="label">
					<label>负责维修的部分：</label>
				</div>
				<div class="field">
					<input type="text" name="partid" class="input w50" />
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