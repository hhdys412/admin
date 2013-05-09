<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript" src="../js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript">
	$(function() {
		$("#userName").focus();
		$("#loginDiv")
				.css("top", ($(document).height() - $("#loginDiv").height()) / 2).css(
						"left", ($(document).width() - $("#loginDiv").width()) / 2)
	});
	function checkInput() {
		if ($.trim($("#userName").val()) == "") {
			alert("用户名不能为空！");
			return false;
		}
		if ($.trim($("#password").val()) == "") {
			alert("密码不能为空！");
			return false;
		}
	}
</script>
<style type="text/css">
.login {
	position: absolute;
}
</style>
</head>
<body>
	<form action="login!login" method="post">
		<div class="login" id="loginDiv">
			<table width="400px" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="2" align="center" style="font-size: x-large;">登录</td>
				</tr>
				<tr>
					<td align="right" width="120px">用户名：</td>
					<td><input type="text" id="userName" name="userName" /></td>
				</tr>
				<tr>
					<td align="right">密码：</td>
					<td><input type="password" id="password" name="password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="登录"
						onclick="return checkInput()" /> <input type="reset" value="重置" /></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>