<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Spring Intro site</title>
</head>
<body>


<c:choose>
	<c:when test="${empty user.firstname}">
		<H1><marquee>You are not Welcome HERE!</marquee></H1>
	</c:when>
	<c:otherwise>
		<h1>Welcome</h1>
		${user.firstname} ${user.lastname}
	</c:otherwise>
</c:choose>

</body>
</html>