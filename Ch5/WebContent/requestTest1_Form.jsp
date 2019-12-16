<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1{text-align: center;}
table{
margin:auto;
width:400px;
border:1px solid gray;}

</style>
</head>
<body>
<h1>Request 예제입니다.</h1>
<form action="request1.jsp" method="post">

<table>
<tr>
<td>이름</td>
<td><input type="text" name="name"></td>
</tr>

<tr>
<td>성별</td>
<td>
 남<input type="radio" name="gender" value="male">
여<input type="radio" name="gender" value="female">
</td>
</tr>

<tr>
 <td>취미</td>
 <td>
  독서<input type="checkbox" name="hobby" value="독서" >
   게임<input type="checkbox" name="hobby" value="게임" checked >
 TV시청<input type="checkbox" name="hobby" value="TV시청">
  축구<input type="checkbox" name="hobby" value="축구">
  기타<input type="checkbox" name="hobby" value="기타">
    </td>
   </tr>

<tr>
<td>
 <input type="submit" value="전송">
</td>
 </tr>
 
 </table>
</form>
</body>
</html>