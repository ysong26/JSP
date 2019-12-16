<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pagefile=request.getParameter("page");
	if (pagefile==null){
		pagefile="newitem";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{ width:960px;
	border: 1px solid gray;
	margin:auto;}

</style>
</head>
<body>
<table>
	<tr>
		<td colspan="2"><jsp:include page="top.jsp"></jsp:include></td>
	</tr>

	<tr>
		<td><jsp:include page="left.jsp"></jsp:include></td>
		<td><jsp:include page='<%=pagefile+".jsp"%>'></jsp:include></td>
	</tr>
	
	<tr>
		<td colspan="2"><jsp:include page="bottom.jsp"></jsp:include>
	</tr>

</table>
</body>
</html>