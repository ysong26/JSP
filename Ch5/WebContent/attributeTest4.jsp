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
	pageContext.setAttribute("pageScope","PageValue");
	request.setAttribute("requestScope", "requestvalue");
%>

<%=pageContext.getAttribute("pageScope") %><br>
<%=request.getAttribute("requestScope") %><br>
----------------------------------------------<br>
<jsp:include page="attributeTest5.jsp">
	<jsp:param name="name" value="홍길동"/>
	<jsp:param name="id" value="hong"/>
</jsp:include>

</body>
</html>