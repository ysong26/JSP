<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Calendar c=Calendar.getInstance();
	int hour=c.get(Calendar.HOUR_OF_DAY);
	int minute=c.get(Calendar.MINUTE);
	int second=c.get(Calendar.SECOND);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>현재시간은 <%=hour %>시 <%=minute %>분 <%=second %>초입니다.</h1>

<% if (hour>=12) { %>
	<h2>오후입니다.</h2>
<%  }
else{ %>
	<h2>오전입니다.</h2>
<%	}	%>
	
</body>
</html>