<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getParameter("num1") %>과<%=request.getParameter("num2") %>의
<br>더한값은
<%=Integer.parseInt(request.getParameter("num1"))+
Integer.parseInt(request.getParameter("num2"))%>입니다.<br>



<%=request.getParameter("num1") %>과<%=request.getParameter("num2") %>의
<br>더한값은
<% int a=Integer.parseInt(request.getParameter("num1")); %>
<% int b=Integer.parseInt(request.getParameter("num2")); 
	int sum=a+b;%>
	<%=sum %>입니다.

</body>
</html>