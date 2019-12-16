<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
int sum=0;
for(int i=1; i<=100; i++) {
	if (i%2==0)
		sum+=i;
}
%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
1~100사이에 있는<br>
<em>짝수</em>들의 합은<br>
<font size=20px><%=sum %></font>입니다.
</body>
</html>