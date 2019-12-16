<%@page import="java.sql.*"%>
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
String connect="성공";
String sql="INSERT INTO member (id, name) VALUES ('ccc', '김산수');";
Statement stmt=null;
try{
	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mariadb://192.168.0.150:3307/testDB",
			"java","java");
	stmt=conn.createStatement();
	stmt.executeUpdate(sql);
	conn.close();
}catch(Exception e){
	connect="실패";
	e.printStackTrace();
}
%>

<%=connect %>

</body>
</html>