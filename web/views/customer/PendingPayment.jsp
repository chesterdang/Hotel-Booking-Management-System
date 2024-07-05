<%-- 
    Document   : CustomerHome
    Created on : Mar 1, 2024, 7:05:02 PM
    Author     : Nguyen Quang Hau
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
	<title>Pending Booking</title>
        <link rel="shortcut icon" type="image/x-icon" href='<c:url value="/assets/customer/assets/img/favicon.png"></c:url>'>
	<link rel="stylesheet" href='<c:url value="/assets/customer/assets/css/bootstrap.min.css"></c:url>'>
	<link rel="stylesheet" href='<c:url value="/assets/customer/assets/plugins/fontawesome/css/fontawesome.min.css"></c:url>'>
	<link rel="stylesheet" href='<c:url value="/assets/customer/assets/plugins/fontawesome/css/all.min.css"></c:url>'>
	<link rel="stylesheet" href='<c:url value="/assets/customer/assets/css/feathericon.min.css"></c:url>'>
	<link rel="stylehseet" href="https://cdn.oesmith.co.uk/morris-0.5.1.css">
	<link rel="stylesheet" href='<c:url value="/assets/customer/assets/plugins/morris/morris.css"></c:url>'>
	<link rel="stylesheet" href='<c:url value="/assets/customer/assets/css/style.css"></c:url>'> </head>
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
        <link href='<c:url value="/assets/customer/assets/css/style2.css"></c:url>' rel="stylesheet">

