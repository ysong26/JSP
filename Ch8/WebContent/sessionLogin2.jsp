<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("id", request.getParameter("id"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인되었습니다.
로그인 아이디:<%=(String)session.getAttribute("id") %>
<a href="sessionLogout.jsp">로그아웃</a>
</body>
</html>