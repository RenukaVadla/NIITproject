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
<div class="row">
<spring:form action="customerloginprocess" type="POST" modelAttribute="customer">
<table>
 <tr>
 	<td><label>Email</label></td>
	<td><spring:input path="customer_email"/></td>
</tr>

<tr>

	<td><label>Password</label></td>
	<td><spring:input type="password" path="customer_password"/></td>
</tr>

</table>
<tr>
<td colspan="2"><input type="submit" class="btn" value="Submit"></td>
<tr> 
</spring:form> 	
</div>
</body>
</html>