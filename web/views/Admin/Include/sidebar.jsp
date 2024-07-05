<%-- 
    Document   : Sidebar
    Created on : Mar 6, 2024, 2:01:44 AM
    Author     : quandba
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/sidebar.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/AdminSpace/css/sidebar.css"/>
        <link rel="stylesheet" href="assets/AdminSpace/css/list_supcus.css"/>
        <link rel="stylesheet" href="assets/AdminSpace/css/bootstrap-datetimepicker.min.css"/>
        <link rel="stylesheet" href="assets/AdminSpace/css_include/style.css">
        <link rel="stylesheet" href="assets/AdminSpace/AdminSpace/css_include/style2.min.css">
        <link rel="stylesheet" href="assets/AdminSpace/css_include/select2.min.css">
        <link rel="stylesheet" href="assets/AdminSpace/css_include/feathericon.min.css">
        <link rel="stylesheet" href="assets/AdminSpace/css_include/bootstrap.min.css">
        <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
            integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
        <style>
            .bac{
                background: #32394E;
                height: 800px;
                margin-top: 42px;
            }
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;
            }
            .title{
                width: 260px;
                line-height: 65px;
                text-align: center;
                background: #333;
                font-size: 25px;
                font-weight: 600;
                color: #f2f2f2;
                border-bottom: 1px solid #222;
            }
            .icons{
                width: 100%;
                height: 40px;
                text-align: center;
                position: absolute;
                
                display: flex;
                align-items: center;
                justify-content: center;
            }
            #i {
                padding-top: 10px; 
            }
            .icons a {
                color: white;
                padding: 0 10px;
                height: 100%;
                width: 40px;
                display: block;
                margin: 0 5px;
                margin-right: 20px;
                font-size: 18px;
                color: #f2f2f2;
                background: #4a4a4a;
                border-radius: 5px;
                border: 1px solid #383838;
                transition: all 0.3s ease;
            }
            .icons a:hover {
                background: #404040;
            }
            .list-items{
                color: white;
                position: relative;
                background: #404040;
                width: 100%;
                height: 100%;
                list-style: none;
            }
            .list-items li{
                color: white;
                padding-left: 40px;
                line-height: 50px;
                border-top: 1px solid rgba(255,255,255,0.1);
                border-bottom: 1px solid #333;
                transition: all 0.3s ease;
            }
            .list-items li:hover{
                border-top: 1px solid transparent;
                border-bottom: 1px solid transparent;
                box-shadow: 0 0px 10px 3px #222;
            }
            #mr{
                margin-right: 20px;
                color: white;
            } 
            #co{
                color: white;
                  text-decoration: none;
            }
        </style>
    </head>

    <body>  
        <div class="sidebar  bac wrapper" id="sidebar">
            <input type="checkbox" id="btn" hidden>
      <label for="btn" class="menu-btn">
          <div class="title">SideBar Menu</div>
      </label>
            <div class="sidebar-inner slimscroll">
                <div id="sidebar-menu list-items" class="sidebar-menu">
                    <ul class="flex-start">            
                        <li><a id="co" href="Main_ListController">
                                <i id="mr" class="fas fa-home"></i>
                                Home
                            </a>
                        </li>
                        <li><a id="co" href="list_supplier?action=numASC&index=1"><i id="mr" class="fas fa-sliders-h"></i>Supplier</a></li>
                        <li><a id="co" href="list_customer?action=numASC&index=1"><i id="mr" class="fas fa-address-book"></i>Customer</a></li>
                        <li><a id="co" href="list_report?action=numASC&index=1"><i id="mr" class="fas fa-cog"></i>Report</a></li>
                        <li><a id="co" href="list_feedback"><i id="mr" class="fas fa-user"></i>Feedback</a></li>
                    </ul>
                    <div class="icons">
                        <a href="#"><i id="i" class="fab fa-facebook-f"></i></a>
                        <a href="#"><i id="i" class="fab fa-twitter"></i></a>
                        <a href="#"><i id="i" class="fab fa-github"></i></a>
                        <a href="#"><i id="i" class="fab fa-youtube"></i></a>
                    </div>
                </div>

            </div>
        </div> 
    </body> 
</html>
