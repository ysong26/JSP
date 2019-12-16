<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String language="korea";
    String cookie=request.getHeader("Cookie");
    if(cookie!=null){
    	Cookie[] cookies= request.getCookies();
    	
    	for(int i=0; i<cookies.length; i++){
    		if (cookies[i].getName().equals("language")){
    			language=cookies[i].getValue();
    		}
    	}
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(language.equals("korea")){ %>
	안녕하세요.	
<%}else{ %>
	hello
	<%} %>
<form action="cookieExample2.jsp" method="get">
<input type="radio" name="language" value="korea"
<%if(language.equals("korea")){%> checked<%} %>>한국어 페이지

<input type="radio" name="language" value="english"
<%if(language.equals("english")){%>checked<%} %>>영어페이지
<input type="submit" value="설정">

</form>
</body>
</html>