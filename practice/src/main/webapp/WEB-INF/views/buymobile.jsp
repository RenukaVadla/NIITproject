<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head><link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<body>
<div class="bg">
<c:set value="${pageContext.request.contextPath }" var="contextPath"></c:set>
	<table>
	<tr>
		<td><img class="card-img-top" src="<spring:url value='/resources/resource/products/${mobile.product_id }.jpg'></spring:url>"
						></td>
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
</table>
<form action="${contextPath }/customer/addtocart" method="get">
	<table>
		<tr>
		<td><label>Product Id</label></td>
		<td><input type="hidden" name="product_id" value="${mobile.product_id }"></td>
		</tr>
		<tr>
		<td><label>No Of Items</label></td>
		<td><input type="number" name="noOfProducts"></td>
		</tr>
		<tr>
		<td><input type="submit" value="Buy now"></td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>

