<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>LoginSuccess</title>
</head>
<body style="text-align: center;">
	<h1>登陆成功</h1>
	<hr>
	<p>
		欢迎您<%= session.getAttribute("username") %>,登陆成功！
	</p>
</body>
</html>