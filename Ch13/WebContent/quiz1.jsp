<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int a=(int)(Math.random()*((15-5)+1))+5;
int b=(int)(Math.random()*((15-5)+1))+5;
%>
<H2>더하기</H2>
<form action="quiz2.jsp" method="get">
<strong><%=a%>+<%=b%></strong>=<input type="text" name="hap"><br>
<input type="hidden" value="<%=a %>" name="count1">
<input type="hidden" value="<%=b %>" name="count2">
<input type="hidden" value="<%=a+b %>" name="result">

<input type="submit" value="확인">
</form>
</body>
</html>