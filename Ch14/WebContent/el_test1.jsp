<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   session.setAttribute("test", "Session Test");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="el_test2" method="post">
	이름: <input type="text" name="name" value="홍길동">
	<input type="submit" value="입력">
</form>
</body>
</html>