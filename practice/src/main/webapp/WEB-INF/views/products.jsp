<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="margin-top: 30px">
		<div class="row">

			<c:forEach items="${productList}" var="product">

				<div class="card" style="width: 15rem">
					<img class="card-img-top" 
						src="<spring:url value="/resources/resource/products/${product.product_id }.jpg"></spring:url>"
						
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">${product.product_brand }</h5>
						<a href="${contextPath}/viewproduct/${product.product_id }"><button
								class="btn btn-success">View</button></a>
								<a href="${contextPath}/cust/${product.product_id }"><button
								class="btn btn-danger">Buy</button></a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>