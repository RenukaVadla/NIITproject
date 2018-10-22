<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


</head>
<body>
<c:set value="${pageContext.request.contextPath }" var="contextPath"></c:set>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="${contextPath }/customer/customerprofile">Profile</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${contextPath }/customer/customerindex">Home page</a>
    </li>
	<%-- <li class="nav-item">
    	<a class="nav-link" href="${contextPath }/">Home page</a>
    </li> --%>
  </ul>
</nav>
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
					<%-- <td>${cartItem.quantity}</td> --%>
					
					<form action="${contextPath }/customer/updatequantity" method="post">
						
					<td><input  type="number" name="quantity" value="${cartItem.quantity}">
					<input type="hidden" value="${cartItem.cartItem_id }" name="cartItem_id">
		             <input type="button" value="update"></td>
		
	                   </form>
				
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