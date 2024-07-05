<%--
    Document   : ReportList
    Created on : Mar 10, 2024, 6:59:19 PM
    Author     : quandba
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="assets/AdminSpace/css/mainlist.css"/>
        <link rel="stylesheet" href="assets/AdminSpace/css/listSupCus.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/AdminSpace/css/MainList.css"/>
        <link rel="stylesheet" href="assets/AdminSpace/css/list_supcus.css"/>
        <link rel="stylesheet" href="assets/AdminSpace/css/bootstrap-datetimepicker.min.css"/>
        <link rel="stylesheet" href="assets/AdminSpace/css_include/style.css">
        <link rel="stylesheet" href="assets/AdminSpace/AdminSpace/css_include/style2.min.css">
        <link rel="stylesheet" href="assets/AdminSpace/css_include/select2.min.css">
        <link rel="stylesheet" href="assets/AdminSpace/css_include/feathericon.min.css">
        <link rel="stylesheet" href="assets/AdminSpace/css_include/bootstrap.min.css">
        <link rel="shortcut icon" type="image/x-icon" href="images/admin.jpeg">
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Report</title>
        <style>
            .vuong{
                border-radius: 5px;
                display: flex;
                justify-content: center;
                margin-right: 5px;
            }
            .input {
               padding: 5px 10px;
               border-radius: 100px;
            }
            .mr{

                margin-right: 90px;
            }
            .user {
                display: flex;
                align-items: flex-start;
            }

            .user__name {
                text-overflow: ellipsis;
                white-space: nowrap;
                overflow: hidden;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="container-fluid">

                <a class="navbar-brand"  href="MainList.jsp">
                    <img src="images/admin.jpeg" alt="Logo" height="64" class="d-inline-block align-text-top mb-2">
                </a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item"><a class="nav-link active"
                                                    ria-current="page" href="#">Admin Space</a></li>
                            </li>
                        </ul>
                    </ul>
                    <div class="d-flex" role="search" style="position: relative;display: block;float: right;">
                        <div id="carouselExampleAutoplaying" class="carousel slide mr" data-bs-ride="carousel">
                            <div class="carousel-inner">
                                 <div class="carousel-item active ">
                                    <img src="images/Booking1.png" class="d-block w-100 rounded" alt="...">
                                </div>
                                <div class="carousel-item">
                                    <img src="images/Booking(3).png" class="d-block w-100 rounded" alt="...">
                                </div>
                                <div class="carousel-item">
                                    <img src="images/Booking2.png" class="d-block w-100 rounded" alt="...">
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




                        <div class="dropdown">
                            <a
                                class="nav-link dropdown-toggle mr" href="#" role="button"
                                data-bs-toggle="dropdown" aria-expanded="false"> Tài khoản <br>
                                <b>${user.fullname}</b>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <span class="nav-link">
                                        <img class="rounded-circle" src ="" width="31" alt="Soeng Souy">
                                    </span>
                                </li>
                                <li>
                                    <a class="dropdown-item " href="doimatkhau">
                                        <input type="hidden">Đổi Mật Khẩu</button>
                                    </a>
                                </li>

                                <li><a class="dropdown-item" href="#">Thoát</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
        <%@include file="Include/sidebar.jsp"%>
        <div class="main-wrapper">
            <div class="page-wrapper">
                <div class="content container-fluid">

                        <input id="searchValue" type="text" placeholder="Search" class="input" name="searchValue" value="${searchValue}" >

                        <button class="btn btn-outline-success" onclick="search()" >SEARCH</button>
                    <div class="page-header">
                        <div class="row align-items-center">
                            <div class="col">
                                <div class="mt-5">
                                    <h4 class="card-title float-left mt-2">Report</h4>
                                    <div class="mt-5 float-right">
                                        <input type="hidden" value="${sortType}">
                                        <select id="sortType" name="sortType" class="btn-quan btn btn-secondary dropdown-toggle ">
                                            <option value="numASC" ${sortType == 'numASC' ? 'selected' : ''}>ASC id</option>
                                            <option value="numDESC" ${sortType == 'numDESC' ? 'selected' : ''}>DESC id</option>
                                            <option value="az" ${sortType == 'az' ? 'selected' : ''}>A-Z</option>
                                            <option value="za" ${sortType == 'za' ? 'selected' : ''}>Z-A</option>
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
                                                    <th>ID</th>
                                                    <th>CustomerId</th>
                                                    <th>CustomerModel</th>
                                                    <th>RoomNo</th>
                                                    <th>CreatedDate</th>
                                                    <th>Content</th>
                                                    <th>Hotel_id</th>
                                                    <th>Supplier_id</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="p" items="${list_report}">
                                                    <tr >
                                                        <td>${p.id}</td>
                                                        <td>${p.customerModel.id}</td>
                                                        <td>${p.customerModel.fullname}</td>
                                                        <td>${p.roomModel.roomNo}</td>
                                                        <td>${p.createdDate}</td>
                                                <div class="user">
                                                    <td class="user__name">${p.content}</td>
                                                </div>

                                                <td>${p.roomModel.hotelModel.id}</td>

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
                                                        <a id="link${i}" style="text-decoration: none;"  href="list_report?index=${i}&action=${sortType}&search=${searchValue}">${i}</a>
                                                    </c:when>

                                                    <c:otherwise>
                                                        <a id="link${i}" style="text-decoration: none;"  href="list_report?index=${i}&action=${sortType}">${i}</a>
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
        <script>

            function search() {
                var searchValue = document.getElementById('searchValue').value;
                var indexValue = document.getElementById("index").value;
                if (searchValue == "") {
                    alert('null');
                } else {
                    window.location.href = 'list_report?action=numASC&search=' + searchValue + "&index=" + indexValue + "";
                    console.log('list_report?action=numASC&search=' + searchValue + "&index=" + indexValue + "");
                }

            }

            document.getElementById('sortType').onchange = function () {
                var searchValue = document.getElementById('searchValue').value;
                console.log(searchValue);
                var selectedOption = document.getElementById('sortType').value;
                if (searchValue != "") {
                    window.location.href = 'list_report?action=' + selectedOption + '&search=' + searchValue;
                } else {
                    window.location.href = 'list_report?action=' + selectedOption;
                }
            }



        </script>
    </body>
</html>