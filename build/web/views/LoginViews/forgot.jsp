<%-- 
    Document   : forgot.jsp
    Created on : Mar 3, 2024, 4:21:42 PM
    Author     : Hi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
	<title>Hotel Dashboard Template</title>
	<link rel="shortcut icon" type="image/x-icon" href="assets/LoginAssets/img/favicon.png">
	<link rel="stylesheet" href="assets/LoginAssets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/LoginAssets/plugins/fontawesome/css/all.min.css">
	<link rel="stylesheet" href="assets/LoginAssets/plugins/fontawesome/css/fontawesome.min.css">
	<link rel="stylesheet" href="assets/LoginAssets/css/style.css"> </head>

    <body >
	<div class="main-wrapper login-body">
		<div class="login-wrapper">
			<div class="container">
				<div class="loginbox">
					<div class="login-left"> <img class="img-fluid" src="assets/LoginAssets/img/login_img.jpg" alt="Logo"> </div>
					<div class="login-right">
						<div class="login-right-wrap">
							<h1>Forgot Password?</h1>
							<p class="account-subtitle">Enter your email to get a password reset link</p>
                                                        <form action="forgot" method="post">
								<div class="form-group">
                                                                    <input class="form-control" type="text" placeholder="Email" name="username"> </div>
                                                                    <p class="account-subtitle">${usernameError}</p>
								<div class="form-group mb-0">
                      
                                                                    <button class="btn btn-primary btn-block" type="submit" >Reset Password</button>
								</div>
                                                                
							</form>
							<div class="text-center dont-have">Remember your password? <a href="/BookingHotel_Prj301/signin">Login</a></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="assets/LoginAssets/js/jquery-3.5.1.min.js"></script>
	<script src="assets/LoginAssets/js/popper.min.js"></script>
	<script src="assets/LoginAssets/js/bootstrap.min.js"></script>
	<script src="assets/LoginAssets/js/script.js"></script>
        <script src="assets/LoginAssets/js/forgot.js"></script>
</body>
</html>
