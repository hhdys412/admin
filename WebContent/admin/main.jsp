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
		<div>
			<h3>后台管理系统</h3>
		</div>
		<div style="width: 200px; margin: 30px 0px 0px 0px; float: right;">
			${cookie.username.value }，<a href="loginout.jsp">登出</a>
		</div>
	</div>
	<div region="west" split="true" title="菜单栏" style="width: 150px;">
		<div style="padding: 10px 10px 10px 10px;">
			<ul class="easyui-tree" id="menuTree"
				data-options="url:'menutree!getList',animate:true,lines:true"></ul>
		</div>
	</div>
	<div region="center">
		<div id="content" class="easyui-tabs" fit="true"></div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('#menuTree').tree({
				onClick : function(node) {
					if ($.trim(node.attributes.url) != "") {
						addTab(node.text, node.attributes.url);
					}
				}
			});
		});
		function addTab(title, url) {
			if ($('#content').tabs('exists', title)) {
				$('#content').tabs('select', title);
			} else {

				var content = '<iframe scrolling="no" frameborder="0"  src="'
						+ url
						+ '" style="width:1000px;height:600px;margin: 5px 5px 5px 5px;" fit="true"></iframe>';

				$('#content').tabs('add', {
					title : title,
					content : content,
					//href : url,
					closable : true
				});
			}
		}
	</script>
</body>
</html>