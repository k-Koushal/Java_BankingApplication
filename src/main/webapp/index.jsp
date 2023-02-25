<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@include file="style.jsp"%>
<title>Home-MyBank</title>
</head>
<body>
	<!--NavBar-->
	<%@include file="navbar.jsp"%>
	<!--End of NavBar-->
	<!--HomePage Card-->
	<div class="row align-items-center mt-5  w-100 px-3">
		<div class="col-6 ">
			<p class="text-center mt-5 display-6 ">Welcome to My Bank
				Application</p>
			<div class="col position-relative mt-3 w-100 ms-2  mb-3 text-start ">
				<p class="lh-sm  ">My Bank web-App is a web-based application
					designed to provide banking services to customers using Java
					programming language, JSP, Servlets, and Spring configuration. The
					application provides various features, including account
					management, money transfers, and transaction history, among others.
				</p>
				<p class="lh-sm">The web-App is created using Java programming
					language, which is widely used for building enterprise-level
					applications. Servlets and JSP are used to build the web interface,
					which allows customers to interact with the application through
					their web browser.</p>
				<p class="lh-sm">Spring configuration is used to provide a
					framework for developing the application, which includes various
					modules such as security, data access, and transaction management,
					among others. The Spring framework also provides a set of pre-built
					libraries and components, which reduces the development time and
					makes the application more efficient and reliable.</p>
				<p class="lh-sm">Overall, your banking web app provides a secure
					and user-friendly platform for customers to manage their banking
					needs online.</p>
			</div>

		</div>
		<div class="col-3  w-50 ">
			<img src="images/bankLogo.png" class="img-fluid  " alt="BankLogo" />
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>
