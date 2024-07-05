<%-- 
    Document   : login
    Created on : Mar 1, 2024, 5:53:03 PM
    Author     : Hi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <title>Hotel Dashboard</title>

        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">
        <link rel="stylesheet" href="assets/LoginAssets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/LoginAssets/plugins/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" type="text/css" href="assets/LoginAssets/plugins/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="assets/LoginAssets/css/feathericon.min.css">
        <link rel="stylesheet" href="assets/LoginAssets/plugins/morris/morris.css">
        <link rel="stylesheet" href="assets/LoginAssets/css/style.css"> </head>

    <body>
        <c:set var="mess" value="${requestScope.mess}" />
        <c:if test="${not empty mess and( mess eq 'Reset password successfully' or mess eq 'Sign Up Success')}">
            <div id="successMessage" class="success-message">${mess}</div>
        </c:if>

             <c:if test="${not empty mess and mess eq 'Email or Password is incorrect.'}">
            <div id="errorMessage" class="error-message">${mess}</div>
        </c:if>

          

        <div class="main-wrapper login-body">
            <div class="login-wrapper">
                <div class="container">
                    <div class="loginbox">
                        <div class="login-left"> <img class="img-fluid" style="" src="assets/LoginAssets/img/login_img.jpg" alt="Logo"> </div>
                        <div class="login-right">
                            <div class="login-right-wrap">
                                <h1>Login</h1>
                                <p class="account-subtitle">Access to our dashboard</p>
<!--                                                        <p class="account-subtitle">${mess}</p>-->
                                <form action="signin" method="post">
                                    <div class="form-group">
                                        <input class="form-control" type="text" placeholder="Email" name="username" value="${username}" > </div>
                                    <p class="account-subtitle" style="color: red">${usernameError}</p>
                                    <div class="form-group">
                                        <input class="form-control" type="password" placeholder="Password" name="password" value="${password}" > </div>
                                    <p class="account-subtitle" style="color: red">${passError}</p>
                                    <div class="form-group">
                                        <button class="btn btn-primary btn-block" type="submit">Login</button>
                                    </div>
                                </form>
                                <div class="text-center forgotpass"><a href="/BookingHotel_Prj301/forgot">Forgot Password?</a> </div>

                                <div class="text-center dont-have">Don’t have an account? <a href="setrole">Register</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="assets/LoginAssets/js/jquery-3.5.1.min.js"></script>
        <script src="assets/LoginAssets/js/popper.min.js"></script>
        <script src="assets/LoginAssets/js/bootstrap.min.js"></script>
        <script src="assets/LoginAssets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
        <script src="assets/LoginAssets/js/script.js"></script>
    </body>
    <style>
        .success-message {

            position: fixed;
            top: 20px; /* điều chỉnh vị trí top của thông báo */
            right: 20px; /* điều chỉnh vị trí right của thông báo */
            background-color: green; /* màu nền của thông báo */
            color: white; /* màu chữ của thông báo */
            padding: 20px; /* tăng khoảng cách giữa nội dung và biên của thông báo */
            border-radius: 10px; /* bo tròn góc của thông báo */
            display: none; /* ẩn thông báo ban đầu */
            border: 2px solid #4CAF50; /* viền màu xanh lá cây */
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.75); /* bóng */
            opacity: 1; /* mặc định hiển thị */
            transition: opacity 1s ease; /* thêm hiệu ứng mờ dần */
        }
        
        .error-message {

            position: fixed;
            top: 20px; /* điều chỉnh vị trí top của thông báo */
            right: 20px; /* điều chỉnh vị trí right của thông báo */
            background-color: red; /* màu nền của thông báo */
            color: white; /* màu chữ của thông báo */
            padding: 20px; /* tăng khoảng cách giữa nội dung và biên của thông báo */
            border-radius: 10px; /* bo tròn góc của thông báo */
            display: none; /* ẩn thông báo ban đầu */
            border: 2px solid #FFC0CB; /* viền màu xanh lá cây */
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.75); /* bóng */
            opacity: 1; /* mặc định hiển thị */
            transition: opacity 1s ease; /* thêm hiệu ứng mờ dần */
        }
    </style>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            var successMessage = document.getElementById('successMessage');
            // Hiển thị thông báo
            successMessage.style.display = 'block';
            // Tự động biến mất và mờ dần sau 3 giây
            setTimeout(function () {
                successMessage.style.opacity = '0';
                setTimeout(function () {
                    successMessage.style.display = 'none';
                }, 1000); // 1000 milliseconds = 1 giây
            }, 1000); // 3000 milliseconds = 3 giây
        });
         document.addEventListener('DOMContentLoaded', function () {
            var errorMessage = document.getElementById('errorMessage');
            // Hiển thị thông báo
            errorMessage.style.display = 'block';
            // Tự động biến mất và mờ dần sau 3 giây
            setTimeout(function () {
                errorMessage.style.opacity = '0';
                setTimeout(function () {
                    errorMessage.style.display = 'none';
                }, 1000); // 1000 milliseconds = 1 giây
            }, 1000); // 3000 milliseconds = 3 giây
        });
    </script>
</html>

