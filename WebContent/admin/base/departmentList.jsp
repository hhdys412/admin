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
	<div class="easyui-panel" title="部门管理"
		style="width: 800px; height: 600px; padding: 10px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west',split:true"
				style="width: 300px; padding: 10px">
				<div style="margin: 10px 0;"></div>
				<ul class="easyui-tree" id="ulTree"
					data-options="url:'../department!getDepartmentTree',animate:true,lines:true"></ul>
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
								type="button" value="添加子部门" id="btnAdd" name="btnAdd" /><input
								type="button" value="设置角色" id="btnRole" name="btnRole" /></td>
						</tr>
					</table>
					<input type="hidden" id="hidId" name="hidId" />
				</form>
			</div>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" title="设置角色" style="width:600px;height:400px;padding:10px;"
            data-options="closed:true,
                buttons: [{
                    text:'保存',
                    iconCls:'icon-ok',
                    handler:dlgSave
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:dlgCancel
                }]
            ">
        <div id="divCBox"></div>
    </div>
	<script type="text/javascript">
		$(function() {
			$('#ulTree').tree({
				onClick : function(node) {
					$("#hidId").val(node.id);
					$("#selDepart").val(node.text);
					$("#department").val("");
				}
			});
			$("#btnAdd").click(function() {
				$("#form1").form("submit", {
					url : "../department!addDepartment",
					onSubmit : function() {
						return $(this).form('validate');
					},
					success : function(data) {
						alert(data);
						$("#ulTree").tree("reload");
					}
				});
			});
			$("#btnDel").click(function() {
				if (confirm("你确定要进行删除，如果有子部门的话，会连同子部门一起删除！")) {
					$("#form1").form("submit", {
						url : "../department!delDepartment",
						onSubmit : function() {
							if ($.trim($("#hidId").val()) == "") {
								alert("请选择要删除的部门！");
								return false;
							}
						},
						success : function(data) {
							alert(data);
							$("#ulTree").tree("reload");
						}
					});
				}
			});
			$("#btnUpdate").click(function() {
								if (confirm("你确定要进行修改？")) {
									$("#form1").form("submit",
													{
														url : "../department!updateDepartment",
														onSubmit : function() {
															if ($
																	.trim($(
																			"#selDepart")
																			.val()) == ""
																	|| $
																			.trim($(
																					"#hidId")
																					.val()) == "") {
																alert("请选择要修改的部门！");
																return false;
															}
														},
														success : function(data) {
															alert(data);
															$("#ulTree").tree(
																	"reload");
														}
													});}
							});
			$("#btnRole").click(function(){
				$('#dlg').dialog('open');
			});

		})
		var dlgSave=function(){
			 alert('ok');
			 $('#dlg').dialog('close');
		}
		var dlgCancel=function(){
			$('#dlg').dialog('close');
		}
		
		function getRoleList(){
			
		}
	</script>
</body>
</html>