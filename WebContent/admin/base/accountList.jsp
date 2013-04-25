<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
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
		<table id="dg" class="easyui-datagrid" url="login!showList"
			toolbar="#toolbar" pagination="true" fitColumns="true"
			rownumbers="true">
			<thead>
				<tr>
					<th field="username" width="80">用户名</th>
					<th field="name" width="80">姓名</th>
					<th field="sex" width="80">性别</th>
					<th field="age" width="80">年龄</th>
					<th field="position" width="80">职位</th>
					<th field="role" width="80">角色</th>
					<th field="lastLoginTime">上次登录时间</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="newUser()">添加</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
		</div>

		<div id="dlg" class="easyui-dialog" style="padding: 10px 20px"
			closed="true" buttons="#dlg-buttons">
			<div class="ftitle">User Information</div>
			<form id="fm" method="post" novalidate>
				<div class="fitem">
					<label>First Name:</label> <input name="firstname"
						class="easyui-validatebox" required="true">
				</div>
				<div class="fitem">
					<label>Last Name:</label> <input name="lastname"
						class="easyui-validatebox" required="true">
				</div>
				<div class="fitem">
					<label>Phone:</label> <input name="phone">
				</div>
				<div class="fitem">
					<label>Email:</label> <input name="email"
						class="easyui-validatebox" validType="email">
				</div>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" onclick="saveUser()">Save</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
		</div>
		<script type="text/javascript">
			var url;
			function newUser() {
				$('#dlg').dialog('open').dialog('setTitle', 'New User');
				$('#fm').form('clear');
				url = 'save_user.php';
			}
			function editUser() {
				var row = $('#dg').datagrid('getSelected');
				if (row) {
					$('#dlg').dialog('open').dialog('setTitle', 'Edit User');
					$('#fm').form('load', row);
					url = 'update_user.php?id=' + row.id;
				}
			}
			function saveUser() {
				$('#fm').form('submit', {
					url : url,
					onSubmit : function() {
						return $(this).form('validate');
					},
					success : function(result) {
						var result = eval('(' + result + ')');
						if (result.errorMsg) {
							$.messager.show({
								title : 'Error',
								msg : result.errorMsg
							});
						} else {
							$('#dlg').dialog('close'); // close the dialog  
							$('#dg').datagrid('reload'); // reload the user data  
						}
					}
				});
			}
			function destroyUser() {
				var ids = "";
				var rows = $('#dg').datagrid('getSelections');
				for ( var i = 0; i < rows.length; i++) {
					ids += rows[i].id + ",";
				}
				if (rows.length > 0) {
					ids = ids.substring(0, ids.length - 1);
					$.messager.confirm('Confirm', '你确定要进行删除操作', function(r) {
						if (r) {
							$.post('login!delAccount', {
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
		</script>
	</div>
</body>
</html>