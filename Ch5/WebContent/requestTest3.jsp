<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서버도메인용: <%=request.getServerName() %> <br>
서버포트번호: <%=request.getServerPort() %> <br>
요청 URL: <%=request.getRequestURL() %> <br>
요청 URI: <%=request.getRequestURI() %> <br>
요청 쿼리: <%=request.getQueryString() %> <br>
클라이언트 호스트명: <%=request.getRemoteHost() %> <br>
클라이언트 IP주소: <%=request.getRemoteAddr() %> <br>
프로토콜: <%=request.getProtocol() %> <br>
요청방식: <%=request.getMethod() %> <br>
컨텍스트 경로: <%=request.getContextPath() %>
쿠키: <%
	Cookie[] cookie=request.getCookies();
	for(Cookie c: cookie){ %>
		<%=c.getName()%>
		<%=c.getValue()%><br>
	<%}%>
</body>
</html>