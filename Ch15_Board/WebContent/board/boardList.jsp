<%@page import="java.util.ArrayList"%>
<%@page import="vo.BoardBean"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ArrayList<vo.BoardBean> articleList =(ArrayList<vo.BoardBean>) request.getAttribute("articleList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>글 목록 <a href="boardWriteForm.bo">게시판글쓰기</a></h2>
<table>
<tr>
	<td>번호</td>
	<td>제목</td>
	<td>작성자</td>
	<td>날짜</td>
	<td>조회수</td>
</tr>

<%for(int i=0; i<articleList.size(); i++){ %>
	<tr>
		<td><%=articleList.get(i).getBoard_num()%></td>
		<td>
		<%for(int j=0; j<articleList.get(i).getRe_lev(); j++){%>
			&nbsp;&nbsp;
		<% } %>
		<a href="boardDetail.bo?num=<%=articleList.get(i).getBoard_num()%>"><%=articleList.get(i).getBoard_subject()%></a></td>
		<td><%=articleList.get(i).getBoard_name()%></td>
		<td><%=articleList.get(i).getBoard_date()%></td>
		<td><%=articleList.get(i).getBoard_readcount()%></td>
	</tr>
<%} %>



</table>
</body>
</html>