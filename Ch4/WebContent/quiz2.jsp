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
for(int j=2; j<=9; j++) {
	for(int i=j; i<=9; i++) {%>
	<%=j %> * <%=i %> = <em><%=j*i %> </em><br>
	<% }
}	%>

</body>
</html>