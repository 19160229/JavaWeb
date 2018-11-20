<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
	<jsp:useBean id="user" class="com.po.User"></jsp:useBean>
	<jsp:useBean id="userDao" class="com.dao.UserDAO"></jsp:useBean>
	<jsp:setProperty property="*" name="user"/>
	<%
		request.setCharacterEncoding("utf-8");
		String isRemember[]=request.getParameterValues("isRemember");
		if(isRemember!=null&&isRemember.length>0){
			Cookie usernameCookie=new Cookie("username",user.getUsername());
			Cookie passwordCookie=new Cookie("password",user.getPassword());
			usernameCookie.setMaxAge(864000);	//设置cookie的有效期为10天
			passwordCookie.setMaxAge(864000);
			response.addCookie(usernameCookie);	
			response.addCookie(passwordCookie);
		}
		else{
			Cookie[] cookies=request.getCookies();
			if(cookies!=null&&cookies.length>0){
				for(Cookie c:cookies){
					if(c.getName().equals("username")||c.getName().equals("password")){
						c.setMaxAge(0);				//设置cookie的有效期为0s，即立即失效
						response.addCookie(c);		//重新保存cookie
					}
				}
			}
		}
		if(userDao.login(user)){
			session.setAttribute("username", URLDecoder.decode(user.getUsername()));
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
		}
		else
			response.sendRedirect("loginFail.jsp");
	%>
</html>