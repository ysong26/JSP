<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
JSP버전: <%=application.getMajorVersion() %><br>
컨테이너 정보: <%=application.getServerInfo() %><br>
실제 웹어플리케이션 경로: <%=application.getRealPath("/") %>
</body>
</html>
