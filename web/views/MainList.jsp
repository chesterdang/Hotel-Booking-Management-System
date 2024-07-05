<%--
    Document   : MainList
    Created on : Mar 7, 2024, 12:39:03 AM
    Author     : quandba
--%>

<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@page import="model.AdminModel"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
        <script src="assets/AdminSpace/js/Map.js" type="text/javascript"></script>
        <link rel="stylesheet" href="assets/AdminSpace/css/mainlist.css"/>
        <link rel="stylesheet" href="assets/AdminSpace/css/listSupCus.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="images/admin.jpeg">

        <link rel="stylesheet" href="assets/AdminSpace/css_include/mainlist.css"/>
        <link rel="stylesheet" href="assets/AdminSpace/css/list_supcus.css"/>
        <link rel="stylesheet" href="assets/AdminSpace/css/bootstrap-datetimepicker.min.css"/>
        <link rel="stylesheet" href="assets/AdminSpace/css_include/style.css">
        <link rel="stylesheet" href="assets/AdminSpace/AdminSpace/css_include/style2.min.css">
        <link rel="stylesheet" href="assets/AdminSpace/css_include/select2.min.css">
        <link rel="stylesheet" href="assets/AdminSpace/css_include/feathericon.min.css">
        <link rel="stylesheet" href="assets/AdminSpace/css_include/bootstrap.min.css">

        <script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            .modal {
                top: 10%;
            }

            .table td, table th{
                text-align: center;
            }
            .btn-fix {
                border: none;
                color: blue;
                background: none;
            }

            .btn-fix:active,
            .btn-fix:focus {
                outline: none;
                border: none;
            }
            .chart{
                width: 600px;
                height: 300px;
                display: block;
            }

            .numbers{
                color: #fff;
                margin: 0;
                padding: 0;
                width: 50px;
                height: 100%;
                display: inline-block;
                float: left;
            }

            .numbers li{
                list-style: none;
                height: 150px;
                position: relative;
                bottom: 145px;
            }

            .numbers span{
                font-size: 12px;
                font-weight: 600;
                position: absolute;
                bottom: 0;
                right: 10px;
                color: red;
            }

            .bars{
                color: #fff;
                font-size: 12px;
                font-weight: 600;
                background: #555;
                margin: 0;
                padding: 0;
                display: inline-block;
                width: 500px;
                height: 300px;
                box-shadow: 0 0 10px 0 #555;
                border-radius: 5px;
            }

            .bars li{
                display: table-cell;
                width: 100px;
                height: 300px;
                position: relative;
            }

            .bars span{
                width: 100%;
                position: absolute;
                bottom: -30px;
                text-align: center;
                color: red;
                margin-bottom: 9px;
            }
            .bars .bar{
                display: block;
                background: #17C0EB;
                width: 50px;
                position: absolute;
                bottom: 0;
                margin-left: 25px;
                text-align: center;
                box-shadow: 0 0 10px 0 rgba(23, 192, 235, 0.5);
                transition: 0.5s;
                transition-property: background, box-shadow;
            }
            .bars .bar:hover{
                background: #55EFC4;
                box-shadow: 0 0 10px 0 rgba(85, 239, 196, 0.5);
                cursor: pointer;

            }
            .bars .bar:before{
                color: #fff;
                content: attr(data-percentage) '%';
                position: relative;
                bottom: 20px;
            }
            .ml{
                display: flex;
                justify-content: center;
                align-content: center;
                width: 50%;
                margin-left: 900px;
            }
            .ju{
                display: flex;
                margin:  20px 0;
            }
            .mltitle{
                margin-left: 112px;
            }
            .des{
                display: flex;
                justify-content: center;
                align-items: center;
                margin-left: 0 auto;
            }
            .des .span1 {
                margin-left:  150px;
                display: inline-block;
                font: bold 3.5em/1.5 Bebas, sans-serif;
                color: #5CA17C; /*non-webkit fallback*/
                font-size: 40px;
                text-transform: uppercase;
                background-image: linear-gradient(to bottom, #26BDA6, #FF9F65, #DED37E, #26BDA6);
                background-size: auto 250%;
                transition: background-position 0.5s;
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
                line-height: 200px;
                background-position: 0 100%;
            }
            .des .span1 {
                background-position: 0 0;
                cursor: pointer;
            }
            .des .span2 {

                display: inline-block;
                font: bold 3.5em/1.5 Bebas, sans-serif;
                color: #5CA17C;
                font-size: 40px;
                text-transform: uppercase;
                background-image: linear-gradient(to bottom, #26BDA6, #FF9F65, #DED37E, #26BDA6);
                background-size: auto 250%;
                transition: background-position 0.5s;
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
                line-height: 200px;
                background-position: 0 100%;
            }
            .mr{
                margin-left: 80px;
            }
            .mb{
                margin-bottom: 28px;
            }
            .h{
                height: 105px;
            }
            .nho {
                width: 500px !important;
                height: 400px !important;
            }
            .t{
                display: flex;
                justify-content: space-evenly;
            }
            .mxin {
                margin-right:  80px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="container-fluid h">

                <div class="collapse navbar-collapse t" id="navbarSupportedContent">
                    <a class="navbar-brand mb"  href="MainList.jsp">
                        <img src="images/admin.jpeg" alt="Logo" height="64" class="d-inline-block align-text-top mb-2">
                        <a class="nav-link active" ria-current="page" href="#">Admin</a>
                    </a>

                    <form class="d-flex" role="search" style="position: relative;display: block;float: right;">
                        <div id="carouselExampleAutoplaying " class="carousel slide " data-bs-ride="carousel">
                            <div class="carousel-inner">
                                <div class="carousel-item active ">
                                    <img src="images/Booking1.png" class="d-block w-80 rounded" alt="...">
                                </div>
                                <div class="carousel-item">
                                    <img src="images/Booking(3).png" class="d-block w-80 rounded" alt="...">
                                </div>
                                <div class="carousel-item">
                                    <img src="images/Booking2.png" class="d-block w-80 rounded" alt="...">
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                        <c:set var="username" value="admin"   scope="session"/>
                        <c:set var="id" value="2"  scope="session"/>


                    </form>
                    <div class="dropdown mxin ">
                        <a
                            class="nav-link dropdown-toggle" href="#" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false"> Tài khoản<br>
                              <b>${user.fullname}</b>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <span class="nav-link">
                                    <img class="rounded-circle" src ="" width="31" alt="Soeng Souy">
                                </span>
                            </li>
                            <li>
                                <a class="dropdown-item" href="doimatkhau">
                                    <input type="hidden">Đổi Mật Khẩu</input>
                                </a>
                            </li>

                            <li>
                                <a class="dropdown-item" href="changeinfo?id=${id}">
                                    <input type="hidden">Thay đổi thông tin</input>
                                </a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="#">Thoát</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <%@ include file="Admin/Include/sidebar.jsp" %>
        <div class="title-page mltitle">
            Number of suppliers and customers registered each month
        </div>
        <div class="row ml">
            <div class="col-sm-12 ml">

                <div class="card-body booking_card">
                    <div class="table-responsive roww " style=" display: flex; margin-left: 100px">
                        <!--                        <c:set var="models" value="${numberSupplierModels}" />
                                                <div class="chart ju">
                                                    <ul class="numbers">
                                                        <li class="mt-2"><span>10%</span></li>
                                                        <li><span>5%</span></li>
                                                        <li><span>0%</span></li>
                                                    </ul>
                                                    <ul class="bars mr-5">
                        <c:forEach var="element" items="${models}" >
                            <li>
                                <div class="bar" data-percentage="${element.value}"></div>
                                <span> Tháng : ${element.key} </span>
                            </li>
                        </c:forEach>
                    </ul>
                </div>    -->


                        <canvas class="nho" id="sale_revenue"></canvas>
                        <canvas class="nho" id="sale_revenue_2"></canvas>

                        <!--                        <c:set var="models" value="${numberCustomerModels}" />
                                                <div class="chart ju">
                                                    <ul class="numbers">
                                                        <li class="mt-2"><span>10%</span></li>
                                                        <li><span>5%</span></li>
                                                        <li><span>0%</span></li>
                                                    </ul>
                                                    <ul class="bars mr-5">
                        <c:forEach var="element" items="${models}" >
                            <li>
                                <div class="bar" data-percentage="${element.value}">

                                </div>
                                <span> Tháng : ${element.key} </span>

                            </li>
                        </c:forEach>
                    </ul>
                </div>-->


                    </div>
                    <div class="des">
                        <span class="span1">Supplier</span>
                        <div style="width : 500px;"></div>
                        <span class="span2">Customer</span>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(function () {
            // Tính tổng của tất cả các giá trị
            var total = 0;
            $('.bars li .bar').each(function () {
                total += parseInt($(this).data('percentage'));
            });
            // Lặp qua từng phần tử và tính phần trăm
            $('.bars li .bar').each(function () {
                var percentage = parseInt($(this).data('percentage'));
                var percentOfTotal = (percentage / total) * 100;
                // Thực hiện animation với phần trăm tính được
                $(this).animate({
                    'height': percentOfTotal;
                }, 1000);
            });
        });
    </script>

    <script
        src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js">
    </script>
    <script type="text/javascript">

        var registrationNumbers_cus = ${registrationNumbers_cus};
        var datas_cus = [];
        registrationNumbers_cus.forEach(function (number) {
            datas_cus.push(number);
        });

        var nonZeroMonths_cus = ${nonZeroMonths_cus};
        var labels = [];
        nonZeroMonths_cus.forEach(function (month) {
            labels.push("month" + month);
        });



        var registrationNumbers_sup = ${registrationNumbers_sup}
        var datas_sup = [];
        registrationNumbers_sup.forEach(function (number) {
            datas_sup.push(number);
        });
//
        var nonZeroMonths_sup = ${nonZeroMonths_sup};
        var labels_s = [];
        nonZeroMonths_sup.forEach(function (month) {
            labels_s.push("month" + month);
        });



        var chart = document.getElementById("sale_revenue");
        var myChart = new Chart(chart, {
            type: "line",
            data: {
                labels: labels_s,
                datasets: [

                    {
                        label: "Supplier",
                        data: datas_sup,
                        backgroundColor: "rgba(0, 156, 255, .5)",

                    }

                ]

            },

            options: {
                responsive: true
            }
        });

        var chart = document.getElementById("sale_revenue_2");
        var myChart = new Chart(chart, {
            type: "line",
            data: {
                labels: labels,
                datasets: [

                    {
                        label: "Customer",
                        data: datas_cus,
                        backgroundColor: "rgba(255, 0, 0, .5)",

                    }

                ]

            },

            options: {
                responsive: true
            }
        });
    </script>


</body>

</html>
