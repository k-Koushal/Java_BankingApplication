
<%@page import="Entity.Account"%>
<%
	
Account acc=(Account)session.getAttribute("account");
if(acc==null){
	
	session.setAttribute("loginMessage","Access not permitted! Please Login  to proceed further");
	response.sendRedirect("login.jsp");
	return;
}
%>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
   <!-- Style -->
   <%@include file="style.jsp" %>

    <title>Home-MyBank</title>
  </head>
  <body >
    <!--NavBar-->
    <%@include file="navbar.jsp" %>
    <!--End of NavBar-->
    <div class="container-fluid  border-5 my-5 bg-light bg-gradient">
      <div class="row  justify-content-center ">
        <div class="col-9   mt-3 pt-5 
        ">
          <p class="text-center h1  display-5 ">Welcome <%=acc.getUserName() %></p>
        </div>
        <div id="loginPageCard" class="col-9 justify-content-md-center mt-4  mb-5 py-5 ">
          <form action="" method="post" class="">
            <div class="d-grid gap-4 py-4 col-6  mx-auto">
              <button type="sumbit" class="btn btn-outline-primary fs-5" type="button">Make Transactions</button>
          </div>
          </form>
          <form action="" method="post" class="">
            <div class="d-grid gap-4 py-4 col-6  mx-auto">
              <button type="sumbit" class="btn btn-outline-success fs-5" type="button">See Statement</button>
          </div>
          </form>
          <form action="" method="post" class="">
            <div class="d-grid gap-4 py-4 col-6   mx-auto">
              <button type="sumbit" class="btn btn-outline-secondary fs-5" type="button">Exit</button>
          </div>
          </form>
        
        </div>

      </div>
    </div>
   
    <!-- Footer -->
    <%@include file="footer.jsp" %>
  </body>
</html>
