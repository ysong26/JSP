<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="attributeTest2.jsp" method="post">
<table>

<tr>
	<td colspan="2">session에 저장할 내용들</td>
</tr>

<tr>
	<td>e-mail주소</td><td><input type="text" name="email"></td>
</tr>

<tr>
	<td>집주소</td><td><input type="text" name="address"></td>
</tr>

<tr>
	<td>전화번호</td><td><input type="text" name="tel"></td>
</tr>

<tr>
	<td colspan="2"><input type="submit" value="전송"></td>
</tr>

</table>
</form>

</body>
</html>