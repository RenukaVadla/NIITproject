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
<springform:form action="mobile" method="POST" modelAttribute="mobile">
<springform:input path="product_brand" id="product_brand"/>
<springform:input path="mobile_ram" id="mobile_ram"/>
<springform:input path="mobile_series" id="mobile_series"/>
<springform:input path="mobile_storage" id="mobile_storage"/>
<springform:input path="warrenty" id="warrenty"/>
<springform:button type="submit" value="Submit">Save</springform:button>
</springform:form>
</body>
</html>