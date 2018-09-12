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
<springform:form action="laptop" method="POST" modelAttribute="laptop">
<table>
<tr>
<td><label>Product Brand</label></td>
<td><springform:input path="product_brand" id="product_brand"/></td>
</tr>
<tr>
<td><label>Processor</label></td>
<td><springform:input path="laptop_process" id="laptop_process"/></td>
</tr>
<tr>
<td><label>Series</label></td>
<td><springform:input path="laptop_series" id="laptop_series"/></td>
</tr>
<tr>
<td><label>Storage</label></td>
<td><springform:input path="laptop_storage" id="laptop_storage"/></td>
</tr>
<springform:button type="submit" value="Submit">Save</springform:button>
</table>
</springform:form>
</body>
</html>