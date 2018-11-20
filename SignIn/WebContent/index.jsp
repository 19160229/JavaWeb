<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sign In</title>
</head>
<body>
	<h1>登陆</h1>
	<hr>
	<form method="post" action="login.jsp">
		<p>
			<label for="username">用户名</label>
			<input type="text" name="username" value="">
		</p>
		<p>
			<label for="password">密码</label>
			<input type="password" name="password" value="">
		</p>
		<p>
			<input type="submit" value="登陆">
		</p>
	</form>
</body>
</html>