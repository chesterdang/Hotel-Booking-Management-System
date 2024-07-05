<%-- 
    Document   : CustomerProfile
    Created on : Mar 2, 2024, 4:32:31 PM
    Author     : HI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="util.DateUtils" %>
<%@ page import="java.sql.Timestamp" %>
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
                                </div>
                                <div>
                                    <a class="dropdown-item" href="/BookingHotel_Prj301/views/customer/CustomerProfile.jsp">My Profile</a> 
                                    <a class="dropdown-item" href="<c:url value="/logout"></c:url>">Logout</a> 
                                </div>
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
                                <li class=""> <a href='<c:url value="/invoice"></c:url>'><i class="fas fa-file-invoice"></i> <span> Invoices</span></a></li>
                                <li class=""> <a href="payments.html"><i class="fas fa-money-bill"></i> <span> Payments</span></a></li>
                                <li> <a href='<c:url value="/views/customer/Calendar.jsp"></c:url>'><i class="fas fa-calendar-alt"></i> <span>Calendar</span></a> </li>
                                <li class="submenu"> <a href="#"><i class="fe fe-table"></i> <span> Reports </span> <span class="menu-arrow"></span></a>
                                    <ul class="submenu_class" style="display: none;">
                                        <li><a href="expense-reports.html">Spending </a></li>
                                        <li><a href="invoice-reports.html">Completion </a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <style>
                    .invoice-container {
                        border: 1px solid #ccc;
                        margin-bottom: 20px;
                        padding: 20px;
                    }

                    .invoice-title {
                        color: #111111;
                        font-weight: bold;
                        font-size: medium;
                        margin-top: 0;
                        padding-bottom: 16px;
                        border-bottom: 1px solid #111111;
                    }
                </style>
                <div class="page-wrapper">
                    <div class="content container-fluid">
                    <c:forEach items="${requestScope.listinvoice}" var="i">
                        <c:set var="dayStay" value="${DateUtils.numDaysBetween(i.bookingModel.arrivalTime, i.bookingModel.departureTime)}"/>
                        <div class="row">
                            <h2 class="col-md-12"
                                style="color: #111111; font-weight: bold; font-size: medium; margin-top: 50px; padding-bottom: 16px; border-bottom: 1px solid #111111;">
                                Invoice No: ${i.id}</h2>
                        </div>
                        <div style="padding-top: 16px; padding-bottom:16px; border-bottom: 1px solid #111111;" class="row">
                            <div class="col-md-6">
                                <p style="color: #111111; font-weight: bold; font-size: large;">Confirmed: ${empty dayStay ? '' : dayStay} nights</p>
                                <p style="color: #777777">Booked By: ${empty user.fullname ? '' : user.fullname}</p>
                                <p style="color: #777777">Booking Date: ${empty i.bookingModel.bookingTime ? '' : i.bookingModel.bookingTime.toString()}</p>
                            </div>
                            <div class="col-md-6 text-right">
                                <h4>${empty i.bookingModel.hotelModel.name ? '' : i.bookingModel.hotelModel.name}</h4>
                                <p style="color: #777777">${empty i.bookingModel.hotelModel.address ? '' : i.bookingModel.hotelModel.address}</p>
                                <p style="color: #777777">${empty i.bookingModel.hotelModel.name ? '' : i.bookingModel.hotelModel.name}</p>
                            </div>
                        </div>
                        <div style="padding-top: 16px; padding-bottom:16px; border-bottom: 1px solid #111111;" class="row">
                            <ul class="col-md-6"
                                style="list-style-type: none; padding-left: 12px; font-weight: bold; border-left: 1px solid #111111; line-height: 1;">
                                ${empty i.bookingModel.numAdults && empty i.bookingModel.numChilds ? '' : i.bookingModel.numAdults + i.bookingModel.numChilds} Travelers on this stay
                                <li style="color: #777777; font-weight: normal; font-size: medium; padding-top: 12px; padding-bottom: 12px;"> Adults: ${empty i.bookingModel.numAdults ? '' : i.bookingModel.numAdults}</li>
                                <li style="color: #777777; font-weight: normal; font-size: medium; padding-top: 12px; padding-bottom: 12px;"> Children: ${empty i.bookingModel.numChilds ? '' : i.bookingModel.numChilds}</li>
                            </ul>
                            <ul class="col-md-6"
                                style="list-style-type: none; padding-left: 12px; border-left: 1px solid #111111; line-height: 1;">
                                <li style="color: #111111; font-weight: bold; font-size: medium; margin-top: 24px;">Check in: 
                                    <span style="color: #777777">${empty i.bookingModel.arrivalTime ? '' : i.bookingModel.arrivalTime.toString()}</span>
                                </li>
                                <li style="color: #111111; font-weight: bold; font-size: medium; margin-top: 32px;">Check out: 
                                    <span style="color: #777777">${empty i.bookingModel.departureTime ? '' : i.bookingModel.departureTime.toString()}</span>
                                </li>
                            </ul>
                        </div>
                        <div style="padding-top: 16px; padding-bottom:16px; border-bottom: 1px solid #111111;" class="row">
                            <div class="col-md-12">
                                <h3>Charges</h3>
                                <table class="col-md-12">
                                    <tbody>
                                        <tr>
                                            <td style="padding: 10px 15px;" colspan="3">${empty dayStay ? '' : dayStay} Nights - ${empty i.bookingModel.roomModel.roomTypeModel.roomType ? '' : i.bookingModel.roomModel.roomTypeModel.roomType} Room</td>
                                            <td style="padding: 10px 15px;" colspan="1">${empty dayStay ? '' : dayStay} X  $ ${empty i.bookingModel.roomModel.money ? '' : i.bookingModel.roomModel.money}</td>
                                            <td style="padding: 10px 15px;" colspan="1">$ ${empty dayStay || empty i.bookingModel.roomModel.money ? '' : dayStay*i.bookingModel.roomModel.money}</td>
                                        </tr>
                                        <tr>
                                            <td style="padding: 10px 15px;" colspan="4">Service Fee (Included VAT)</td>
                                            <td style="padding: 10px 15px;" colspan="1">$40</td>
                                        </tr>
                                        <tr>
                                            <td style="padding: 10px 15px;font-weight: bold;" colspan="4" class="text-center">TOTAL AMOUNT:</td>
                                            <td style="padding: 10px 15px;" colspan="1">$ ${empty dayStay || empty i.bookingModel.roomModel.money ? '' : dayStay * i.bookingModel.roomModel.money + 40}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div style="padding-top: 16px; padding-bottom:16px; border-bottom: 1px solid #111111;" class="row">
                            <div class="col-md-12">
                                <table class="col-md-12">
                                    <tbody>
                                        <tr>
                                            <td style="padding: 10px 15px; font-weight: bold;" colspan="1">Payment Details</td>
                                            <td style="padding: 10px 15px;" colspan="1">Date</td>
                                            <td style="padding: 10px 15px;" colspan="1">Transaction ID</td>
                                            <td style="padding: 10px 15px;" colspan="1">Amount</td>
                                        </tr>
                                        <tr>
                                            <td style="padding: 10px 15px;" colspan="1">American Express</td>
                                            <td style="padding: 10px 15px;" colspan="1">${empty i.paymentDate ? '' : i.paymentDate.toString()}</td>
                                            <td style="padding: 10px 15px;" colspan="1">SI2534687</td>
                                            <td style="padding: 10px 15px;" colspan="1">$ ${empty dayStay || empty i.bookingModel.roomModel.money ? '' : dayStay * i.bookingModel.roomModel.money + 40}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div style="padding-top: 16px; padding-bottom:16px;" class="row">
                            <div class="col-md-12">
                                <h3>Note:</h3>
                                <p>Here we can write additional notes for the client to get a better understanding of this invoice.</p>
                            </div>
                        </div>
                        <div style="background-color: #009688; padding-top: 8px; padding-bottom: 8px">
                            <p class="text-center font-weight-bold text-uppercase">Thank you for booking in our website!</p>
                        </div>
                    </c:forEach>
                    <input id="index"  name="index" type="hidden" value="${index}">
                    <div style="display: flex; flex-direction: row;">
                        <c:forEach begin="1" end="${endPage}" var="p">
                            <div class="numberP vuong" id="number${p}" style="width: 30px; border: black groove 2px; background-color: white; ">  

                                <c:choose>
                                    <c:when test="${not empty searchInput}">
                                        <a id="link${p}" style="text-decoration: none;"  href="invoice?index=${p}&search=${searchValue}">${p}</a>   
                                    </c:when>

                                    <c:otherwise>
                                        <a id="link${p}" style="text-decoration: none;"  href="invoice?index=${p}">${p}</a>   
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </c:forEach>    

                    </div>
                </div>
            </div>
        </div>
        <script>
            function statusLoad() {
                console.log('hello');
                var indexValue = document.getElementById("index").value;
                var numberP = document.getElementById('number' + indexValue);
                numberP.style.backgroundColor = "grey";
                var numP = document.getElementById("link" + indexValue);
                numP.style.color = "white";
            };
            statusLoad();
        </script>
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
