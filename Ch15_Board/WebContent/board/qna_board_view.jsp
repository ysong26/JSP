<%@page import="vo.BoardBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	vo.BoardBean article=(vo.BoardBean)request.getAttribute("boardbean");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>글 내용 상세보기</h2>
제목:<%=article.getBoard_subject() %> 첨부파일:<%=article.getBoard_file() %>
<br>
<%=article.getBoard_content() %><br><br>
[답변]
<a href="qna_board_modify.jsp">[수정]</a>
[삭제]
<a href="boardList.bo">[목록]</a>
</body>
</html>