<body id="bodyTag"> 
	<div class="main-wrapper">
		<div class="header">
			<div class="header-left">
				<a href='<c:url value="/HomeCustomerController?action=roomHome&fetch=6&page=1"></c:url>' class="logo"> <img src='<c:url value="/assets/customer/assets/img/hotel_logo.png"></c:url>' width="50" height="70" alt="logo"> <span class="logoclass">Booking Hotel</span> </a>
				<a href='<c:url value="/HomeCustomerController?action=roomHome&fetch=6&page=1"></c:url>' class="logo logo-small"> <img src='<c:url value="/assets/customer/assets/img/hotel_logo.png"></c:url>' alt="Logo" width="30" height="30"> </a>
			</div>
                        <a href="javascript:void(0);" id="toggle_btn" onclick="openOrCloseSidebar()"> <i class="fe fe-text-align-left"></i> </a>
			<a class="mobile_btn" id="mobile_btn"> <i class="fas fa-bars"></i> </a>
			<ul class="nav user-menu">

				<li class="nav-item dropdown has-arrow">
					<a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown"> <span class="user-img"><img class="rounded-circle" src='<c:url value="${(sessionScope.user.avatar == null)?'/images/defaultUser.jpg':sessionScope.user.avatar}"></c:url>' width="31" alt="Soeng Souy"></span> </a>
					<div class="dropdown-menu">
						<div class="user-header">
                                                    <div class="avatar avatar-sm"> <img src='<c:url value="${(sessionScope.user.avatar == null)?'/images/defaultUser.jpg':sessionScope.user.avatar}"></c:url>' alt="User Image" class="avatar-img rounded-circle"> </div>
							<div class="user-text">
                                                            <h6>${sessionScope.user.fullname}</h6>
                                                                <p class="text-muted mb-0">${sessionScope.user.roleModel.name}</p>
							</div>
						</div> 
                                                <a class="dropdown-item" href="/BookingHotel_Prj301/views/customer/CustomerProfile.jsp">My Profile</a> 
                                                <a class="dropdown-item" href="<c:url value="/logout"></c:url>">Logout</a> </div>
				</li>
			</ul>
		</div>
		<div class="sidebar" id="sidebar">
			<div class="sidebar-inner slimscroll">
				<div id="sidebar-menu" class="sidebar-menu">
					<ul>
						<li class="active"> <a href='<c:url value="/HomeCustomerController?action=roomHome&fetch=6&page=1"></c:url>'><i class="fas fa-tachometer-alt"></i> <span>Home</span></a> </li>
						<li class="list-divider"></li>
						<li class="submenu"> <a href="#"><i class="fas fa-suitcase"></i> <span> Booking </span> <span class="menu-arrow"></span></a>
							<ul class="submenu_class" style="display: none;">
                                                                 <li><a href='<c:url value="/BookingController?action=paymentBooking&fetch=6&page=1"></c:url>'>Pending Payment</a></li>
								<li><a href='<c:url value="/BookingController?action=pendingBooking&fetch=6&page=1"></c:url>'>Pending Booking</a></li>
                                                                <li><a href='<c:url value="/BookingController?action=alreadyBooking&fetch=6&page=1"></c:url>'>Already Booking</a></li>
								<li><a href='<c:url value="/BookingController?action=cancelBooking&fetch=6&page=1"></c:url>'>Denied Booking</a></li>
								<li><a href='<c:url value="/BookingController?action=completedBooking&fetch=6&page=1"></c:url>'>Completed Booking</a></li>
							</ul>
						</li>
						<li class=""> <a href='<c:url value="/FavouriteRoomsController?fetch=6&page=1"></c:url>'><i class="fas fa-heart"></i> <span> Favourite List </span></a></li>
                        <li class=""> <a href='<c:url value="/invoice"></c:url>'><i class="fas fa-user"></i> <span> Invoices</span></a></li>
                        <li class=""> <a href="payments.html"><i class="fas fa-user"></i> <span> Payments</span></a></li>
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
                <!--Booking list -->
		<div class="page-wrapper">
                        <!--<!-- Alert -->
                        <c:if test= "${not empty alert}">
                            <div class="alert alert-${alert}" role="alert" style="margin-top: 50px">
                                ${msg}
                            </div>
                        </c:if>
			<div class="content container-fluid">
				<div class="page-header">
					<div class="row align-items-center">
						<div class="col">
							<div class="mt-5">
                                                            <h4 class="card-title float-left mt-2">Total Price: <span style="margin-left: 10px">${totalPrice}</span></h4>
                                           
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
										<thead>
											<tr>
												<th>Hotel</th>
												<th>Room Type</th>
												<th>Total Numbers</th>
												<th>Booking Time</th>
												<th>Arrival Date</th>
												<th>Depature Date</th>
												<th>Special Request</th>
                                                                                                <th>Price</th>
												<th class="text-right">Action</th>
											</tr>
										</thead>
										<tbody>
                                                                                    <c:if test="${sessionScope.paymentList.size()-1 >= end}">
                                                                                            <c:forEach var="i" begin="${start}" end="${end}">
                                                                                                <tr>
                                                                                                            <td>
                                                                                                               ${sessionScope.paymentList.get(i).hotelModel.name}
                                                                                                            </td>
                                                                                                            <td>${sessionScope.paymentList.get(i).roomModel.roomTypeModel.roomType}</td>
                                                                                                            <td>${sessionScope.paymentList.get(i).numAdults + sessionScope.paymentList.get(i).numChilds}</td>
                                                                                                            <td>${sessionScope.paymentList.get(i).bookingTime}</td>
                                                                                                            <td>${sessionScope.paymentList.get(i).arrivalTime}</td>
                                                                                                            <td>${sessionScope.paymentList.get(i).departureTime}</td>
                                                                                                            <td>${sessionScope.paymentList.get(i).specialReq}</td>
                                                                                                            <td>${sessionScope.paymentList.get(i).roomModel.getFormatedPrice()}</td>
                                                                                                            <td class="text-right">
                                                                                                                    <div class="dropdown dropdown-action"> <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fas fa-ellipsis-v ellipse_color"></i></a>
                                                                                                                        <div class="dropdown-menu dropdown-menu-right"><a class="dropdown-item" href="" data-toggle="modal" data-target="#delete_asset"><i class="fas fa-trash-alt m-r-5"></i>Remove</a> </div>
                                                                                                                    </div>
                                                                                                            </td>
                                                                                                            <!-- Delette Modal  -->
                                                                                                            <div id="delete_asset" class="modal fade delete-modal" role="dialog">
                                                                                                                    <div class="modal-dialog modal-dialog-centered">
                                                                                                                            <div class="modal-content">
                                                                                                                                    <div class="modal-body text-center">
                                                                                                                                                    <h3 class="delete_class">Are you sure want to delete this Asset?</h3>
                                                                                                                                            <div class="m-t-20"> <a href="#" class="btn btn-white" data-dismiss="modal">Close</a>
                                                                                                                                                <form action="BookingController" method="post">
                                                                                                                                                    <input type="hidden" name="action" value="removePayment">
                                                                                                                                                    <input type="hidden" name="position" value="${i}">
                                                                                                                                                    <button type="submit" class="btn btn-danger">Delete</button>
                                                                                                                                                </form>
                                                                                                                                            </div>
                                                                                                                                    </div>
                                                                                                                            </div>
                                                                                                                    </div>
                                                                                                            </div>
                                                                                                    </tr>
                                                                                            </c:forEach>
                                                                                     </c:if>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
                            <div style="width: 200px">
                                <div id="paypal-button-container"></div>
                            </div>
			</div>
                        
                        <!<!-- Paging -->
                        <nav aria-label="..." class="mt-4">
                            <ul id="paging" class="pagination" style="justify-content: center">
                              <!-- <li class="page-item disabled">
                                  <a class="page-link" href="#" tabindex="-1" style="color: #009688;">Previous</a>
                              </li> -->

                            </ul>
                        </nav>
                        
                        
		</div>
	</div>
   <script src="https://www.paypal.com/sdk/js?client-id=AVPk50xJV60opydzfzgS78NBICfWBcjVvnbkl_vytoYbV6DqAmxAjIrrcdXfIdIfw6g_2RB_UC6WN7tI&currency=USD"></script>
   <script>   
        var open = true;
        function openOrCloseSidebar(){
            if(open){
                document.getElementById("bodyTag").classList.add("mini-sidebar");
                open = false;
            }else{
                document.getElementById("bodyTag").classList.remove("mini-sidebar");
                open = true;
            }
        }
               
    // payment
    var totalPrice = ${price};
    totalPrice = totalPrice / 23000;
    totalPrice = totalPrice.toFixed(2);
    paypal.Buttons({
            style: {
                layout:  'vertical',
                color:   'gold',
                shape:   'pill',
                label:   'buynow'
            },

            // Sets up the transaction when a payment button is clicked
            createOrder: function(data, actions) {
              return actions.order.create({
                purchase_units: [{
                  amount: {
                    value: totalPrice, // Can reference variables or functions. Example: `value: document.getElementById('...').value`
                    currency: 'USD'
                  }
                }]
              });

            },

            // Finalize the transaction after payer approval
            onApprove: function(data, actions) {
              return actions.order.capture().then(function(orderData) {
                // Successful capture! For dev/demo purposes:
                    console.log('Capture result', orderData, JSON.stringify(orderData, null, 2));
                    var transaction = orderData.purchase_units[0].payments.captures[0];
                    alert('Transaction '+ transaction.status + ': ' + transaction.id + '\n\nSee console for all available details');
                    window.location.href = "http://localhost:9999/BookingHotel_Prj301/BookingController?action=paymentBooking&fetch=6&page=1&action2=success&start=${start}&end=${end}";
              });
            },
            onCancel:function (data){
                document.getElementById("errorForm").submit();
            }
    }).render('#paypal-button-container');
    
    
    // paging
    var url="";
    var paging = document.getElementById("paging");
    
    if(${not empty pagingUrl}){
        url ="${pagingUrl}";  
    }else{
        url = "/BookingHotel_Prj301/BookingController?action=paymentBooking&fetch=6&page=";  
    }
    
    for(let i = 1; i <= ${totalPage}; i++){
        
                        if(i === 1){
            var liTag = document.createElement("li");
            var aTag = document.createElement("a");
            var text  = document.createTextNode("Previous");
            liTag.classList.add("page-item");
            aTag.classList.add("page-link");
            if(${page} === 1){
                aTag.href=(url+${page});
            }else{
                aTag.href=(url+(${page-1}));
            }
            aTag.appendChild(text);
            liTag.appendChild(aTag);
            paging.appendChild(liTag);
        }

        var liTag = document.createElement("li");
        var aTag = document.createElement("a");
        var text  = document.createTextNode(i);
        liTag.classList.add("page-item");
        aTag.classList.add("page-link");
        aTag.href=(url+i);
        aTag.appendChild(text);
        liTag.appendChild(aTag);
        paging.appendChild(liTag);

            if(${page} === i){
            liTag.classList.add("active");
        }    

        if(i === ${totalPage}){
            var liTag = document.createElement("li");
            var aTag = document.createElement("a");
            var text  = document.createTextNode("Next");
            liTag.classList.add("page-item");
            aTag.classList.add("page-link");
            if(${page} === ${totalPage}){
                aTag.href=(url+${totalPage});
            }else{
                aTag.href=(url+${page+1});
            }
            aTag.appendChild(text);
            liTag.appendChild(aTag);
            paging.appendChild(liTag);
        }
    
    }

   </script>
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
