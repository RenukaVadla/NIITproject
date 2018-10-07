<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>Brand</th>
				<th>Unit Price</th>
				<th>Quantity</th>
				<th>Total Price</th>


			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cart.cartItem}" var="cartItem">
				<tr>
					<td>${cartItem.cartItemId[0].noOfProducts.product.product_brand}</td>
					<td>${cartItem.cartItemId[0].noOfProducts.product.product_price}</td>
						<td>${cartItem.quantity}</td>
					<td>${cartItem.cartItemId[0].noOfProducts.product.product_price * cartItem.quantity}</td>
					<td><a href="${contextPath}/customer/${cartItem.cartItem_id}"><input
							type="button" value="Delete"></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div>
		<table>
		<tr>
			<td>Number of items:</td>
			<td>${cart.noOfitems}</td>
		</tr>
		</table>
	</div>
</body>
</html>