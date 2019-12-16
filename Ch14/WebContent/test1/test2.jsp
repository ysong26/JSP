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
<% 
int num1=Integer.parseInt(request.getParameter("num1"));
int num2=Integer.parseInt(request.getParameter("num2"));
	for(int i=num1; i<=num2; i++){
%>
	<%=i %>
<% } %>
</body>
</html>