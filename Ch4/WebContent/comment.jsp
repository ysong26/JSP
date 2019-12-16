<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 이건 HTML 주석입니다. -->
<%-- 이건 JSP 주석입니다. --%>
1~10 사이의 랜덤수는
<%
	int a;
	Random random = new Random();
	a=random.nextInt(10)+1;
%>
<%=a %>
</body>
</html>