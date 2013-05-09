<%@page import="com.hhdys.util.CookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CookieUtil cookie = new CookieUtil(request, response);
	cookie.removeCookie("username");
	cookie.removeCookie("password");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退出登录</title>
<script type="text/javascript">
	window.location = "loginAdmin.jsp";
</script>
</head>
<body>退出登录
</body>
</html>