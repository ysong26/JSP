	<%request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("email");
	String id=request.getParameter("address");
	String tel=request.getParameter("tel");
	
	session.setAttribute("email", name);
	session.setAttribute("address", id);
	session.setAttribute("tel", tel);
	%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<a href="attributeTest3.jsp">저장정보 확인</a>
</body>
</html>