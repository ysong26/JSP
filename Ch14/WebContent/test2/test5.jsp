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
<c:choose>
	<c:when test="${empty sessionScope.id}">
		로그인 실패
	</c:when>
	<c:otherwise>
		${sessionScope.id}님 로그인 하셨습니다.
	</c:otherwise>
</c:choose>
</body>
</html>

