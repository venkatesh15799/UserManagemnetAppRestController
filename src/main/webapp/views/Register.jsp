<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="C:\Users\santosh\.m2\repository\org\webjars\bootstrap\3.3.6\bootstrap-3.3.6.jar"></script>
<script src="C:\Users\santosh\.m2\repository\org\webjars\jquery\1.9.1\jquery-1.9.1.jar">
</script>

</head>
<body>
<form:form action="userRegister" method="POST" modelAttribute="userDetails">
<table border="1">
	<tr><td><a href="userRegister">User Registration Here</a></td></tr>
	<tr>
	<td>First Name</td>
	<td><form:input path="firstName"/></td>
	</tr>
	<tr>
	<td>Last Name</td>
	<td><form:input path="lastName"/></td>
	</tr>
	<tr>
	<td>Email Id</td>
	<td><form:input path="emailId"/></td>
	</tr>
	<tr>
	<td>Dob</td>
	<td><form:input path="phNo"/></td>
	</tr>
	<tr>
	<td>Gender</td>
	<td>Male<form:radiobutton path="gender" value="M"/></td>
	<td>Female<form:radiobutton path="gender" value="F"/></td>
	</tr>
	<tr>
	<td>Country</td>
	<td><form:select path="country" (click)="onCountryChange($event)"/>
	<form:option value="India"></form:option>
	<form:option value="USA"></form:option>
	</td>
	</tr>
	<tr>
	<td>State</td>
	<td><form:select path="state"/>
	<form:option value="Telangana"></form:option>
	<form:option value="Tamilnadu"></form:option>
	<form:option value="NewYork"></form:option>
	<form:option value="Washington"></form:option>
	</td>
	</tr>
	<tr>
	<td>City</td>
	<td><form:select path="city"/>
	<form:option value="hyderbad"></form:option>
	<form:option value="warangal"></form:option>
	<form:option value="vijayawada"></form:option>
	<form:option value="nelloor"></form:option>
	<form:option value="buffallo"></form:option>
	<form:option value="albany"></form:option>
	<form:option value="seattle"></form:option>
	<form:option value="taccoma"></form:option>
	</td>
	</tr>
	<tr>
	<td><input type="submit" value="reset"/></td>
	<td><input type="submit" value="register"/></td>
	</tr>
</table>
<a href="loaduser">Login</a>

</form:form>
</body>
</html>