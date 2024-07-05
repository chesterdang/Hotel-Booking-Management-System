<%-- 
    Document   : Header
    Created on : Mar 6, 2024, 2:01:17 AM
    Author     : quandba
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/AdminSpace/css/header.css"/>
        <link rel="stylesheet" href="assets/AdminSpace/css/sidebar.css"/>
        <link rel="stylesheet" href="assets/AdminSpace/css/list_supcus.css"/>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </head>
    <body>      
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="data:image/jpeg;base64,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" alt="Logo" height="48" class="d-inline-block align-text-top">
                </a>
                <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Dropdown button
                            </button>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                </div>
                
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link active"
                                                aria-current="page" href="#">Trang chủ</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Combo
                                giảm giá</a></li>
                        <li class="nav-item dropdown"><a
                                class="nav-link dropdown-toggle" href="#" role="button"
                                data-bs-toggle="dropdown" aria-expanded="false"> Thể loại </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Quần Jean</a></li>
                                <li><a class="dropdown-item" href="#">Áo thun</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Áo sơ mi</a></li>
                            </ul></li>
                        <li class="nav-item"><a class="nav-link disabled">Hết hàng</a>
                        </li>
                    </ul>
                    
                    <form class="d-flex" role="search" style="position: relative;display: block;float: right;">
                        <input class="form-control me-2" type="search"
                               placeholder="Nội dung tìm kiếm" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Tìm</button>         
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Dropdown button
                            </button>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </div>				
                    </form>
                </div>
            </div>
        </nav>
    </body>
</html>
