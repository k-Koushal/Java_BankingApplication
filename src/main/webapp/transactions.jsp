<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
Account acc = (Account) session.getAttribute("account");
if (acc == null) {

	session.setAttribute("loginMessage", "Access not permitted! Please Login  to proceed further");
	response.sendRedirect("login.jsp");
	return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions Page</title>
<%@include file="style.jsp"%>
</head>
<body>
	<!-- NavBar -->
	<%@include file="navbar.jsp"%>
	<!-- End of NavBar -->
	<div class="container position-absolute top-30">
		<!-- Error Statement-->
	</div>
	<div
		class="container  border-5 w-50 my-5 bg-primary bg-opacity-25 bg-gradient">
		<div class="row  justify-content-center ">
			<div class="col-9   mt-3 pt-5  ">
				<p class="text-center h1  display-5 ">Transactions Page</p>
				<%@include file="transactionMsg.jsp" %>
			</div>
			<div class="border border-dark border-1 p-2 my-3 position-relative w-50 ">
				<span class="fw-bold fs-5 text-muted">Account Balance: </span> <span
					class="fw-bold fs-5  fst-italic"> Rs.<%=account.getBalance()%>
				</span>
			</div>

			<div class="col-9 w-100 position-relative">
				<form action="transaction" method="post">
					<input type="number" class="form-control w-50 mx-auto my-3"
						name="transactionAmount" placeholder="Enter Amount in Rs/-"
						required> 
						<select class="form-select w-50 mx-auto my-3"
						aria-label="Select type of transaction" name="transactionType" required>
						
						<option value="deposit">Deposit</option>
						<option value="withdraw">Withdraw</option>
					</select>
					<div class="d-flex justify-content-center mb-4">
					
					<button type="submit" class="btn btn-primary w-25  ">Proceed</button>
					</div>
					
				</form>
					<form action="optionsPage.jsp" method="post" >
            <div class="d-grid gap-4 py-4 col-6   mx-auto">
              <button type="submit" class="btn btn-outline-secondary fs-5" type="button">Go back</button>
          </div>
          </form>


			</div>

		</div>

	</div>


	<!-- Footer -->
	<%@include file="footer.jsp"%>
</body>
</html>