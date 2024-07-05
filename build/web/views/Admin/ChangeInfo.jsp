<%--
    Document   : ChangeInfo
    Created on : Mar 12, 2024, 9:12:48 PM
    Author     : quandba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" type="image/x-icon" href="images/admin.jpeg">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Change Information</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
            crossorigin="anonymous">
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
            integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
        crossorigin="anonymous"></script>
        <style>
            .red {
                color: red;
            }
        </style>
    </head>
    <body>

        <div class="main-wrapper">   
            <c:set var="mess" value="${requestScope.mess}" />
            <c:if test="${not empty mess and mess eq 'Update profile successfully'}">
                <div id="successMessage" class="success-message">${mess}</div>
            </c:if>
            <div class="page-wrapper">
                <div class="content container-fluid">

                    <div class="page-header">
                        <div class="row align-items-center">
                            <div class="col">
                                <h3 class="page-title mt-5">Edit Profile</h3>
                            </div>
                        </div>
                    </div>
                    <form action="changeinfo" method="POST" object="${adminModel}" >
                        <input name="id" value="${adminModel.id}" type="hidden">
                        <div class="box inform_css">
                            <p class="card-title title_menu">Basic Informations</p>
                            <div class="row">
                                <div class="col-lg-12">

                                    <div class="row formtype">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Full Name</label>
                                                <input class="form-control" name="fullname" type="text" id="fullname" value="${adminModel.fullname}">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Birth Date</label>
                                                <div class="">
                                                    <input type="date" name="dob" class="form-control" value="${adminModel.dob}">
                                                </div>
                                            </div>
                                        </div>

                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="box inform_css mt-3">
                            <p class="card-title title_menu">Contact Informations</p>
                            <div class="row">
                                <div class="col-lg-12">

                                    <div class="row formtype">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Address</label>
                                                <input type="text" name="address" class="form-control" id="address" value="${adminModel.address}">
                                            </div>
                                        </div>

                                        <!--pattern="[0-9]{10,12}"-->
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Phone Number</label>

                                                <input class="form-control" name="phone" id="phone" type="text"  value="${adminModel.phone}">
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="dongYDieuKhoan" class="form-label">
                                Đồng ý  <a> thay đổi thông tin </a>
                                <span class="red">*</span>
                            </label> 
                            <input type="checkbox" class="form-check-input" id="dongYDieuKhoan" 
                                   name="dongYDieuKhoan"
                                   onchange="xuLyChonDongY()">
                        </div>
                        <input class="btn btn-primary form-control" type="submit"
                               value="Lưu thông tin" name="submit" id="submit" style="visibility: hidden;"  />

                        <a class="btn btn-primary mt-5" style="white-space: nowrap;" href="Main_ListController">
                            Go Back
                        </a>
                    </form>
                </div>
            </div>

        </div>


        <script data-cfasync="false" src="../../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
        <script src="assets/AdminSpace/js/jquery-3.5.1.min.js"></script>
        <script src="assets/AdminSpace/js/popper.min.js"></script>
        <script src="assets/AdminSpace/js/bootstrap.min.js"></script>
        <script src="assets/AdminSpace/js/moment.min.js"></script>
        <script src="assets/AdminSpace/js/select2.min.js"></script>
        <script src="assets/AdminSpace/plugins/slimscroll/jquery.slimscroll.min.js"></script>
        <script src="assets/AdminSpace/js/bootstrap-datetimepicker.min.js"></script>
        <script src="assets/AdminSpace/js/script.js"></script>
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
                z-index: 3;
            }
        </style>
        <script>
                                       document.addEventListener('DOMContentLoaded', function () {
                                           var successMessage = document.getElementById('successMessage');
                                
                                           successMessage.style.display = 'block';
                                       
                                           setTimeout(function () {
                                               successMessage.style.opacity = '0';
                                               setTimeout(function () {
                                                   successMessage.style.display = 'none';
                                               }, 1000);
                                           }, 1000); 
                                       });


                                       function xuLyChonDongY() {
                                           var dongYDeuKhoan = document.getElementById("dongYDieuKhoan");
                                           var inputValuefullname = document.getElementById("fullname").value;
                                           var inputValueaddress = document.getElementById("address").value;
                                           var inputValuephone = document.getElementById("phone").value;
                                           if (inputValuephone.length !== 10) {
                                               alert("Số điện thoại của bạn không đúng");
                                               document.getElementById("submit").style.visibility = "hidden";
                                           } else {
                                               if (dongYDeuKhoan.checked == true && inputValuefullname.trim() !== "" && inputValueaddress.trim() !== "") {
                                                   document.getElementById("submit").style.visibility = "visible";
                                               } else {
                                                   document.getElementById("submit").style.visibility = "hidden";
                                               }

                                           }



                                       }

        </script>
    </body>

</body>
</html>
