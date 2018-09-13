<%@ page import="com.fdmgroup.servletExample.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		User currentUser = (User)request.getAttribute("ThisUser");
		String user = request.getParameter("Username").toString();
	%>
	
	Hello! <br>

	Welcome <%= user %> ! <br>
	Your permissions are: <%= currentUser.getPermission() %> 

	<%@ include file="fragment.jspf" %>
	
	<br> Total Hits So Far: 
	<%= ((Integer)request.getAttribute("Hits")).intValue() %> <br>
	<br>
	<br>
	
	<c:if test="${param.Username == 'Shana'}">
         Shana Is Logged in
	</c:if>
	
</body>
</html>