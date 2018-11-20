<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style type="text/css">
.title {
	width: 30%;
	background-color: #CCC;
	font-weight: bold;
}

.content {
	width: 70%;
	background-color: #CBCFE5;
}

table {
	align-content: center;
	text-align: center;
}
</style>
<title>UserInfo</title>
</head>
<jsp:useBean id="regUser" class="entity.Users" scope="session"></jsp:useBean>
<body>
	<h1>用户信息</h1>
	<hr>
	<table style="width: 600px; padding: 0px; border: 1px;">
		<tr>
			<td class="title">用户名：</td>
			<td class="content">&nbsp;<jsp:getProperty property="username"
					name="regUser" /></td>
		</tr>
		<tr>
			<td class="title">密码：</td>
			<td class="content">&nbsp;<jsp:getProperty property="pass"
					name="regUser" /></td>
		</tr>
		<tr>
			<td class="title">性别：</td>
			<td class="content">&nbsp;<jsp:getProperty property="gender"
					name="regUser" /></td>
		</tr>
		<tr>
			<td class="title">E-mail：</td>
			<td class="content">&nbsp;<jsp:getProperty property="email"
					name="regUser" /></td>
		</tr>
		<tr>
			<td class="title">出生日期：</td>
			<td class="content">&nbsp;
			<%
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
				String date=sdf.format(regUser.getBirthday());
			%>
			<%= date %>
			</td>
		</tr>
		<tr>
			<td class="title">爱好：</td>
			<td class="content">&nbsp; 
				<%
 				String[] favorites = regUser.getFavorites();
 				for (String f : favorites) {
 				%> 
 				<%=f%>&nbsp;&nbsp;
 				<%
 				}
 				%>
			</td>
		</tr>
		<tr>
			<td class="title">自我介绍：</td>
			<td class="content">&nbsp;<jsp:getProperty property="introduce"
					name="regUser" /></td>
		</tr>
		<tr>
			<td class="title">是否介绍协议：</td>
			<td class="content">&nbsp;<jsp:getProperty property="flag"
					name="regUser" /></td>
		</tr>
	</table>
</body>
</html>