<%-- 
    Document   : List_BB
    Created on : Mar 16, 2024, 10:17:04 PM
    Author     : quandba
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="assets/AdminSpace/css_include/supplier.css" rel="stylesheet" type="text/css"/>
        <link href="assets/AdminSpace/css/listSupCus.css"/>
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
            #sortType {
                background-color: gray;
                padding: 10px 20px;
            }
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

        </style>
    </head>
    <body onload="statusLoad()">
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
                    <form class="d-flex" role="search" style="position: relative;display: block;float: right;">
                        <input name="inputSearch" class="form-control me-2 w-75" type="search"
                               placeholder="Nội dung tìm kiếm" aria-label="Search">
                        <input type="hidden" name="action" value="searchCustomer" >

                        <button class="btn btn-outline-success" type="submit">Tìm</button>         
                        <div class="dropdown">
                            <a
                                class="nav-link dropdown-toggle" href="#" role="button"
                                data-bs-toggle="dropdown" aria-expanded="false"> Tài khoản <br>
                                <b>${username}</b>
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
                    </form>
                </div>
            </div>
        </nav>
        <%@include file="Include/sidebar.jsp"%>  
        <div class="main-wrapper">   
            <div class="page-wrapper">
                <div class="content container-fluid">
                    <div class="page-header">
                        <input id="searchValue"  placeholder="Search" class="input" type="text" name="searchValue" value="${searchValue}" >
                        <button class="btn btn-outline-success" onclick="search()" >SEARCH</button>  

                        <div class="row align-items-center">
                            <div class="col">                
                                <h4 class="card-title float-left mt-2">List of banned words</h4> 
                                <div class="mt-5  float-right dropdown">
                                    <input type="hidden" value="${sortType}">
                                    <select id="sortType" name="sortType" class="btn btn-secondary dropdown-toggle">
                                        <option value="numASC" ${sortType == 'numASC' ? 'selected' : ''}>ASC id</option>
                                        <option value="numDESC" ${sortType == 'numDESC' ? 'selected' : ''}>DESC id</option>
<!--                                        <option value="az" ${sortType == 'az' ? 'selected' : ''}>A-Z</option>
                                        <option value="za" ${sortType == 'za' ? 'selected' : ''}>Z-A</option>-->
                                    </select>


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
                                                        <th>CustomerID</th>                                 
                                                        <th>RoomNo</th>
                                                        <th>CreatedDate</th> 
                                                        <th>Content</th>
                                                        <th>Status</th>
                                                        <th>Action</th> 
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="p" items="${list_BB}">
                                                        <tr>
                                                            <td>${p.id}</td>
                                                            <td>${p.customerModel.id}</td>                                                
                                                            <td>${p.roomModel.roomNo}</td>      
                                                            <td>${p.createdDate}</td>      
                                                            <td>${p.content}</td>
                                                            <td>${p.status}</td>
                                                         
                                                            <td class="text-right">
                                                                <div class="onoffswitch">
                                                                    <input id="status${p.id}" type="hidden" name="status" value="${p.status}">
                                                                    <input value="" type="checkbox"  name="onoffswitch${p.id}" class="onoffswitch-checkbox" id="myonoffswitch${p.id}">
                                                                    <label class="onoffswitch-label" for="myonoffswitch${p.id}">
                                                                        <span class="onoffswitch-inner"></span>
                                                                        <span class="onoffswitch-switch"></span>
                                                                    </label>
                                                                </div>
                                                            </td>

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
                                                            <a id="link${i}" style="text-decoration: none;"  href="list_bb?index=${i}&action=${sortType}&search=${searchValue}">${i}</a>   
                                                        </c:when>

                                                        <c:otherwise>
                                                            <a id="link${i}" style="text-decoration: none;"  href="list_bb?index=${i}&action=${sortType}">${i}</a>   
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
                <script>

                    function search() {
                        var searchValue = document.getElementById('searchValue').value;
                        var indexValue = document.getElementById("index").value;
                        if (searchValue == "") {
                            alert('null');
                        } else {
                            window.location.href = 'list_bb?action=numASC&search=' + searchValue + "&index=" + indexValue + "";
                            console.log('list_bb?action=numASC&search=' + searchValue + "&index=" + indexValue + "");
                        }

                    }

                    document.getElementById('sortType').onchange = function () {
                        var searchValue = document.getElementById('searchValue').value;
                        console.log(searchValue);
                        var selectedOption = document.getElementById('sortType').value;
                        if (searchValue != null) {
                            window.location.href = 'list_bb?action=' + selectedOption + '&search=' + searchValue;
                        } else {
                            window.location.href = 'list_bb?action=' + selectedOption;
                        }
                    }



                    function statusLoad() {
                        var indexValue = document.getElementById("index").value;
                        var numberP = document.getElementById('number' + indexValue);
                        numberP.style.backgroundColor = "yellow";
                        var checkboxes = document.querySelectorAll('.onoffswitch-checkbox');
                        checkboxes.forEach(function (checkbox) {
                            var id = checkbox.id.split('myonoffswitch')[1];
                            var statusInput = document.getElementById('status' + id);
                            var status = statusInput.value;
                            console.log(status);
                            if (status === '1') {
                                checkbox.checked = true;

                            }
                            if (status === '0')
                                checkbox.checked = false;
                        }
                        );
                    }

                    document.addEventListener('DOMContentLoaded', function () {
                        var checkboxes = document.querySelectorAll('.onoffswitch-checkbox');
                        checkboxes.forEach(function (checkbox) {
                            checkbox.addEventListener('change', function () {
                                var id = this.id.split('myonoffswitch')[1];
                                var indexValue = document.getElementById("index").value;
                                var searchValue = document.getElementById('searchValue').value;
                                if (searchValue == "") {
                                    if (this.checked) {
                                        window.location.href = 'list_bb?unlock=1&id=' + id + '&action=numASC&index=' + indexValue + '';
                                    } else {
                                        window.location.href = 'list_bb?delete=1&id=' + id + '&action=numASC&index=' + indexValue + '';
                                    }
                                } else {
                                    if (this.checked) {
                                        window.location.href = 'list_bb?unlock=1&id=' + id + '&action=numASC&index=' + indexValue + '&search=' + searchValue + '';
                                    } else {
                                        window.location.href = 'list_bb?delete=1&id=' + id + '&action=numASC&index=' + indexValue + '&search=' + searchValue + '';
                                    }
                                }
                            });
                        });
                    });


                </script>
                </body>
                </html>
