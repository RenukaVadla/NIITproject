<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spring:form action="editprofile" method="POST" modelAttribute="user">
<spring:input path="user_id" type="hidden"/>
<table>
<tr>
<td>User Name</td>
<td><spring:input path="user_name"/></td>
</tr>
<tr>
<td>User Email</td>
<td><spring:input path="user_email"/>
</tr>
<tr>
<td>Mobile</td>
<td><spring:input path="user_mobile"/>
</tr>
<tr>
<td>Password</td>
<td><spring:input path="user_password" type="hidden"/></td>
</tr>
<tr>
			<td>Role</td>
			<td><spring:radiobutton path="role" value="customer"/>Customer</td>
			<td><spring:radiobutton path="role" value="vendor"/>Vendor</td>
			<td><spring:radiobutton path="role" value="admin"/>Admin</td>
		</tr>
<tr>
<td><input type="submit" value="Submit"></td>
</tr>
</table>
</spring:form>
</body>
</html>