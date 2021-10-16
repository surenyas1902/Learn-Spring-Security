<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
	
	<hr />
	
	<!-- Add link to point to leaders... this is for the managers -->
	
	<security:authorize access="hasRole('MANAGER') || hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for Manager peoples)
		</p>
		
		<hr />
	</security:authorize>
	
	<!-- Add link to point to leaders... this is for the Admins -->
	
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT System Meeting</a>
			(Only for Admin peoples)
		</p>
		
		<hr />
	</security:authorize>
	
	<!-- Display Username and Role -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Roles: <security:authentication property="principal.authorities"/>
	</p>
	
	<hr />
	
	<!-- Logout button -->
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<button type="submit" value="Logout">Logout</button>
	</form:form>
</body>
</html>