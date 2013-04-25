<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门列表</title>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/jquery.easyui.js"></script>
<script type="text/javascript" src="../../js/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="../../css/easyui/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../css/easyui/icon.css">
<link rel="stylesheet" type="text/css" href="../../css/style.css">
</head>
<body>
	<div class="divpadding">
		<div class="easyui-panel" title="部门管理"
			style="width: 800px; height: 600px; padding: 10px;">
			<div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'west',split:true"
					style="width: 300px; padding: 10px">
					<div style="margin: 10px 0;"></div>
					<ul class="easyui-tree"
						data-options="url:'department!getDepartmentTree',animate:true,lines:true"></ul>
				</div>
				<div data-options="region:'center'" style="padding: 10px">
					Right Content</div>
			</div>
		</div>
	</div>
</body>
</html>