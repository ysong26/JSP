<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
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
String str="성공";
try{
	Context init=new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/aaa");
	Connection conn=ds.getConnection();
}catch(Exception e){
	str="실패";
	e.printStackTrace();
}
%>

<%=str %>
</body>
</html>