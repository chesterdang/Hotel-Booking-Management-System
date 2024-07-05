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
                <div class="main-wrapper">   
                    <div class="page-wrapper">
                        <div class="content container-fluid">

                            <input id="searchValue" type="text" placeholder="Search" class="input" name="searchValue" value="${searchValue}" >

                        <button style="margin-top: 40px" class="btn btn-outline-success" onclick="search()" >SEARCH</button>  
                        <div class="page-header">
                            <div class="row align-items-center">
                                <div class="col">
                                    <div class="mt-5">
                                        <h4 class="card-title float-left mt-2">Report</h4> 
                                        <div class="mt-5 float-right">                                  
                                            <input type="hidden" value="${sortType}">
                                            <select id="sortType" name="sortType" class="btn-quan btn btn-secondary dropdown-toggle ">
                                                <option value="DateDESC" ${sortType == 'DateDESC' ? 'selected' : ''}>DESC Date</option>
                                                <option value="DateASC" ${sortType == 'DateASC' ? 'selected' : ''}>ASC Date</option>
                                            </select> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="card card-table">
                                    <div class="card-body booking_card">
                                        <div class="table-responsive">
                                            <table class="datatable table table-stripped table table-hover table-center mb-0">
                                                <thead class="thead-dark">
                                                    <tr>
                                                        <td>Hotel Name</td>
                                                        <th>Room No</th>                                            
                                                        <th>Created Date</th> 
                                                        <th>Content</th> 
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="p" items="${list_report}">
                                                        <tr>       
                                                            <td>${p.roomModel.hotelModel.name}</td>
                                                            <td>${p.roomModel.roomNo}</td>      
                                                            <td>${p.createdDate}</td>      
                                                            <td>${p.content}</td>  
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>

                                        </div>
                                        <c:set var="searchInput" value="${requestScope.searchValue}" />
                                        <input id="index"  name="index" type="hidden" value="${index}">
                                        <div style="display: flex; flex-direction: row;">
                                            <c:forEach begin="1" end="${endPage}" var="i">
                                                <div class="numberP vuong" id="number${i}" style="width: 30px; border: black groove 2px; background-color: white; ">  

                                                    <c:choose>
                                                        <c:when test="${not empty searchInput}">
                                                            <a id="link${i}" style="text-decoration: none;"  href="listreport?index=${i}&action=${sortType}&search=${searchValue}">${i}</a>   
                                                        </c:when>

                                                        <c:otherwise>
                                                            <a id="link${i}" style="text-decoration: none;"  href="listreport?index=${i}&action=${sortType}">${i}</a>   
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </c:forEach>    

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <style>
            .selected {
                background-color: grey;
            }
        </style>
        <script>

            function search() {
                var searchValue = document.getElementById('searchValue').value;
                var indexValue = document.getElementById("index").value;
                if (searchValue === "") {
                    alert('null');
                } else {
                    window.location.href = 'listreport?action=DateDESC&search=' + searchValue + "&index=" + indexValue + "";
                    console.log('listreport?action=DateDESC&search=' + searchValue + "&index=" + indexValue + "");
                }
            }

            document.getElementById('sortType').onchange = function () {
                var searchValue = document.getElementById('searchValue').value;
                console.log(searchValue);
                var selectedOption = document.getElementById('sortType').value;
                if (searchValue !== "") {
                    window.location.href = 'listreport?action=' + selectedOption + '&search=' + searchValue;
                } else {
                    window.location.href = 'listreport?action=' + selectedOption;
                }
            };
            
            function statusLoad() {
                    console.log('hello');
                    var indexValue = document.getElementById("index").value;
                    var numberP = document.getElementById('number' + indexValue);
                    numberP.style.backgroundColor = "grey";
                    var numP = document.getElementById("link"+indexValue);
                    numP.style.color="white";
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
