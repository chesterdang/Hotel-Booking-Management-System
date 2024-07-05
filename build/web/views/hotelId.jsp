<%-- 
    Document   : hotelId
    Created on : Mar 14, 2024, 3:33:35 PM
    Author     : LAPTOP DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hotel Registration</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                background-color: #f8f9fc;
            }
            .login-wrapper {
                margin-top: 50px;
            }
            .loginbox {
                background: #fff;
                border-radius: 8px;
                overflow: hidden;
                box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
            }
            .login-left img {
                width: 100%;
                padding: 15px;
                padding-bottom: 0;
            }
            .login-right {
                padding: 30px;
            }
            .login-right h1 {
                font-size: 28px;
                margin-bottom: 20px;
                color: #333;
            }
            .login-right input[type="text"],
            .login-right input[type="password"],
            .login-right textarea {
                border: 1px solid #ccc;
                border-radius: 5px;
                padding: 12px 15px;
                margin-bottom: 20px;
                width: 100%;
                font-size: 16px;
                color: #666;
            }
            .login-right input[type="number"],
            .login-right input[type="tel"] {
                border: 1px solid #ccc;
                border-radius: 5px;
                padding: 12px 15px;
                margin-bottom: 20px;
                width: 100%;
                font-size: 16px;
                color: #666;
            }
            .login-right input[type="file"] {
                margin-top: 10px;
            }
            .login-right button[type="submit"] {
                border: none;
                border-radius: 5px;
                padding: 12px 0;
                background-color: #007bff;
                color: #fff;
                font-size: 18px;
                width: 100%;
                cursor: pointer;
            }
            .login-right button[type="submit"]:hover {
                background-color: #0056b3;
            }
            .login-right p {
                color: red;
                margin-bottom: 15px;
            }
            .dont-have {
                margin-top: 20px;
                font-size: 16px;
            }

            /* Star Rating CSS */
            .star-rating {
                font-size: 0;
            }
            .star-rating input {
                display: none;
            }
            .star-rating label {
                display: inline-block;
                font-size: 30px;
                color: #ccc;
                cursor: pointer;
            }
            .star-rating label:before {
                content: "\2605";
                padding: 5px;
                font-size: 30px;
            }
            .star-rating input:checked ~ label {
                color: #ffcc00;
            }
            /* Reverse Star Rating */
            .star-rating-reverse label {
                direction: rtl;
            }
            /* Preview Image */
            .preview-container {
                display: flex;
                flex-wrap: wrap;
                justify-content: flex-start;
            }
            .preview-item {
                position: relative;
                width: 100px;
                margin-right: 10px;
                margin-bottom: 10px;
            }
            .preview-item img {
                max-width: 100%;
                height: auto;
                display: block;
            }
            .preview-item .remove-icon {
                position: absolute;
                top: 5px;
                right: 5px;
                background-color: rgba(255, 255, 255, 0.7);
                border-radius: 50%;
                cursor: pointer;
                padding: 5px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center login-wrapper">
                <div class="col-md-6">
                    <div class="loginbox">
                        <!--                    <div class="login-left">
                                                <img src="images/logo.jpg" alt="Logo">
                                            </div>-->

                        <div class="login-right">
                            <h1>Hotel Registration</h1>
                            <form id="hotelForm" action="hotelid" method="post">
                                <div class="form-group">
                                    <input class="form-control" type="text" placeholder="Hotel Name" name="nameHotel" pattern="[A-Za-z\s]+" title="Please enter only letters" required>
                                </div>
                                <div class="form-group">
                                    <textarea class="form-control" placeholder="Address" name="address" required></textarea>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="text" placeholder="Postcode" name="postcode" required>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="number" placeholder="Number of Rooms" name="numRoom" min="1" required>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="tel" placeholder="Phone Number" name="phone" pattern="[0-9]{10}" title="Please enter exactly 10 numerical digits" required>
                                </div>
                                <div class="form-group star-rating star-rating-reverse">
                                    <input type="radio" id="star1" name="starRating" value="1" required><label for="star1"></label>
                                    <input type="radio" id="star2" name="starRating" value="2" required><label for="star2"></label>
                                    <input type="radio" id="star3" name="starRating" value="3" required><label for="star3"></label>
                                    <input type="radio" id="star4" name="starRating" value="4" required><label for="star4"></label>
                                    <input type="radio" id="star5" name="starRating" value="5" required><label for="star5"></label>
                                </div>

                                <div class="form-group">
                                    <button class="btn btn-primary btn-block" type="submit">Register Hotel</button>
                                </div>
                            </form>
                            <div class="dont-have">Already have an account? <a href="login.jsp">Login</a> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script>
            function previewImages(event) {
                var previewContainer = document.getElementById('preview-container');
                var files = event.target.files;
                for (var i = 0; i < files.length; i++) {
                    var reader = new FileReader();
                    reader.onload = function () {
                        var previewItem = document.createElement('div');
                        previewItem.className = 'preview-item';
                        var img = document.createElement('img');
                        img.src = reader.result;
                        previewItem.appendChild(img);
                        var removeIcon = document.createElement('div');
                        removeIcon.className = 'remove-icon';
                        removeIcon.innerHTML = '&times;';
                        removeIcon.addEventListener('click', function () {
                            this.parentNode.parentNode.removeChild(this.parentNode);
                        });
                        previewItem.appendChild(removeIcon);
                        previewContainer.appendChild(previewItem);
                    }
                    reader.readAsDataURL(files[i]);
                }
            }
        </script>
    </body>
</html>