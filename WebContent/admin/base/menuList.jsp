<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>功能树列表</title>
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
		style="width: 1000px; height: 600px; padding: 10px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west',split:true"
				style="width: 300px; padding: 10px">
				<div style="margin: 10px 0;"></div>
				<ul class="easyui-tree" id="ulTree"
					data-options="url:'../menutree!getList?flag=1',animate:true,lines:true"></ul>
			</div>
			<div data-options="region:'center'" style="padding: 10px">
				<form id="form1" method="post">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td align="right" width="120px">所选节点：</td>
							<td><input type="text" id="selUrlText" name="selUrlText"
								class="easyui-validatebox" size="50" /> <input type="hidden"
								id="hidId" name="hidId" /></td>
						</tr>
						<tr>
							<td align="right">所选节点url：</td>
							<td><input type="text" id="selUrl" name="selUrl"
								class="easyui-validatebox" size="50" /></td>
						</tr>
						<tr>
							<td align="right" width="120px">添加节点：</td>
							<td><input type="text" id="newUrlText" name="newUrlText"
								class="easyui-validatebox" size="50" /></td>
						</tr>

						<tr>
							<td align="right">添加节点url：</td>
							<td><input type="text" id="newUrl" name="newUrl"
								class="easyui-validatebox" size="50" /></td>
						</tr>
						<tr>
							<td align="right">是否显示：</td>
							<td><input type="radio" name="rdisplay" id="rdisplay"
								value="0" checked="checked"> 显示 <input type="radio"
								name="rdisplay" id="rdisplay" value="1"> 隐藏</td>
						</tr>
						<tr>
							<td align="right">是否在新窗口显示：</td>
							<td><input type="radio" name="rNewW" id="rNewW" value="1">
								是 <input type="radio" name="rNewW" id="rNewW" value="0"
								checked="checked"> 否</td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="button"
								value="删除该节点" id="btnDel" name="btnDel" /><input type="button"
								value="修改该节点" id="btnUpdate" name="btnUpdate" /><input
								type="button" value="添加子节点" id="btnAdd" name="btnAdd" /></td>
						</tr>
					</table>
					<input type="hidden" id="hidId" name="hidId" />
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('#ulTree').tree({
				onClick : function(node) {
					$("#hidId").val(node.id);
					$("#selUrlText").val(node.text);
					$("#selUrl").val(node.attributes.url);
				}
			});
			$("#btnAdd").click(function() {
				if ($.trim($("#newUrlText").val()) == "") {
					alert("请输入节点名称！");
					return false;
				}
				$.ajax({
					url : "../menutree!addTree",
					type : "post",
					data : $("#form1").serialize(),
					dataType : "text",
					success : function(data) {
						if (data == "success") {
							alert("添加成功");
							$('#ulTree').tree("reload");
						}
					},
					error : function(a, b, c) {
						alert("添加失败！");
					}
				});
			});
			$("#btnDel").click(function() {
				if (confirm("你确定要进行删除操作？")) {
					$.ajax({
						url : "../menutree!delTree",
						type : "post",
						data : {
							id : $("#hidId").val()
						},
						dataType : "text",
						success : function(data) {
							if (data == "success") {
								alert("删除成功");
								$('#ulTree').tree("reload");
							}
						},
						error : function(a, b, c) {
							alert("删除失败！");
						}
					});
				}
			});
			$("#btnUpdate").click(function() {
				if (confirm("你确定要进行修改？")) {
					if ($.trim($("#selUrlText").val()) == "") {
						alert("请输入节点名称！");
						return false;
					}
					$.ajax({
						url : "../menutree!updateTree",
						type : "post",
						data : $("#form1").serialize(),
						dataType : "text",
						success : function(data) {
							if (data == "success") {
								alert("修改成功");
								$('#ulTree').tree("reload");
							}
						},
						error : function(a, b, c) {
							alert("修改失败！");
						}
					});
				}
			});
		})
	</script>
</body>
</html>