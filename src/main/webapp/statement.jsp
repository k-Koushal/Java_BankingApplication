<%@page import="Entity.Transactions"%>
<%@page import="java.util.List"%>
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
<title>Account Statement</title>
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
				<p class="text-center h1  display-5 ">Your Account Statement</p>	
			</div>
		
			<div class="col-9 w-100 position-relative border border-top">
			<%
			int i=1;
			List <Transactions> list=acc.getTx();
			
			int n=list.size();
			
			%>
			<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">TransactionID</th>
      <th scope="col">Date</th>
      <th scope="col">Deposit</th>
      <th scope="col">Withdrawal</th>
      <th scope="col">Balance</th>
    </tr>
  </thead>
  <tbody>
  <%
  for(int j=0;j<n-1;j++){
	  Transactions tx=list.get(j);
	  %>
	    <tr>
      <th scope="row"><%=i++ %></th>
      <td><%=tx.getTransactionId() %></td>
      <td><%=tx.getDate()%></td>
      <td><%=tx.getDeposite()%></td>
      <td><%=tx.getWithdraw()%></td>
      <td><%=tx.getBalance()%></td>
    </tr>
	  
	  <%
	  
  }
  %>
  
 
  </tbody>
</table>
			</div>
			<form action="optionsPage.jsp" method="post" >
            <div class="d-grid gap-4 py-4 col-6   mx-auto">
              <button type="submit" class="btn btn-outline-secondary fs-5" type="button">Go back</button>
          </div>
          </form>
		</div>

	</div>


	<!-- Footer -->
	<%@include file="footer.jsp"%>
</body>
</html>