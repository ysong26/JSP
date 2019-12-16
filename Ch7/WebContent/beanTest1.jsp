<%-- <%@page import="test.BeanTest"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% BeanTest beantest = new BeanTest(); %> --%>
<jsp:useBean id="beantest" class="test.BeanTest" scope="page"/>
<%-- <% beantest.setName("양현일"); %> --%>
<jsp:setProperty property="name" name="beantest" value="양현일"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%=beantest.getName() %> --%>
<jsp:getProperty property="name" name="beantest"/>
</body>
</html>