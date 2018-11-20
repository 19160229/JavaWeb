<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style type="text/css">
	body {
		text-align:center;
		font-size: 20px;
	}
</style>
<title>Login</title>
</head>
<%
	request.setCharacterEncoding("utf-8");
	String username="";
	String password="";
	Cookie[] cookies=request.getCookies();
	if(cookies!=null&&cookies.length>0){
		for(Cookie c:cookies){
			if(c.getName().equals("username")){
				username=URLDecoder.decode(c.getValue(),"utf-8");
			}else if(c.getName().equals("password")){
				password=URLDecoder.decode(c.getValue(),"utf-8");
			}
		}
	}
%>
<body>
	<h1>登陆</h1>
	<hr>
	<form action="login.jsp" method="post">
		<p>
			<label for="username">用户名</label>
			<input type="text" name="username"  value="<%= username %>" />
		</p>
		<p>
			<label for="password">密码</label>
			<input type="password" name="password" value="<%= password %>" />
		</p>
		<p>
			<input type="checkbox" name="isRemember">
			<label for="isRemember">十天内记住我的登陆状态</label>		
		</p>
		<p>
			<input type="submit" value="登陆"/>
			&nbsp;&nbsp;
			<input type="reset" value="取消"/>
		</p>
	</form>	
</body>
</html>