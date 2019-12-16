<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("name");
	String id=request.getParameter("id");
	application.setAttribute("name", name);
	application.setAttribute("id", id);
	%>
</body>
</html>