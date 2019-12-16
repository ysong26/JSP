<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int a=Integer.parseInt(request.getParameter("count1"));
	int b=Integer.parseInt(request.getParameter("count2"));	
	int hap=Integer.parseInt(request.getParameter("hap"));
	int result=Integer.parseInt(request.getParameter("result"));
	int c; 
	%>
	
	정답은<%=result%>입니다.<br>
	
		<% if(hap==result){%>
		<strong>정답입니다<br></strong>
		<%c=1; %>
		<br>
		<% } else {%>
		<strong>오답입니다<br></strong>
		<%c=0; %>
		<% } %>
		
		<a href="quiz3.jsp">오답문제확인<br></a>
	
<%
String str="DB성공";
Connection conn=null;
String sql="INSERT INTO number (num1, num2, hap) VALUES (?, ?, ?);";

PreparedStatement pstmt = null;
try{
	Context init=new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/aaa");
	conn=ds.getConnection();
	pstmt=conn.prepareStatement(sql);
	pstmt.setInt(1,a);
	pstmt.setInt(2,b);
	pstmt.setInt(3,c);
	if(pstmt.executeUpdate()!=0){
		System.out.println("등록성공");
	}
}catch(Exception e){
	str="실패";
	e.printStackTrace();
}finally{
	pstmt.close();
	conn.close();
}
%>
<%=str %>
</body>
</html>