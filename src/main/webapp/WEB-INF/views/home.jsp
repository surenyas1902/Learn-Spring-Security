<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learning Spring Security</title>
</head>
<body>
	<h2>
		My Home Page
	</h2>
	
	<p>
		Welcome to the Surendrian Company Home Page!
	</p>
	
	<!-- Logout button -->
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<button type="submit" value="Logout">Logout</button>
	</form:form>
</body>
</html>