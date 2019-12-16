<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
String id=request.getParameter("id");
String pw=request.getParameter("password");
%>

<%
String str="성공";
Connection conn=null;
String sql="SELECT * FROM login where id=?;";
PreparedStatement pstmt = null;
ResultSet rs = null;
boolean login=false;
try{
	Context init=new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/aaa");
	conn=ds.getConnection();
	
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, id);
	rs=pstmt.executeQuery();
	
	if(rs.next()){
		if(rs.getString("password").equals(pw)) //;붙이면 문장끝나는거 조심
		login=true;
	} 
	
}catch(Exception e){
	str="실패";
	e.printStackTrace();
}finally{
	
	if(rs!=null) try{rs.close();}catch(Exception e){};
	if(pstmt!=null) try{pstmt.close();}catch(Exception e){};
	if(conn!=null) try{conn.close();}catch(Exception e){};
}

%>

<%if(login){%>
	로그인 성공
<%}else{ %>
	로그인 실패
<% } %>

</body>
</html>