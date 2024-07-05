<%-- 
    Document   : DetailRoom
    Created on : Mar 6, 2024, 3:24:42 PM
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
	<title>Detail Room</title>
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
     
     	 <!-- Detail Room-->
	 <!-- <link rel="stylesheet" href="css/styleBookingDetail.css"> -->
	 <link href='<c:url value="/assets/customer/css/styleBookingDetail.css"></c:url>' rel="stylesheet">
	 <style>.ie-panel{display: none;background: #212121;padding: 10px 0;box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3);clear: both;text-align:center;position: relative;z-index: 1;} html.ie-10 .ie-panel, html.lt-ie-10 .ie-panel {display: block;}</style>
     
	 <!--Comment-->
	 <link href='<c:url value="/assets/customer/css/comment.css"></c:url>' rel="stylesheet">
	 <!-- <link rel="stylesheet" href="css/comment.css"> -->
     <!-- Libraries Stylesheet -->
     <link href='<c:url value="/assets/customer/lib/owlcarousel/assets/owl.carousel.min.css"></c:url>' rel="stylesheet">
     <link href='<c:url value="/assets/customer/lib/lightbox/css/lightbox.min.css"></c:url>' rel="stylesheet">

     <!-- Template Stylesheet -->
     <link href='<c:url value="/assets/customer/assets/css/style2.css"></c:url>' rel="stylesheet">

<body>
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
						<li class=""> <a href="<c:url value="/FavouriteRoomsController?fetch=6&page=1"></c:url>"><i class="fas fa-heart"></i> <span> Favourite List </span></a></li>
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
		<div class="page-wrapper">
            <!-- Booking detail -->
            <div class="container-fluid blog py-5">
                <!--<!-- Alert -->
                    <c:if test= "${not empty alert}">
                        <div class="alert alert-${alert}" role="alert">
                            ${msg}
                        </div>
                    </c:if>
                <section class="section mt-2">
					<div class="shell-wide">
					  <div class="range range-30 range-xs-center">
						<div class="cell-lg-8 cell-xl-9">
						  <!-- Classic slider-->
						  <section class="section">
							<!-- Room Image -->
							<div class="swiper-container swiper-slider swiper-style-2" data-loop="false" data-autoplay="5500" data-simulate-touch="false" data-slide-effect="slide" data-direction="vertical">
							  <div class="swiper-wrapper">
                                                                                         <c:if test="${room.avatar != null}">
                                                                                             <div class="swiper-slide" style="background-image: url(images/supplier/${room.avatar}); background-repeat: no-repeat; background-size: cover;"; max-width:800px; max-height: 600px;"></div>
                                                                                         </c:if>
                                                                                         <c:if test="${room.avatar == null}">
                                                                                             <div class="swiper-slide" style="background-image: url(images/defaultRoom.jpg); background-repeat: no-repeat; background-size: cover;"; max-width:800px; max-height: 600px;"></div>
                                                                                         </c:if>    
							  </div>
							</div>
						  </section>
						  <!--Add favourite room-->
						  <form action="HomeCustomerController" method="POST">
								<input type="hidden" name="action" value="addFavRoom">
								<input type="hidden" name="roomNo" value="${room.roomNo}">
								<button type="submit"  name="btnFav"  value="${favourite?'remove':'add'}" class="btn" style="background-color: rgb(213, 96, 96);">${favourite?'Remove':'Add'} Favourite</button>
						  </form>
                                                 
						    <!-- Describe Room-->
						  <div class="page-footer-minimal">
								<div class="shell-wide">
								<div class="range range-50">
									<div class="cell-sm-6 cell-md-3 cell-lg-4 wow fadeInUp" data-wow-delay=".1s">
									<div class="page-footer-minimal-inner">
										<h4>Description</h4>
										<ul class="list-unstyled">
											<li>
												<p class="rights">Type of room:<span style="color: #009688; font-size: 15px; margin-left: 4px;">${room.roomTypeModel.roomType}</span></p>
											</li>
											<li>
												<p class="rights">Room:<span style="color: #009688; font-size: 15px; margin-left: 4px;">${room.roomTypeModel.roomDesc}</span></p>
											</li>
											<li>
												<p class="rights">Occupation:<span style="color: #009688; font-size: 15px; margin-left: 4px;">${room.occupancy}<span style="color: #009688; font-size: 15px; margin-left: 4px;"></span>People</span></p>
											</li>
										</ul>
									</div>
									</div>
									<div class="cell-sm-6 cell-md-5 cell-lg-4 wow fadeInUp" data-wow-delay=".2s">
									<div class="page-footer-minimal-inner">
										<h4>Price</h4>
										<ul class="list-unstyled">
											<li>
												<p class="rights">Price:<span style="color: #009688; font-size: 30px;">${room.getFormatedPrice()}</span></p>
											</li>
											<li>
												<p class="rights">Include:<span style="color: #009688; font-size: 15px; margin-left: 4px;">${room.priceIncludes}</span></p>
											</li>
										</ul>
									</div>
									</div>
									<div class="cell-sm-6 cell-md-5 cell-lg-4 wow fadeInUp" data-wow-delay=".2s">
										<div class="page-footer-minimal-inner">
										<h4>Address</h4>
										<ul class="list-unstyled">
											<li>
												<p class="rights">Location:<span style="color: #009688; font-size: 15px; margin-left: 4px;">${room.hotelModel.address}</span></p>
											</li>
											<li>
												<p class="rights">Phone:<span style="color: #009688; font-size: 15px; margin-left: 4px;">${room.hotelModel.phone}</span></p>
											</li>
										</ul>   
										</div>
										</div>
								</div>
								</div>
						  </div>
						</div>
						<div class="cell-lg-4 cell-xl-3 reveal-lg-flex">
						  <div class="hotel-booking-form">
							<h3>Book a Room</h3>
							<!-- Booking form-->
                                                        <form action="BookingController" method="post"  class="rd-mailform" data-form-output="form-output-global" data-form-type="contact" onsubmit="return validateForm()">
							  <div class="range range-sm-bottom spacing-20">
								<div class="cell-lg-12 cell-md-4 cell-sm-6">
								  <p class="text-uppercase">Arrival</p>
								  <div class="form-wrap">
                                                                      <input class="form-input" id="date-in" type="datetime-local" name="arrivalDate" required="">
								  </div>
								</div>
								<div class="cell-lg-12 cell-md-4 cell-sm-6">
								  <p class="text-uppercase">Departure</p>
								  <div class="form-wrap">
                                                                      <input class="form-input" id="date-out" type="datetime-local" name="departureDate" required="">
								  </div>
								</div>
								<div class="cell-lg-6 cell-md-4 cell-xs-6">
								  <p class="text-uppercase">Adults</p>
								  <div class="form-wrap form-wrap-validation">
									<!--Select 2-->
                                                                        <select name="numOfAdults" class="form-input select-filter" data-minimum-results-search="-1" data-placeholder="1" required="">
									  <option value="1">1</option>
									  <option value="2">2</option>
									  <option value="3">3</option>
									  <option value="4">4</option>
									  <option value="5">5</option>
									</select>
								  </div>
								</div>
								<div class="cell-lg-6 cell-md-4 cell-xs-6">
								  <p class="text-uppercase">Children</p>
								  <div class="form-wrap form-wrap-validation">
									<!--Select 2-->
                                                                        <select name="numOfChilds" class="form-input select-filter" data-minimum-results-search="-1" data-placeholder="0" data-constraints="@Required" required="">
									  <option value="0">0</option>
									  <option value="1">1</option>
									  <option value="2">2</option>
									  <option value="3">3</option>
									  <option value="4">4</option>
									</select>
								  </div>
								</div>
								<div class="cell-lg-12 cell-md-4">
									<p class="text-uppercase">Special Request</p>
									<div class="form-wrap">
                                                                            <input name="specReq" class="form-input" id="contact-first-name" type="text" data-constraints="@Required" required="">
									</div>
								</div>
                                                                <input type="hidden" name="roomNo" value="${room.roomNo}">
								<div class="cell-lg-12 cell-md-4">
								  <button class="button button-primary button-square button-block button-effect-ujarak " type="submit"><span>Booking</span></button>
								</div>
							  </div>
							</form>
						  </div>
						</div>
					  </div>
					</div>
				  </section>
                  
				
                <!--Feedback-->
				<div class="container justify-content-center mt-5 border-left border-right">
					<!--writeFeedback-->
                                        <c:if test="${sessionScope.user != null && booked}">
                                            <c:if test="${sessionScope.user.roleModel.code == 'Cust'}">
                                                <form action="HomeCustomerController" method="post" class="d-flex justify-content-center pt-3 pb-2">
                                                   <input type="hidden" name="action" value="feedback">
                                                    <input type="hidden" name="roomNo" value="${room.roomNo}">
                                                    <input type="text" name="content" placeholder="Input your Feedback" class="form-control addtxt" required>
                                                   <button class="btn btn-primary py-2 px-4" type="submit">Submit</button>
                                               </form>
                                            </c:if>
                                        </c:if>
					<!--End writeFeedback-->
						<c:forEach var="feedback" items="${feedbacks}">
							<div class="d-flex justify-content-center py-2">
								<div class="second py-2 px-2">
                                                                        <div class="d-flex justify-content-between py-1 pt-2">
                                                                            <span class="text1 d-flex justify-content-start">${feedback.content}</span>
                                                                            <c:if test="${feedback.customerModel.id == sessionScope.user.id}">
                                                                                <form action="HomeCustomerController" method="post" class="d-flex justify-content-end">
                                                                                    <input type="hidden" name="action" value="deletedFeedback">
                                                                                    <input type="hidden" name="roomNo" value="${room.roomNo}">
                                                                                    <input type="hidden" name="feedbackID" value="${feedback.id}">
                                                                                    <button class="btn py-2 px-4" style="color: red" type="submit">Delete</button>
                                                                                </form>
                                                                            </c:if>
                                                                        </div>
									<div class="d-flex justify-content-between py-1 pt-2">
										<c:choose>
												<c:when test="${feedback.customerModel.avatar != null}">
														<div class="d-flex justify-content-start">
															<img src="images/avatar/${feedback.customerModel.avatar}" width="18">
															<span class="text2">${feedback.customerModel.fullname}</span>
														</div>
														<div class="d-flex justify-content-end">
															<span class="text1">${feedback.createdDate}</span>
														</div>
												</c:when>
												<c:otherwise>
														<div class="d-flex justify-content-start">
															<img src="images/defaultUser.jpg" width="18">
															<span class="text2">${feedback.customerModel.fullname}</span>
														</div>
														<div class="d-flex justify-content-end">
															<span class="text1">${feedback.createdDate}</span>
														</div>
												</c:otherwise>
										</c:choose>
									</div>
									<!-- <div><img src="https://i.imgur.com/AgAC1Is.jpg" width="18"><span class="text2">Martha</span></div> -->
								</div>
							</div>
						</c:forEach>
                                              <!<!-- Paging -->
                                                <nav aria-label="..." class="mt-4">
                                                    <ul id="paging" class="pagination" style="justify-content: center">
                                                      <!-- <li class="page-item disabled">
                                                          <a class="page-link" href="#" tabindex="-1" style="color: #009688;">Previous</a>
                                                      </li> -->

                                                    </ul>
                                                </nav>
					<!-- <div class="d-flex justify-content-center py-2 pb-3">
						<div class="second py-2 px-2"> <span class="text1">Type your note, and hit enter to add it</span>
							<div class="d-flex justify-content-between py-1 pt-2">
								<div><img src="https://i.imgur.com/tPvlEdq.jpg" width="18"><span class="text2">Curtis</span></div>
								<div><span class="text3">Upvote?</span><span class="thumbup"><i class="fa fa-thumbs-o-up"></i></span><span class="text4 text4o">1</span></div>
							</div>
						</div>
					</div> -->
				</div>
            </div>
		</div>
	</div>
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
              
              // paging
              var url = "/BookingHotel_Prj301/HomeCustomerController?action=detailRoom&roomNo=${room.roomNo}&fetch=6&page=";  
		   var paging = document.getElementById("paging");

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
            
            
            // check valid  arrival date
            document.getElementById("date-in").addEventListener("change", function() {
                var selectedArrivalDate = new Date(document.getElementById("date-in").value);
                var currentDate = new Date();

                // Check if the selected arrival date is in the past
                if (selectedArrivalDate < currentDate) {
                    displayError("Please select a future date for arrival.");
                    document.getElementById("date-in").value = ""; // Reset the input value
                }
            });
            
            // check valid departure date
            document.getElementById("date-out").addEventListener("change", function() {
                var selectedArrivalDate = new Date(document.getElementById("date-out").value);
                var currentDate = new Date();

                // Check if the selected departure date is in the past
                if (selectedArrivalDate < currentDate) {
                    displayError("Please select a future date for departure.");
                    document.getElementById("date-out").value = ""; // Reset the input value
                }
            });
            
            // check departure date is greater than arrival date
            document.getElementById("date-out").addEventListener("change", function() {
                var selectedDepartureDate = new Date(document.getElementById("date-out").value);
                var selectedArrivalDate = new Date(document.getElementById("date-in").value);

                // Calculate the minimum departure date (arrival date + 1 day)
                var minDepartureDate = new Date(selectedArrivalDate);
                minDepartureDate.setDate(selectedArrivalDate.getDate() + 1);

                // Check if the selected departure date is before or the same as the minimum departure date
                if (selectedDepartureDate < minDepartureDate) {
                    displayError("Departure date must be at least 1 day greater than arrival date.");
                    document.getElementById("date-out").value = ""; // Reset the input value
                }
            });
            
            
            
            // check Booking form
            function validateForm() {
            // Get form inputs
            var arrivalDateInput = document.getElementById("date-in");
            var departureDateInput = document.getElementById("date-out");
            var numOfAdults = document.getElementsByName("numOfAdults")[0].value;
            var numOfChildren = document.getElementsByName("numOfChilds")[0].value;
            var specReq = document.getElementById("contact-first-name").value;

            // Validate the number of Adults and Children
            if (numOfAdults == 0) {
                displayError("Please select at least one adult");
                return false;
            }
            
            // validate occupation
            if((parseInt(numOfAdults)+parseInt(numOfChildren)) > ${room.occupancy}){
                displayError("Please choose choose a maximum of "+${room.occupancy}+" people");
                return false;
            }

            // Validate Special Request
            if (specReq.trim() === "") {
                displayError("Special request field cannot be empty");
                return false;
            }
            
            


            return true;
        }

        function displayError(message) {
            // Display error message to the user
            alert(message);
        }

        document.addEventListener("DOMContentLoaded", function() {
            // Your JavaScript code here
            // Restrict departure date to one day after arrival date
            document.getElementById("date-in").addEventListener("change", function() {
                var arrivalDate = new Date(this.value);
                var departureDateInput = document.getElementById("date-out");
                var minDepartureDate = new Date(arrivalDate);
                minDepartureDate.setDate(arrivalDate.getDate() + 1);
                departureDateInput.min = minDepartureDate.toISOString().split("T")[0];
            });

            // Restrict both arrival and departure dates to current date and future dates
            var today = new Date();
            var todayString = today.toISOString().split("T")[0];
            document.getElementById("date-in").min = todayString;
            document.getElementById("date-out").min = todayString;
        });
        
        
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

