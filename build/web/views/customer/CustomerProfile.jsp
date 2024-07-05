<%-- 
    Document   : CustomerProfile
    Created on : Mar 2, 2024, 4:32:31 PM
    Author     : HI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <title>Profile</title>
        <link rel="shortcut icon" type="image/x-icon" href='<c:url value="/assets/customer/assets/img/favicon.png"></c:url>'>
        <link rel="stylesheet" href='<c:url value="/assets/customer/assets/css/bootstrap.min.css"></c:url>'>
        <link rel="stylesheet" href='<c:url value="/assets/customer/assets/plugins/fontawesome/css/fontawesome.min.css"></c:url>'>
        <link rel="stylesheet" href='<c:url value="/assets/customer/assets/plugins/fontawesome/css/all.min.css"></c:url>'>
        <link rel="stylesheet" href='<c:url value="/assets/customer/assets/css/feathericon.min.css"></c:url>'>
            <link rel="stylehseet" href="https://cdn.oesmith.co.uk/morris-0.5.1.css">
            <link rel="stylesheet" href='<c:url value="/assets/customer/assets/plugins/morris/morris.css"></c:url>'>
        <link rel="stylesheet" href='<c:url value="/assets/customer/assets/css/style.css"></c:url>'> 
            <!-- Google Web Fonts -->
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600&family=Roboto&display=swap" rel="stylesheet"> 

            <!-- Icon Font Stylesheet -->
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

            <!-- Libraries Stylesheet -->
            <link href='<c:url value="/assets/customer/lib/owlcarousel/assets/owl.carousel.min.css"></c:url>' rel="stylesheet">
        <link href='<c:url value="/assets/customer/lib/lightbox/css/lightbox.min.css"></c:url>' rel="stylesheet">

            <!-- Template Stylesheet -->
            <link href='<c:url value="/assets/customer/assets/css/stylecustomer.css"></c:url>' rel="stylesheet">

        <body>

            <div class="main-wrapper">
                <div class="header">
                    <div class="header-left">
                        <a href="index.html" class="logo"> <img src="assets/img/hotel_logo.png" width="50" height="70" alt="logo"> <span class="logoclass">HOTEL</span> </a>
                        <a href="index.html" class="logo logo-small"> <img src="assets/img/hotel_logo.png" alt="Logo" width="30" height="30"> </a>
                    </div>
                    <a href="javascript:void(0);" id="toggle_btn"> <i class="fe fe-text-align-left"></i> </a>
                    <a class="mobile_btn" id="mobile_btn"> <i class="fas fa-bars"></i> </a>
                    <ul class="nav user-menu">
                        <li class="nav-item dropdown noti-dropdown">
                            <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown"> <i class="fe fe-bell"></i> <span class="badge badge-pill">3</span> </a>
                            <div class="dropdown-menu notifications">
                                <div class="topnav-dropdown-header"> <span class="notification-title">Notifications</span> <a href="javascript:void(0)" class="clear-noti"> Clear All </a> </div>
                                <div class="noti-content">
                                    <ul class="notification-list">
                                        <li class="notification-message">
                                            <a href="#">
                                                <div class="media"> <span class="avatar avatar-sm">
                                                        <img class="avatar-img rounded-circle" alt="User Image" src="assets/img/profiles/avatar-02.jpg">
                                                    </span>
                                                    <div class="media-body">
                                                        <p class="noti-details"><span class="noti-title">Carlson Tech</span> has approved <span class="noti-title">your estimate</span></p>
                                                        <p class="noti-time"><span class="notification-time">4 mins ago</span> </p>
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="notification-message">
                                            <a href="#">
                                                <div class="media"> <span class="avatar avatar-sm">
                                                        <img class="avatar-img rounded-circle" alt="User Image" src="assets/img/profiles/avatar-11.jpg">
                                                    </span>
                                                    <div class="media-body">
                                                        <p class="noti-details"><span class="noti-title">International Software
                                                                Inc</span> has sent you a invoice in the amount of <span class="noti-title">$218</span></p>
                                                        <p class="noti-time"><span class="notification-time">6 mins ago</span> </p>
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="notification-message">
                                            <a href="#">
                                                <div class="media"> <span class="avatar avatar-sm">
                                                        <img class="avatar-img rounded-circle" alt="User Image" src="assets/img/profiles/avatar-17.jpg">
                                                    </span>
                                                    <div class="media-body">
                                                        <p class="noti-details"><span class="noti-title">John Hendry</span> sent a cancellation request <span class="noti-title">Apple iPhone
                                                                XR</span></p>
                                                        <p class="noti-time"><span class="notification-time">8 mins ago</span> </p>
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="notification-message">
                                            <a href="#">
                                                <div class="media"> <span class="avatar avatar-sm">
                                                        <img class="avatar-img rounded-circle" alt="User Image" src="assets/img/profiles/avatar-13.jpg">
                                                    </span>
                                                    <div class="media-body">
                                                        <p class="noti-details"><span class="noti-title">Mercury Software
                                                                Inc</span> added a new product <span class="noti-title">Apple
                                                                MacBook Pro</span></p>
                                                        <p class="noti-time"><span class="notification-time">12 mins ago</span> </p>
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="topnav-dropdown-footer"> <a href="#">View all Notifications</a> </div>
                            </div>
                        </li>
                        <li class="nav-item dropdown has-arrow">
                            <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown"> <span class="user-img"><img class="rounded-circle" src="assets/img/profiles/avatar-01.jpg" width="31" alt="Soeng Souy"></span> </a>
                            <div class="dropdown-menu">
                                <div class="user-header">
                                    <div class="avatar avatar-sm"> <img src="assets/img/profiles/avatar-01.jpg" alt="User Image" class="avatar-img rounded-circle"> </div>
                                    <div class="user-text">
                                        <h6>Soeng Souy</h6>
                                        <p class="text-muted mb-0">Administrator</p>
                                    </div>
                                </div> <a class="dropdown-item" href="CustomerProfile.jsp">My Profile</a> 
                                <a class="dropdown-item" href='<c:url value="/logout"></c:url>'>Logout</a> </div>
                        </li>
                    </ul>
                </div>
                <div class="sidebar" id="sidebar">
                    <div class="sidebar-inner slimscroll">
                        <div id="sidebar-menu" class="sidebar-menu">
                            <ul>
                                <li class="active"> <a href='<c:url value="/HomeCustomerController?fetch=6&page=1"></c:url>'><i class="fas fa-tachometer-alt"></i> <span>Home</span></a> </li>
                                <li class="list-divider"></li>
                                <li class="submenu"> <a href="#"><i class="fas fa-suitcase"></i> <span> Booking </span> <span class="menu-arrow"></span></a>
                                    <ul class="submenu_class" style="display: none;">
                                        <li><a href="all-booking.html">Pending Booking</a></li>
                                        <li><a href="edit-booking.html">Denied Booking</a></li>
                                        <li><a href="add-booking.html">Completed Booking</a></li>
                                    </ul>
                                </li>
                                <li class=""> <a href="#"><i class="fas fa-heart"></i> <span> Favourite List </span></a></li>
                                <li class=""> <a href='<c:url value="/invoice?index=1"></c:url>'><i class="fas fa-file-invoice"></i> <span> Invoices</span></a></li>
                                <li class=""> <a href="payments.html"><i class="fas fa-money-bill"></i> <span> Payments</span></a></li>
                                <li> <a href='<c:url value="/views/customer/Calendar.jsp"></c:url>'><i class="fas fa-calendar-alt"></i> <span>Calendar</span></a> </li>
                                <li class=""> <a href="<c:url value="/listreport?index=1&action=DateDESC"></c:url>"><i class="fe fe-table"></i> <span> Reports </span></a>

                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="page-wrapper">
                    <div class="content container-fluid">
                        <div class="page-header mt-5">
                            <div class="row">
                                <div class="col">
                                    <h3 class="page-title">Profile</h3>
                                    <ul class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                        <li class="breadcrumb-item active">Profile</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="profile-header">
                                    <div class="row align-items-center">
                                        <div class="col-auto profile-image">
                                            <a href="#"> <img class="rounded-circle" alt="User Image" src="<c:url value="/images/avatar/${user.avatar == null ? 'defaultUser.jpg' : user.avatar}"></c:url>"></a>
                                    </div>
                                    <div class="col ml-md-n2 profile-user-info">
                                        <h4 class="user-name mb-3">${user.fullname}</h4>
                                        <div class="user-Location mt-1"><i class="fas fa-map-marker-alt"></i> ${user.address}</div>
                                        <div class="about-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</div>
                                    </div>
                                    <div class="col-auto profile-btn"> <a href="" class="btn btn-primary">
                                            Message
                                        </a> <a href="edit-profile.html" class="btn btn-primary">
                                            Edit
                                        </a> </div>
                                </div>
                            </div>
                            <div class="profile-menu">
                                <ul class="nav nav-tabs nav-tabs-solid">
                                    <li class="nav-item"> <a class="nav-link active" data-toggle="tab" href="#per_details_tab">About</a> </li>
                                    <li class="nav-item"> <a class="nav-link" data-toggle="tab" href="#password_tab">Password</a> </li>
                                </ul>
                            </div>
                            <div class="tab-content profile-tab-cont">
                                <div class="tab-pane fade show active" id="per_details_tab">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="card">
                                                <div class="card-body">
                                                    <h5 class="card-title d-flex justify-content-between">
                                                        <span>Personal Details</span>
                                                        <a class="edit-link" data-toggle="modal" href="#edit_personal_details"><i class="fa fa-edit mr-1"></i>Edit</a>
                                                    </h5>
                                                    <div class="row mt-5">
                                                        <p class="col-sm-3 text-sm-right mb-0 mb-sm-3">Name</p>
                                                        <p class="col-sm-9">${user.fullname}</p>
                                                    </div>
                                                    <div class="row">
                                                        <p class="col-sm-3 text-sm-right mb-0 mb-sm-3">Date of Birth</p>
                                                        <p class="col-sm-9">${user.dob==null?"":user.dob}</p>
                                                    </div>
                                                    <div class="row">
                                                        <p class="col-sm-3 text-sm-right mb-0 mb-sm-3">Email </p>
                                                        <p class="col-sm-9"><a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="385c594e515c59544e594a5d42785d40595548545d165b5755">${user.email}</a></p>
                                                    </div>
                                                    <div class="row">
                                                        <p class="col-sm-3 text-sm-right mb-0 mb-sm-3">Mobile</p>
                                                        <p class="col-sm-9">${user.phone==null?"":user.phone}</p>
                                                    </div>
                                                    <div class="row">
                                                        <p class="col-sm-3 text-sm-right mb-0">Address</p>
                                                        <p class="col-sm-9 mb-0">${user.address==null?"":user.address}</p>
                                                    </div>
                                                </div>
                                                <c:if test="${not empty requestScope.success}">
                                                    <div class="alert alert-success" role="alert">
                                                        ${requestScope.success}
                                                    </div>
                                                </c:if>
                                            </div>
                                            <div class="modal fade" id="edit_personal_details" aria-hidden="true" role="dialog">
                                                <div class="modal-dialog modal-dialog-centered" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title">Personal Details</h5>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <form action="/BookingHotel_Prj301/updateprofile" method="post" enctype="multipart/form-data">
                                                                <input type="hidden" name="action" value="updateprofile" />
                                                                <div class="row form-row">
                                                                    <div class="col-12 col-sm-12">
                                                                        <div class="form-group">
                                                                            <label>Avatar</label>
                                                                            <input placeholder="file-size <= 10mb" type="file" name="avatar" class="form-control" value=""/> </div>
                                                                    </div>
                                                                    <div class="col-12 col-sm-12">
                                                                        <div class="form-group">
                                                                            <label>Full Name</label>
                                                                            <input type="text" class="form-control" name="fullname" value="${user.fullname}"/> </div>
                                                                    </div>
                                                                    <div class="col-12">
                                                                        <div class="form-group">
                                                                            <label>Date of Birth</label>
                                                                            <div class="cal-icon">
                                                                                <input type="text" class="form-control"  name="dob" value="${user.dob==null?"":user.dob}"/> </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-12 col-sm-6">
                                                                        <div class="form-group">
                                                                            <label>Email ID</label>
                                                                            <input type="email" class="form-control" name="email" value="${user.email}"/> </div>
                                                                    </div>
                                                                    <div class="col-12 col-sm-6">
                                                                        <div class="form-group">
                                                                            <label>Phone</label>
                                                                            <input  name="phone" class="form-control" value="${user.phone==null?"":user.phone}" type="tel"  pattern="^(0\d{9,10}|(\+84|84)\d{9,10})$"/> </div>
                                                                    </div>

                                                                    <div class="col-12">
                                                                        <div class="form-group">
                                                                            <label>Address</label>
                                                                            <input type="text" class="form-control"  name="address" value="${user.address==null?"":user.address}"/> </div>
                                                                    </div>
                                                                </div>
                                                                <input type="submit" class="btn btn-primary btn-block" value="Save Changes" />
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="password_tab" class="tab-pane fade">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Change Password</h5>
                                        <div class="row">
                                            <div class="col-md-10 col-lg-6">
                                                <form action="/BookingHotel_Prj301/updateprofile" method="post">
                                                    <input type="hidden" name="action" value="updatepassword"/>
                                                    <div class="form-group">
                                                        <label>Old Password</label>
                                                        <input type="password" class="form-control" name="oldpassword" required> </div>
                                                    <div class="form-group">
                                                        <label>New Password</label>
                                                        <input type="password" class="form-control" name="newpassword" required> </div>
                                                    <div class="form-group">
                                                        <label>Confirm Password</label>
                                                        <input type="password" class="form-control" name="confirmpassword" required> </div>
                                                    <button class="btn btn-primary" type="submit">Save Changes</button>
                                                </form>
                                                <c:if test="${not empty requestScope.wrongOldPass}">
                                                    <div class="alert alert-warning" role="alert">
                                                        ${requestScope.wrongOldPass}
                                                    </div>
                                                </c:if>

                                                <c:if test="${not empty requestScope.wrongNewPass}">
                                                    <div class="alert alert-warning" role="alert">
                                                        ${requestScope.wrongNewPass}
                                                    </div>
                                                </c:if>

                                                <c:if test="${not empty requestScope.wrongConfirmPass}">
                                                    <div class="alert alert-warning" role="alert">
                                                        ${requestScope.wrongConfirmPass}
                                                    </div>
                                                </c:if>

                                                <c:if test="${not empty requestScope.success}">
                                                    <div class="alert alert-success" role="alert">
                                                        ${requestScope.success}
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script data-cfasync="false" src="../../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
        <script src='<c:url value="/assets/customer/assets/js/jquery-3.5.1.min.js"></c:url>'></script>
        <script src='<c:url value="/assets/customer/assets/js/popper.min.js"></c:url>'></script>
        <script src='<c:url value="/assets/customer/assets/js/bootstrap.min.js"></c:url>'></script>
        <script src='<c:url value="/assets/customer/assets/plugins/slimscroll/jquery.slimscroll.min.js"></c:url>'></script>
        <script src='<c:url value="/assets/customer/assets/plugins/raphael/raphael.min.js"></c:url>'></script>
        <script src='<c:url value="/assets/customer/assets/plugins/morris/morris.min.js"></c:url>'></script>
        <script src='<c:url value="/assets/customer/assets/js/chart.morris.js"></c:url>'></script>
        <script src='<c:url value="/assets/customer/assets/js/script.js"></c:url>'></script>
            <!-- JavaScript Libraries -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
            <script src='<c:url value="/assets/customer/lib/easing/easing.min.js"></c:url>'></script>
        <script src='<c:url value="/assets/customer/lib/waypoints/waypoints.min.js"></c:url>'></script>
        <script src='<c:url value="/assets/customer/lib/owlcarousel/owl.carousel.min.js"></c:url>'></script>
        <script src='<c:url value="/assets/customer/lib/lightbox/js/lightbox.min.js"></c:url>'></script>
            <!-- Template Javascript -->
            <script src='<c:url value="/assets/customer/js/main.js"></c:url>'></script>
    </body>

</html>
