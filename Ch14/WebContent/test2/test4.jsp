<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String id=request.getParameter("id");
	if(id.equals("aaa")){
		session.setAttribute("id", id);
	}else{
		session.removeAttribute("id");
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="test.5.jsp">로그인 확인</a>
</body>
</html>