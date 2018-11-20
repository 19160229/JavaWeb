<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>九九乘法表</title>
</head>
<body>
	<%!
	String printMultiTable(){
		String s="";
		for(int i=1;i<10;i++){
			for(int j=1;j<=i;j++){
				s=s+j+" * "+i+" = "+i*j+"&nbsp;&nbsp;&nbsp;&nbsp";
			}
			s+="<br />";
		}
		return s;
	}
	%>
	<h1>九九乘法表</h1>
	<hr>
	<%= printMultiTable() %>
</body>
</html>