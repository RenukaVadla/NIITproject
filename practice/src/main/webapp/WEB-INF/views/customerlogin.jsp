<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%-- <div class="row">
<spring:form action="customer/customerloginprocess" type="POST" modelAttribute="customer">
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
</div> --%>
<div id="login-box">
	<h2>Login with Username and Password</h2>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
<form name='loginForm'
		  action="customer/customerloginprocess"  method='POST'>
 <table>
 <tr>
 	<td><label>Email</label></td>
	<td><input type="text" name="customer_email"/></td>
</tr>
<tr>

	<td><label>Password</label></td>
	<td><input type="password" name="customer_password"/></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" class="btn" value="Submit"></td>
</tr>
</table>
</form>
</div>

</body>
</html>