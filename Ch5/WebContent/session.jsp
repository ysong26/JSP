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
	session.setMaxInactiveInterval(10);
%>
세션 생성유무: <%=session.isNew() %><br>
세션 생성시간: <%=session.getCreationTime() %><br>
최종 접속시간<%=session.getLastAccessedTime() %><br>
세션ID: <%=session.getId() %>
</body>
</html>