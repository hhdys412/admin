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
<body class="easyui-layout">
	<div region="north" style="height: 100px; text-align: center;">
		<h3>后台管理系统</h3>
	</div>
	<div region="west" split="true" title="菜单栏" style="width: 150px;">
		<a href="#" class="easyui-linkbutton"
			onclick="addTab('买卖宝OA','http://oa.ebinf.com')">买卖宝OA</a> <a href="#"
			class="easyui-linkbutton"
			onclick="addTab('jquery','http://jquery.com/')">jquery</a> <a
			href="#" class="easyui-linkbutton"
			onclick="addTab('easyui','http://jeasyui.com/')">easyui</a>
	</div>
	<div id="content" region="center" class="easyui-tabs" fit="true"></div>
	<script type="text/javascript">
		function addTab(title, url) {
			if ($('#content').tabs('exists', title)) {
				$('#content').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'
						+ url + '" style="width:100%;height:100%;"></iframe>';
				$('#content').tabs('add', {
					title : title,
					content : content,
					closable : true
				});
			}
		}
	</script>
</body>
</html>