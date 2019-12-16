<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String name; //세션값 저장
	if(session.getAttribute("name")!=null)
		name=(String)session.getAttribute("name");
	else
		name="세션의 name값 없음.";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>세션 테스트</h2>
<input type="button" value="세션값 저장" onclick="location.href='sessionSet.jsp'">
<input type="button" value="세션값 삭제" onclick="location.href='sessionDel.jsp'">
<input type="button" value="세션 초기화" onclick="location.href='sessionInvalidate.jsp'">
<br><br>
현재 세션의 name값: <u><%=name %></u>
</body>
</html>