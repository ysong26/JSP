<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
int sum=0;
for(int i=1; i<=1000; i++) {
	if (i%3==0 || (i%5==0))
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
1~1000사이에 있는<br>
3또는 5의 배수를<sup>(중복제거)</sup> <font size=20px>모두</font><br>
더하면<br>
<font color="red"><ins><%=sum %></ins></font>입니다.
</body>
</html>