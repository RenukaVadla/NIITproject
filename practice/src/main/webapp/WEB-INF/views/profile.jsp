<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spring:form >
<table>
<tr>
	<td><label> Vendor Name</label></td>
	<td>${vendor.vendor_name} </td>
</tr>
<tr>
<td><label>Email</label></td>
 <td>${vendor.vendor_email }</td>
 </tr>
 <tr>
 <td><label>Mobile</label></td>
 <td>${vendor.vendor_mobile }</td>
 </tr>
 <tr>
 <td>Company</td>
 <td>${vendor.company_name }</td>
 </tr>
 <tr>
 <td><label>Password</label></td>
<td>${vendor.vendor_password } </td>
</tr>
<tr>
<td colspan="2"><a href="editprofile" type="button">Edit Profile</a></td>
</tr>
</table>
 <!-- <br><input type="submit" value="Submit"> -->
 </spring:form>
</body>
</html>