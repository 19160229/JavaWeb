<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ServletTest</title>
</head>
<body>
	<h1>ServletTest</h1>
	<hr>
	<a href="Servlet/HelloServlet">Get方式请求HelloServlet</a><br>
	<form action="Servlet/HelloServlet" method="post">
		<input type="submit" value="Post方法请求HelloServlet"/>
	</form>
</body>
</html>