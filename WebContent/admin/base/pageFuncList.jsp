<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面功能列表</title>
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
							<td align="right" width="120">已有功能：</td>
							<td><input type="hidden" id="hidId" name="hidId" /> <select
								name="existFunc" size="10" id="existFunc" style="width: 60%;">
							</select></td>
						</tr>
						<tr>
							<td align="right">新功能：</td>
							<td><input type="text" id="funcName" name="funcName"
								class="easyui-validatebox" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="button"
								value="添加" id="btnAdd" name="btnAdd" />&nbsp;&nbsp;<input
								type="button" value="删除" id="btnDel" name="btnDel" /></td>
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
					updateFunc(node.id);
				}
			});
			$("#btnAdd").click(function() {
				if ($.trim($("#funcName").val()) == "") {
					alert("请输入新功能！");
					return false;
				}
				$.ajax({
					url : "../pagefunc!addFunc",
					type : "post",
					data : {
						"pageFunc.pageId" : $("#hidId").val(),
						"pageFunc.func" : $("#funcName").val()
					},
					dataType : "text",
					success : function(data) {
						if (data == "success") {
							alert("添加成功！");
							updateFunc($("#hidId").val());
						} else {
							alert("添加失败！");
						}
					}
				});
			});
			$("#btnDel").click(function(){
				if(confirm("你确定进行删除操作？")){
					$.ajax({
						url : "../pagefunc!delFunc",
						type : "post",
						data : {
							id:$("#existFunc").val()
						},
						dataType : "text",
						success : function(data) {
							if (data == "success") {
								alert("删除成功！");
								updateFunc($("#hidId").val());
							} else {
								alert("删除失败！");
							}
						}
					});
				}
			});
		})
		
		function updateFunc(id){
			$.ajax({
				url : "../pagefunc!getFuncList",
				type : "post",
				data : {
					"pageFunc.pageId" : id
				},
				dataType : "json",
				success : function(data) {
					$("#existFunc").empty();
					for(var i=0;i<data.length;i++){
						$("#existFunc").append("<option value='"+data[i].id+"'>"+data[i].func+"</option>");
					}
				}
			});
		}
	</script>
</body>
</html>