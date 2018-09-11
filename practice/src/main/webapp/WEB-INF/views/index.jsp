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
		<nav class="navbar navbar-expand-sm bg-light navbar-light">
			<ul class="nav nav-tabs">
				<li><a class="navbar-brand" href="#">E-Commerce</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbardrop"
					data-toggle="dropdown"> Gadgets </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">SMARTPHONES </a> <a
							class="dropdown-item" href="#">LAPTOP </a> <a
							class="dropdown-item" href="#">TABLET</a>
					</div></li>
				<li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbardrop"
					data-toggle="dropdown"> SignUp As </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="vendorsignup">Vendor </a> <a
							class="dropdown-item" href="#">Admin</a> <a
							class="dropdown-item" href="#">Customer</a>
					</div></li>
				 <!-- <li>
    				<a class="nav-link" href="signup">SignUp</a>
    			</li> -->
				<li><a class="nav-link" href="login">Login</a></li>

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
				<img class="d-block w-100" src="${image}/image1.jpg"
					alt="First slide">
					<div class="carousel-caption">
    					<h3>Shopping</h3>
    						<p>Great time</p>
  					</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="${image}/mobile.jpg" alt="Second slide">
				<div class="carousel-caption">
    				<h3>Mobile</h3>
    				<p>World in your hands!!!!!!!</p>
  				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="${image}/laptop.jpeg" alt="Third slide">
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
</style>

}

