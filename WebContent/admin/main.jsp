<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="../css/easyui/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../css/easyui/icon.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body class="easyui-layout" fit="true">
	<div region="north" style="height: 100px; text-align: center;">
		<div>
			<h3>后台管理系统</h3>
		</div>
		<div style="width: 200px; margin: 30px 0px 0px 0px; float: right;">
			${cookie.username.value }，<a href="loginout.jsp">登出</a>
		</div>
	</div>
	<div region="west" split="true" title="菜单栏" style="width: 150px;">
		<a href="#" class="easyui-linkbutton"
			onclick="addTab('部门管理','base/departmentList.jsp')">部门管理</a> <a href="#"
			class="easyui-linkbutton"
			onclick="addTab('用户管理','base/accountList.jsp')">用户管理</a> <a
			href="#" class="easyui-linkbutton"
			onclick="addTab('职位管理','base/positionList.jsp')">职位管理</a>
	</div>
	<div id="content" region="center" class="easyui-tabs"></div>
	<script type="text/javascript">
		function addTab(title, url) {
			if ($('#content').tabs('exists', title)) {
				$('#content').tabs('select', title);
			} else {
				/**
				var content = '<iframe scrolling="no" frameborder="0"  src="'
						+ url
						+ '" style="width:1000px;height:600px;margin: 5px 5px 5px 5px;"></iframe>';
						*/
				$('#content').tabs('add', {
					title : title,
					//content : content,
					href:url,
					closable : true
				});
			}
		}
	</script>
</body>
</html>