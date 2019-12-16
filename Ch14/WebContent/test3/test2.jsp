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
<c:if test="${empty sessionScope.id}">
	로그인을 해주세요.
	<a href="test1.jsp">로그인</a>
</c:if>


<c:if test="${!empty sessionScope.id}">
	현재 로그인된 사용자는	${sessionScope.id}입니다
	<a href="test1.jsp">로그아웃</a>
</c:if>


</body>
</html>