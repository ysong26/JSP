<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	form{ width:960px;
	border: 1px solid gray;
	margin:auto;}
</style>
</head>

<body>

<form colspan="2"><jsp:include page="top2.jsp"></jsp:include>
<% int a=Integer.parseInt(request.getParameter("num1")); %>
<% int b=Integer.parseInt(request.getParameter("num2")); 
	int num=Integer.parseInt(request.getParameter("dap")); 
	int sub=a-b;%>
	<form action="sub1.jsp" method="post">
		<center><b>빼기</b><br/>
			<input type="text" name="num1" value="<%=a %>">
			-<input type="text" name="num2" value="<%=b %>">
			=<input type="text" name="num3" value="<%=sub %>"><br><br>
			<input type="submit" value="계산">
		</center>
	</form>
</body>
</html>