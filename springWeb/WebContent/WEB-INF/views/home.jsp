<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Spring Intro site</title>
</head>
<body>

	<h1>Welcome</h1>

	<sf:form method="POST" modelAttribute="user" action="submit">
		<sf:label path="firstname">First name</sf:label>
		<sf:input path="firstname" id="first_name" size="30" />
		<br />
		<sf:label path="lastname">Last name</sf:label>
		<sf:input path="lastname" id="last_name" size="30" />
		<input type="submit" name="commit" value="Save" />
	</sf:form>

</body>
</html>