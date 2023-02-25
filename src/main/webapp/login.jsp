<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- Style -->
	<%@include file="style.jsp" %>
	<!-- /Style -->

    <title>Home-MyBank</title>
  </head>
  <body >
    <!--NavBar-->
    <%@include file="navbar.jsp" %>
    <!--End of NavBar-->
    <div class="container position-absolute top-30">
      <!-- Error Statement-->
    </div>
    <div class="container  border-5 w-50 my-5 bg-primary bg-opacity-25 bg-gradient">
      <div class="row  justify-content-center ">
        <div class="col-9   mt-3 pt-5 
        ">
          <p class="text-center h1  display-5 ">Welcome To MyBank</p>
          <%@include file="loginMessage.jsp" %>
        </div>
        
        <div id="loginBox" class="col-9 justify-content-md-center mt-4  mb-5 py-5 px-5 ">
            <form action="loginServlet" method="post">
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label">User ID</label>
                  <input type="number" class="form-control" name="userID">
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Password</label>
                  <input type="password" class="form-control" name="userPassword">
                </div>
               <div class="w-100 position-relative   d-flex">
               <button type="submit" class="btn btn-primary mx-auto position-relative fw-semibold fs-6">Login</button>
               </div>
              </form>
        
        </div>

      </div>
    </div>
    
    <!-- Footer -->
   <%@include file="footer.jsp" %>
   
  </body>
</html>
