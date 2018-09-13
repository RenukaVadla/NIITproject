<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<springform:form action="mobile" method="POST" modelAttribute="mobile" enctype="multipart/form-date">
<table>
	<tr>
		<td><label>Brand</label></td>
		<td><springform:input path="product_brand" id="product_brand"/></td>
	</tr>
	<tr>
		<td><label>Ram</label></td>
		<td><springform:input path="mobile_ram" id="mobile_ram"/></td>
	</tr>
	<tr>
		<td><label>Series</label></td>
		<td><springform:input path="mobile_series" id="mobile_series"/></td>
	</tr>
	<tr>
		<td><label>Storage</label></td>
		<td><springform:input path="mobile_storage" id="mobile_storage"/></td>
	</tr>
	<tr>
		<td>Warrenty</td>
		<td><springform:input path="warrenty" id="warrenty"/></td>
	</tr>
	<tr>
		<td>Image</td>
		<td><springform:input path="image" type="file" id="image"/></td>
	</tr>
	<springform:button type="submit" value="Submit">Save</springform:button>
</table>
</springform:form>
</body>
</html>