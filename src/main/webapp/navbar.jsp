<!--NavBar-->


<%@page import="Entity.Account"%>
<%
Account account = (Account) session.getAttribute("account");
%>
<nav class="navbar  bg-dark bg-gradient ">
	<div class="container-fluid">
		<a class="navbar-brand fs-4 fw-bolder ps-5 text-white ms-5"
			href="index.jsp">My Bank</a>
		<form class="d-flex me-5" role="search">
			<%
			if (account == null) {
			%>
			<button onclick="window.location='login.jsp';"
				class="btn btn-lg btn-outline-secondary me-4 text-light fw-semibold"
				type="button">Login</button>
			<button onclick="window.location='register.jsp';"
				class="btn btn-lg btn-outline-secondary me-4 text-light fw-semibold "
				type="button">Register</button>

			<%
			} else {
			%>
			<span class="me-4 text-light fs-4  fw-semibold my-auto "><%=account.getUserName()%></span>
			<button onclick="window.location='logout.jsp';"
				class="btn btn-lg btn-outline-secondary me-4 text-light fw-semibold "
				type="button">Logout</button>


			<%
			}
			%>

		</form>
	</div>
</nav>

<!--End of NavBar-->