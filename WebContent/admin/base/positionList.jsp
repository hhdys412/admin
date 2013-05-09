<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>职位列表</title>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/jquery.easyui.js"></script>
<script type="text/javascript" src="../../js/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="../../css/easyui/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../css/easyui/icon.css">
<link rel="stylesheet" type="text/css" href="../../css/style.css">
<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}
</style>
</head>
<body>
	<div class="divpadding">
		<table id="dg" class="easyui-datagrid" url="position!getList"
			toolbar="#toolbar" fitColumns="false" rownumbers="true"
			data-options="onBeforeEdit:beforeEdit,onAfterEdit:afterEdit,onCancelEdit:cancelEdit">
			<thead>
				<tr>
					<th width="200" data-options="field:'name',editor:{type:'text'}">职位</th>
					<th width="100" data-options="field:'action',formatter:format">操作</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="newUser()">添加</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="destroyPosition()">删除</a>
		</div>

		<div id="dlg" class="easyui-dialog" style="padding: 10px 20px"
			closed="true" buttons="#dlg-buttons">
			<div class="ftitle">添加职位信息</div>
			<form id="fm" method="post" novalidate>
				<div class="fitem">
					<label>职位名称:</label> <input name="name" id="name"
						class="easyui-validatebox" required="true">
				</div>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" onclick="saveUser()">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
		<script type="text/javascript">
			var beforeEdit = function(index, row) {
				row.editing = true;
				updateActions(index);
			}
			var afterEdit = function(index, row) {
				row.editing = false;
				updateActions(index);
				submitChange();
			}
			var cancelEdit = function(index, row) {
				row.editing = false;
				updateActions(index);
			}
			function updateActions(index) {
				$('#dg').datagrid('updateRow', {
					index : index,
					row : {}
				});
			}
			var url;
			function newUser() {
				$('#dlg').dialog('open').dialog('setTitle', '添加职位');
				$('#fm').form('clear');
				url = 'save_user.php';
			}
			function saveUser() {
				$('#fm').form('submit', {
					url : "position!addPosition",
					onSubmit : function() {
						return $(this).form('validate');
					},
					success : function(data) {
						var result = eval('(' + data + ')');
						if (result.success == false) {
							$.messager.show({
								title : 'Error',
								msg : result.msg
							});
						} else {
							$('#dlg').dialog('close'); // close the dialog  
							$('#dg').datagrid('reload'); // reload the user data  
						}
					}
				});
			}
			function destroyPosition() {
				var ids = "";
				var rows = $('#dg').datagrid('getSelections');
				for ( var i = 0; i < rows.length; i++) {
					ids += rows[i].id + ",";
				}
				if (rows.length > 0) {
					ids = ids.substring(0, ids.length - 1);
					$.messager.confirm('删除', '你确定要进行删除操作', function(r) {
						if (r) {
							$.post('position!delPosition', {
								id : ids
							}, function(result) {
								if (result.success) {
									alert(result.msg);
									$('#dg').datagrid('reload'); // reload the user data  
								} else {
									$.messager.show({ // show error message  
										title : '出错',
										msg : "删除失败"
									});
								}
							}, 'json');
						}
					});
				}
			}
			var format = function format(value, row, index) {
				if (row.editing) {
					return "<a href='' onclick='return saverow(this)'>保存</a>&nbsp;&nbsp;<a href='' onclick='return cancelrow(this)'>取消</a>";
				} else {
					return "<a href='' onclick='return editrow(this)'>编辑</a>";
				}
			}
			function getRowIndex(target) {
				var tr = $(target).closest('tr.datagrid-row');
				return parseInt(tr.attr('datagrid-row-index'));
			}
			function editrow(target) {
				$('#dg').datagrid('beginEdit', getRowIndex(target));
				return false;
			}
			function saverow(target) {
				$('#dg').datagrid('endEdit', getRowIndex(target));
				return false;
			}
			function cancelrow(target) {
				$('#dg').datagrid('cancelEdit', getRowIndex(target));
				submitChange();
				return false;
			}

			function submitChange() {
				var row = $("#dg").datagrid("getChanges");
				if (row.length > 0) {
					$.ajax({
						url : "position!updatePosition",
						type : "post",
						data : {
							id : row[0].id,
							position : row[0].name
						},
						dataType : "json",
						success : function(data) {
							alert(data.msg);
						}
					});
				}
				$('#dg').datagrid('acceptChanges');
			}
		</script>
	</div>
</body>
</html>