<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <c:if test="${(check==-1 || empty check) && empty sessionScope.id}">
	<form action="LoginServlet.bo" method="post">
		id:<input type="text" name="id"><br>
		pw:<input type="password" name="pw"><br>
		<input type="submit" value="로그인">
	</form>
</c:if>
	
	<c:if test="${check==0 || (!empty sessionScope.id)}">
		${sessionScope.id}님 반갑습니다.
		<a href ="logoutServlet.bo">logout</a>
	</c:if>

	<c:if test="${check==-1}">
		!아이디, 패스워드를 확인해주세요.
	</c:if>

</body>
</html>