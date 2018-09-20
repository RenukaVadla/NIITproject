<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/resource/resource/" var="image"></spring:url>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


<body>
	<div class="container-fluid">
		<nav class="navbar navbar-expand-xl bg-light navbar-light justify-content-center fixed-top">
			<ul class="nav nav-tabs">
				<li><a class="navbar-brand" href="#" id="text"><p class="font-weight-bold">E-Commerce.</p></a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbardrop"
					data-toggle="dropdown" font-color:red> Gadgets </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">MOBILE </a> <a
							class="dropdown-item" href="#">LAPTOP </a>
							
					</div></li>
				
				<li>
					<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbardrop"
					data-toggle="dropdown"> SignUp As </a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="vendorsignup">Vendor </a> <a
								class="dropdown-item" href="#">Admin</a> <a
								class="dropdown-item" href="customer">Customer</a>
						</div>
					</li>
				
					
    			<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbardrop"
					data-toggle="dropdown"> Login As </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="login">Vendor</a> 
						<a class="dropdown-item" href="adminlogin">Admin</a> <a
							class="dropdown-item" href="customerlogin">Customer</a>
					</div></li>
 				<form class="form-inline" action="search.jsp">
 					<input class="form-control mr sm-2" type="text"
						placeholder="Search">
					<button class="btn btn-success">Submit</button>
				</form>
				</ul>
		</nav>
	</div>


	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="container">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100" src="${image}/image1.jpg" alt="First slide" class="dimensions">
					<div class="carousel-caption">
    					<h3>Shopping</h3>
    						<p>Great time</p>
  					</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="${image}/mobile2.jpeg" alt="Second slide" class="dimensions">
				<div class="carousel-caption">
    				<h3>Mobile</h3>
    				<p>World in your hands!!!!!!!</p>
  				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="${image}/laptop1.jpeg" alt="Third slide" class="dimensions">
				<div class="carousel-caption">
    				<h3>Work</h3>
    				<p>Enjoy</p>
  				</div>
			</div>
		</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	
</body>
</html>
<style>
.container {
    position: relative;
    text-align: center;
    color: black;
    }
    .bottom-left {
    position: absolute;
    bottom: 8px;
    right: 16px;
   
}
.dimensions{
heigth:200px;
width:100px
}
.carousel-inner{
width:100%;
  max-height: 500px
}

</style>

}

