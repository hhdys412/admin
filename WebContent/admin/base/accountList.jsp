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
	<table id="dg" class="easyui-datagrid" url="../account!showList"
		toolbar="#toolbar" pagination="true" fitColumns="true"
		singleSelect="true" rownumbers="true">
		<thead>
			<tr>
				<th field="username" width="80">用户名</th>
				<th field="name" width="80">姓名</th>
				<th field="sex" width="80" formatter="formatSex">性别</th>
				<th field="age" width="80">年龄</th>
				<th field="department" width="80">部门</th>
				<th field="position" width="80">职位</th>
				<th field="role" width="80">角色</th>
				<th field="lastLoginTime">上次登录时间</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onClick="newUser()">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onClick="editUser()">编辑</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onClick="destroyUser()">删除</a>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="padding: 10px 20px; width: 400px;" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<div class="fitem">
				<label>用户名:</label> <input name="username" id="username"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>密&nbsp;&nbsp;码:</label> <input name="password" id="password"
					type="password" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>姓&nbsp;&nbsp;名:</label> <input name="name" id="name"
					required="true" class="easyui-validatebox">
			</div>
			<div class="fitem">
				<label>性&nbsp;&nbsp;别:</label> <input type="radio" name="sex"
					id="sexMan" value="0">男 <input type="radio" name="sex"
					id="sexWoman" value="1">女
			</div>
			<div class="fitem">
				<label>年&nbsp;&nbsp;龄:</label> <input name="age" id="age">
			</div>
			<div class="fitem">
				<label>角&nbsp;&nbsp;色:</label> <select id="role" name="role">
					<option value="-1">--请选择--</option>
				</select>
			</div>
			<div class="fitem">
				<label>职&nbsp;&nbsp;位:</label> <select id="position" name="position">
					<option value="-1">--请选择--</option>
				</select>
			</div>
			<div class="fitem">
				<label>部&nbsp;&nbsp;门:</label> <select id="department"
					class="easyui-combotree" style="width: 200px;"
					data-options="url:'../department!getDepartmentTree'"
					name="department">
					<option value="-1">--请选择--</option>
				</select>
			</div>
			<input type="hidden" id="hidCheck" name="hidCheck" value="1" />
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onClick="saveUser()" id="saveBtn">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onClick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
	<script type="text/javascript">
		$(function() {
			getRoleList();
			getPositionList();
			$("#username").blur(function() {
				$.ajax({
					url : "../account!checkUserName",
					type : "post",
					data : {
						userName : $(this).val()
					},
					dataType : "text",
					success : function(data) {
						if (data == "false") {
						//	alert("用户名已存在！");
							$("#hidCheck").val("0");
						}else{
							$("#hidCheck").val("1");
						}
					}
				});
			});
		});
		function newUser() {
			$('#dlg').dialog('open').dialog('setTitle', '添加用户');
			$('#fm').form('clear');
			$("#sexMan").attr("checked", "true");
			$("#role option:first").attr("selected", "selected");
			$("#position option:first").attr("selected", "selected");
			$('#department').combotree('setValue', "--请选择--");
			$("#saveBtn").attr("onClick", "saveUser()");
			$("#username").show();
			$("#spanUserName").remove();
		}
		function editUser() {
			var row = $('#dg').datagrid('getSelected');
			if (row) {
				$('#dlg').dialog('open').dialog('setTitle', '修改用户');
				$('#fm').form('load', row);
				$("#role option").each(function(index, element) {
					if ($(this).text() == row.role) {
						$(this).attr("selected", "selected");
					}
				});
				$("#position option").each(function(index, element) {
					if ($(this).text() == row.position) {
						$(this).attr("selected", "selected");
					}
				});
				$("#username").hide();
				$("#spanUserName").remove();
				$("#username").after("<span id='spanUserName'>"+$("#username").val()+"</span>");
				$('#department').combotree('setValue', row.department_id);
				$("#saveBtn").attr("onClick", "submitChange(" + row.id + ")");
			}
		}
		function submitChange(id) {
			if ($("#role").val() < 0) {
				alert("请选择角色！");
				return false;
			}
			if ($("#position").val() < 0) {
				alert("请选择职位！");
				return false;
			}
			if ($('#department').combotree('getValue') == "--请选择--") {
				alert("请选择部门！");
				return false;
			}
			$('#fm').form('submit', {
				url : "../account!editAccount?id=" + id,
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
						alert(result.msg);
						$('#dlg').dialog('close'); // close the dialog  
						$('#dg').datagrid('reload'); // reload the user data  
					}
				}
			});
		}
		function saveUser() {
			if ($("#hidCheck").val() == "0") {
				alert("用户名已存在！");
				return false;
			}
			if ($("#role").val() < 0) {
				alert("请选择角色！");
				return false;
			}
			if ($("#position").val() < 0) {
				alert("请选择职位！");
				return false;
			}
			if ($('#department').combotree('getValue') == "--请选择--") {
				alert("请选择部门！");
				return false;
			}
			$('#fm').form('submit', {
				url : "../account!addAccount",
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
						alert(result.msg);
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
				$.messager.confirm('删除', '你确定要进行删除操作', function(r) {
					if (r) {
						$.post('../account!delAccount', {
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
		function getRoleList() {
			$.ajax({
				url : "../account!getRoleList",
				type : "post",
				data : {

				},
				dataType : "json",
				success : function(data) {
					$("#role").html(
							"<option value='-1' selected>--请选择--</option>");
					for ( var i = 0; i < data.length; i++) {
						$("#role").append(
								"<option value='"+data[i].id+"'>"
										+ data[i].name + "</option>");
					}
				}
			});
		}

		function getPositionList() {
			$.ajax({
				url : "../account!getPositionList",
				type : "post",
				data : {

				},
				dataType : "json",
				success : function(data) {
					$("#position").html(
							"<option value='-1' selected>--请选择--</option>");
					for ( var i = 0; i < data.length; i++) {
						$("#position").append(
								"<option value='"+data[i].id+"'>"
										+ data[i].name + "</option>");
					}
				}
			});
		}

		var formatSex = function(value, row, index) {
			if (value == 0) {
				return "男";
			}
			return "女";
		}
	</script>
</body>
</html>