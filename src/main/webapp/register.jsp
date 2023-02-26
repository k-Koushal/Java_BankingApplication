<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Style -->
<%@include file="style.jsp"%>

<title>Registration Page</title>
</head>
<body>
	<!--NavBar-->
	<%@include file="navbar.jsp"%>
	<!--End of NavBar-->
	<div class="container border-5 my-3 bg-success bg-gradient bg-opacity-25 bg-gradient w-50">
		<div class="row justify-content-center">
			<div class="col-9 mt-3 pt-5">
				<p class="text-center h1 display-5">Welcome To MyBank</p>
			</div>


			<div id="loginBox"
				class="col-9 justify-content-md-center mt-4 mb-3 py-5 px-5">
				<%@include file="registrationSuccessMessage.jsp"%>
				<form action="Register" method="post">
					<div class="row mb-3 d-flex ">
						<label for="userName"
							class="col-sm-2 col-form-label col-form-label-sm fw-bold fs-6">
							Name </label>
						<div class="col-sm-10 ">
							<input type="text"
								class="form-control form-control-sm fw-bold fs-6 ms-4"
								name="userName" placeholder="Enter Full Name" required />
						</div>
					</div>
					<div class="row mb-3">
						<label for="UserName"
							class="col-sm-2 col-form-label col-form-label-sm fw-bold fs-6">
							DoB </label>
						<div class="col-sm-10">
							<input type="date"
								class="form-control form-control-sm fw-bold fs-6 ms-4" name="userDOB"
								placeholder="Enter Date of Birth" required />
						</div>
					</div>
					<div class="row mb-3">
						<label for="UserAddress"
							class="col-sm-2 col-form-label col-form-label-sm fw-bold fs-6">
							Address </label>
						<div class="col-sm-10">
							<input type="text"
								class="form-control form-control-sm fw-bold fs-6 ms-4"
								name="userAddress" placeholder="Hno/city/pin" required />
						</div>
					</div>
					<div class="row mb-3">
						<label for="UserName"
							class="col-sm-2 col-form-label col-form-label-sm fw-bold fs-6">
							Email </label>
						<div class="col-sm-10">
							<input type="email"
								class="form-control form-control-sm fw-bold fs-6 ms-4"
								name="userEmail" placeholder="Enter Email ID" required />
						</div>
					</div>
					<div class="row mb-3">
						<label for="UserName"
							class="col-sm-2 col-form-label col-form-label-sm fw-bold fs-6">
							Password </label>
						<div class="col-sm-10">
							<input type="password"
								class="form-control form-control-sm fw-bold fs-6 ms-4"
								name="userPassword" placeholder="Set password" required />
						</div>
					</div>
					<div class="row mb-3">
						<label for="UserName"
							class="col-sm-2 col-form-label col-form-label-sm fw-bold fs-6">
							Select </label>
						<div class="col-sm-10">
							<select class="form-select fw-bold fs-6 ms-4 " name="userAccountType"
								required>
								<option selected>Type of Account</option>
								<option value="Savings">Savings Account</option>
								<option value="Current">Current Account</option>
							</select>
						</div>
					</div>

					<div class="col  mt-5  ">
						<button type="submit" class="btn  mx-5 me-2 btn-primary">Submit</button>
						<button type="reset" class="btn ms-2 me-2 btn-success">&nbsp;
							Reset &nbsp;</button>
					</div>

				</form>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>
