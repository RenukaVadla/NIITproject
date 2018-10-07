<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
<tr>
	<td><label> Name</label></td>
	<td>${customer.customer_name} </td>
</tr>
<tr>
<td><label>Email</label></td>
 <td>${customer.customer_email }</td>
 </tr>
 <tr>
 <td><label>Mobile</label></td>
 <td>${customer.customer_mobile }</td>
 </tr>
 <tr>
 <td>Company</td>
 <td>${customer.active }</td>
 </tr>
 <tr>
 <td><label>Password</label></td>
<td>${customer.customer_password } </td>
</tr>
<tr>
<td colspan="2"><a href="editprofile" type="button">Edit Profile</a></td>
</tr>
</table>
</body>
</html>