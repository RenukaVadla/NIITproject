<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <spring:url value='/resources/resource/products/${mobile.product_id}.jpg'></spring:url>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<c:set value="/resources/resource/products" var="products"/>
</head>
<body>
<c:set value="${pageContext.request.contextPath }" var="contextPath"></c:set>
	<table>
	<tr>
		<td><img class="card-img-top" src="${products}/${mobile.product_id}.jpg"></td>
	</tr>
	<tr>
		<td>Series</td>
		<td>${mobile.mobile_series }</td>
	</tr>
	<tr>
		<td>Ram</td>
		<td>${mobile.mobile_ram}</td>
	</tr>
	<tr>
		<td>Storage</td>
		<td>${mobile.mobile_storage }</td>
	</tr>
	<tr>
		<td>Brand</td>
		<td>${mobile.product_brand }</td>
	</tr>
	<tr>
		<td>Warrenty</td>
		<td>${mobile.warrenty }</td>
	</tr>
	<tr>
		<td>price</td>
		<td>${mobile.product_price }</td>
	</tr>
	<tr>
		<td colspan="2"><a href="${contextPath}/buy/${mobile.product_id}"><button
								class="btn btn-danger">Buy</button></a></td>
	</tr>
</table>
	
</body>
</html>