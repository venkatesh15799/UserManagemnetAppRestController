<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
<form:form action="loadUser" method="GET" modelAttribute="userDetails">
<table border="1">
	<tr>
	<td>User Name</td>
	<td><form:input path="userName"/></td>
	</tr>
	<tr>
	<td>Password</td>
	<td><form:input path="password"/></td>
	</tr>
	<tr>
	<td></td>
	<td><input type="submit" value="submit"/></td>
	</tr>
</table>
</form:form>
<a href="userRecovery">ForgotPassword</a>
<a href="userRegister">Sign Up</a>

</body>
</html>