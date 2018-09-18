<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="login-box">
	<h2>Login with Username and Password</h2>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
<form name='loginForm'
		  action="<c:url value='adminloginprocess' />" method='POST'>
<table>
	<tr>
		<td>Email</td>
		<td><input path="admin_email"/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input path="admin_password"/></td>
	</tr>
	<tr>
		<td colspan='2'><input name="submit" type="submit"
				  value="submit" /></td>
	</tr>
</table>
</form>
</div>
</body>
</html>
