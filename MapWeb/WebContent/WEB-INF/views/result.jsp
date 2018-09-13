<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="routePlannerMVC.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="CSS/result.css">
		<title>Route Planner</title>
	</head>
<body>
	<div id=header><h1>FINAL DESTINATION.......</h1></div><br>
	<!-- <div class=header>FINAL DESTINATION</div> -->
		<div id=left>
			<form class=station name="route" action="RoutePlanning" method="post">
				<p>START</p><input type="text" name="startpos" value=""><br/>
				<p>END</p><input type="text" name="endpos" value=""><br/>
				<input id=submit type="submit" value="GO!">
			</form>
		</div>
		
	<div id=fromto>
		<div class=column id=leftStation><span class=detail><c:out value="${startpos}"></c:out></span></div>
		<div class=column id=arrow><img src="http://www.unipartautomotive.co.uk/styles/UPAC/red-arrow-pointing-right.jpg"></div>
		<div class=column id=rightStation><span class=detail><c:out value="${endpos}"></c:out></span></div>
	</div>
	
	<div id=output>
	<c:set var="i" value="1" />
		<c:forEach items="${resultarray}" var="item">
			<span class=detail><div id=route>Route <c:out value="${i}" />:<br/></div><c:out value="${item}" escapeXml="false"/></span><br/><br/>
			<c:set var="i" value="${i + 1}" />
		</c:forEach>
		<span class=detail><p><c:out value="${errormsg}"/></p></span>
	</div>
</body>
</html>