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
	<div class="easyui-panel" title="功能树管理"
		style="width: 800px; height: 600px; padding: 10px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west',split:true"
				style="width: 300px; padding: 10px">
				<div style="margin: 10px 0;"></div>
				<ul class="easyui-tree" id="ulTree"
					data-options="url:'../menutree!getList',animate:true,lines:true"></ul>
			</div>
			<div data-options="region:'center'" style="padding: 10px">
				<form id="form1" method="post">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td align="right" width="120px">所选部门：</td>
							<td><input type="text" id="selDepart" name="selDepart"
								class="easyui-validatebox" data-options="required:true" /></td>
						</tr>
						<tr>
							<td align="right">子部门：</td>
							<td><input type="text" id="department" name="department"
								class="easyui-validatebox" data-options="required:true" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="button"
								value="删除该部门" id="btnDel" name="btnDel" /><input type="button"
								value="修改该部门" id="btnUpdate" name="btnUpdate" /><input
								type="button" value="添加子部门" id="btnAdd" name="btnAdd" /></td>
						</tr>
					</table>
					<input type="hidden" id="hidId" name="hidId" />
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			
		})
	</script>
</body>
</html>