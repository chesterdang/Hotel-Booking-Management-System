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

    <body onload="resetPass()">
	<div class="main-wrapper login-body">
		<div class="login-wrapper">
			<div class="container">
				<div class="loginbox">
					<div class="login-left"> <img class="img-fluid" src="assets/LoginAssets/img/login_img.jpg" alt="Logo"> </div>
					<div class="login-right">
						<div class="login-right-wrap">
							<h1>Forgot Password?</h1>
							 <p class="account-subtitle">${mess}</p>
                                                         <form id="resetForm" action="reset" method="post">
								<div class="form-group">
                                                                    <c:set scope="page" var="email" value="${email}"></c:set>
                                                                    <input class="form-control" type="hidden" placeholder="Email" name="username" value="${email}" required> </div>
                                                                    <div class="form-group">
                                                                        <input class="form-control" type="password" placeholder="Password" name="password" required> </div>
                                                                    <p class="account-subtitle" style="color: red">${errorPass}</p>
                                                                    <div class="form-group">
                                                                        <input class="form-control" type="password" placeholder="Confirm Password" name="cpassword" required> </div>
                                                                    <p class="account-subtitle" style="color: red">${errorcPass}</p>
                                                                    <div class="form-group">
                                                                    <input class="form-control" type="text" placeholder="CODE" name="code" required> </div>
                                                                    <p class="account-subtitle" style="color: red">${errorCode}</p>
                                                                    <p><span id="messWatch">This code will expire in </span> <span id="second"></span> <span id="unit">seconds</span></p>
								<div class="form-group mb-0">
                                                                    <input type="hidden" id="validTime" name="validTime" value="${validTime}">
                              
                                                                    <button class="btn btn-primary btn-block" onclick="resetPassword()" type="button" >Reset Password</button>
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
<!--        <script src="assets/LoginAssets/js/forgot.js"></script>-->
        
        <script>           
var second ;
var validTime = document.getElementById('validTime');
var validTimeValue = validTime.value;

console.log(document.getElementById('validTime').value);
function abc(){
    if(validTimeValue == '-1'){
    second = 60;
}else{
        second = validTimeValue;
        };
}

abc();



function watch() {
    second--
    if(second == -1){
        second =0;
    }
    if (second == 0) {
        document.getElementById('messWatch').innerText = "This code has expired";
        clearInterval(intervalWatch);
    }
     document.getElementById('second').innerText = second;
     
     if(second ==0){
         document.getElementById('second').innerText ="";
         document.getElementById('unit').innerText=""
     }
    
}

var check = 1;

function resetPass(){
    intervalWatch = setInterval(watch, 1000);
}


function resetPassword(){
    var time = document.getElementById('validTime');
    time.value = second;
    
    var resetForm = document.getElementById('resetForm');
    resetForm.submit();
}

        </script>
</body>
</html>