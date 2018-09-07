<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spring:form action="signup" method="POST" modelAttribute="user">
	<table>
		<tr>
			<td>User Name</td>
			<td><spring:input path="user_name" /></td>
		</tr>
		<tr>
			<td>User Email</td>
			<td><spring:input path="user_email" /></td>
		</tr>
		<tr>
		<td> User Mobile</td>
		<td><spring:input path="user_mobile"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><spring:input path="user_password"/></td>
		</tr>
		<tr>
			<td>Confirm password</td>
			<td><spring:input path="cofirmpassword"/></td>
		</tr>
		<tr>
			<td>Role</td>
			<td><spring:radiobutton path="role" value="customer"/>Customer</td>
			<td><spring:radiobutton path="role" value="vendor"/>Vendor</td>
			<td><spring:radiobutton path="role" value="admin"/>Admin</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit"></td>
		</tr>
	</table>
	</spring:form>
	
	 
</body>
</html>