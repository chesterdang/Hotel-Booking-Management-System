<%-- 
    Document   : register
    Created on : Mar 1, 2024, 9:42:58 PM
    Author     : LAPTOP DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <title>Hotel Dashboard Template</title>
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="assets/css/feathericon.min.css">
    <link rel="stylesheet" href="assets/plugins/morris/morris.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <style>
        p {
            color: red;
        }
    </style>
</head>
<body>
    <div class="main-wrapper login-body">
        <div class="login-wrapper">
            <div class="container">
                <div class="loginbox">
                    <div class="login-left">
                        <img class="img-fluid" src="images/logo.jpg" alt="Logo">
                    </div>
                    <div class="login-right">
                        <div class="login-right-wrap">
                            <p>${existEmail}</p>
                            <p>${validEmail}</p>
                            <h1 class="mb-3">Register</h1>
                            <form action="register" method="post">
                                <input type="hidden" name="roleCode" value="${roleCode}">
                                <div class="form-group">
                                    <input class="form-control" type="text" placeholder="Full Name" name="fullname" pattern="[A-Za-z ]+" title="Please enter only alphabetical characters" required>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="text" placeholder="Email" name="email" required>
                                </div>
                                <p>${errorEmail}</p>
                                <div class="form-group">
                                    <input class="form-control" type="password" placeholder="Password" name="password" required>
                                </div>
                                <p>${errorPass}</p>
                                <div class="form-group">
                                    <input class="form-control" type="password" placeholder="Confirm Password" name="confirm" required>
                                </div>
                                <p>${errorPass}</p>
                                <p>${errorConfirm}</p>
                                <div class="form-group">
                                    <input class="form-control" type="date" placeholder="Date of Birth" name="dob" min="1900-01-01" max="2007-01-01" title="Please enter a valid date" required>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="tel" placeholder="Phone Number" name="phone" pattern="[0-9]{10}" title="Please enter exactly 10 numerical digits">
                                </div>
                                <div class="form-group">
                                    <textarea class="form-control" placeholder="Address" name="address"></textarea>
                                </div>
                                <div class="form-group mb-0">
                                    <button class="btn btn-primary btn-block" type="submit">Register</button>
                                </div>
                            </form>
                            <div class="login-or">
                                <span class="or-line"></span>
                                <span class="span-or">or</span>
                            </div>
                            <div class="text-center dont-have">Already have an account? <a href="login.jsp">Login</a> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/js/jquery-3.5.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="assets/js/script.js"></script>
</body>
</html>
