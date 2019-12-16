<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1{text-align: center;}
table{
margin:auto;
width:400px;
border:1px solid gray;}

</style>
</head>
<body>
이름은 <%=request.getParameter("name") %>
<%
	if(request.getParameter("gender").equals("male")) {%>
	남자
	
<% }else {%>
	여자
	<% }%>
	
취미는
<%
	String[] hobby=request.getParameterValues("hobby");
	for(int i=0; i<hobby.length; i++){
%>
	<%=hobby[i] %> &nbsp;&nbsp;
<% } %>


</body>
</html>