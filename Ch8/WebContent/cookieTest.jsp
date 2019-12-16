<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("name","hongkildong");
	cookie.setMaxAge(600);
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
쿠키이름:<%=cookie.getName() %><br>
쿠키 값:<%=cookie.getValue() %><br>
쿠기 기간:<%=cookie.getMaxAge() %>초

<a href="cookieTest2.jsp">쿠키값 테스트</a>

</body>
</html>