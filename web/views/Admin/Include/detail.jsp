<%-- 
    Document   : detail
    Created on : Mar 12, 2024, 6:41:48 PM
    Author     : quandba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="assets/AdminSpace/css_include/supplier.css">
        <link rel="stylesheet" href="assets/AdminSpace/css/mainlist.css"/>
        <link rel="stylesheet" href="assets/AdminSpace/css/listSupCus.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-light ">
            <div class="container-fluid">
                <a class="navbar-brand"  href="MainList.jsp">
                    <img src="images/admin.jpeg" alt="Logo" height="64" class="d-inline-block align-text-top">
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
                        <input name="inputSearch" class="form-control me-2 w-75"  type="search"
                               placeholder="Nội dung tìm kiếm" aria-label="Search">

                        <input type="hidden" name="action" value="searchSupplier" >

                        <button class="btn btn-outline-success" type="submit">Tìm</button>         
                        <div class="dropdown float-right">
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
                                        <input type="hidden">Đổi Mật Khẩu</input>   
                                    </a>                         
                                </li>   

                                <li><a class="dropdown-item" href="#">Thoát</a></li>
                            </ul>
                        </div>					
                    </form>

                </div>
            </div>
        </nav>


        <div class="container">
            <h1>Customer Information</h1>
            <div class="info-item">
                <label for="avatar">Avatar:</label>
                <img id="avatar" src="" alt="Avatar">
            </div>
            <div class="info-item">
                <label for="fullname">Full Name:</label>
                <span id="fullname">${cust.fullname==null?"":cust.fullname}</span>
            </div>
            <div class="info-item">
                <label for="dob">Date of Birth:</label>
                <span id="dob">${cust.dob==null?"":cust.dob}</span>
            </div>
            <div class="info-item">
                <label for="role">Role:</label>
                <span id="role">${cust.roleModel.name==null?"":cust.roleModel.name}</span>
            </div>
            <div class="info-item">
                <label for="email">Email:</label>
                <span id="email">${cust.email==null?"":cust.email}</span>
            </div>
            <div class="info-item">
                <label for="phone">Phone:</label>
                <span id="phone">${cust.phone==null?"":cust.phone}</span>
            </div>
            <div class="info-item">
                <label for="status">Status:</label>
                <span id="status">${cust.status==null?"":cust.status}</span>
            </div>
            <div class="info-item">
                <label for="address">Address:</label>
                <span id="address">${cust.address==null?"":cust.address}</span>
            </div>
            <button  class="btn btn-primary "  onclick="history.go(-1)">Go Back</button>
            
        </div>

    </body>

    <style>
        /* Basic styling */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        .info-item {
            margin-bottom: 10px;
        }
        label {
            font-weight: bold;
        }
    </style>
</html>

