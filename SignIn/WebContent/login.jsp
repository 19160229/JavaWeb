<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals("admin")&&password.equals("admin"))
		{
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
		}
		else
			request.getRequestDispatcher("loginFail.jsp").forward(request, response);
	%>
</body>
</html>