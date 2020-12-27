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
	<form:form action="userRecovery" method="GET">
		<table border="1">
			<tr><th>Forgot Password</th></tr>
			<tr>
				<td>Email Id</td>
				<td><form:input path="emailId"/></td>
			</tr>
			<tr>
				<td colspan="1"></td>
				<td><input type="submit" value="submit"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>