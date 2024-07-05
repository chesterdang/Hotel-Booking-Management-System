<%-- 
    Document   : setRole
    Created on : Mar 10, 2024, 1:40:41 PM
    Author     : LAPTOP DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Form with Buttons</title>
<style>
/* CSS */
body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.container {
    width: 50%;
}

.question {
    text-align: center;
    margin-bottom: 20px;
}

form {
    background-color: #fff;
    border-radius: 5px;
    padding: 20px;
    box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
}

button {
    padding: 10px 20px;
    margin: 5px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.customer-btn {
    background-color: #007bff;
    color: #fff;
}

.supplier-btn {
    background-color: #28a745;
    color: #fff;
}
</style>
</head>
<body>

<div class="container">
    <div class="question">
        <p>What role do you want to apply for?</p>
    </div>
<form id="myForm">
        <button type="button" class="customer-btn"><a href="http://localhost:9999//BookingHotel_Prj301/setrole?role=Cust">Customer</a></button>
        <button type="button" class="supplier-btn"><a href="http://localhost:9999/BookingHotel_Prj301/setrole?role=Sup">Supplier</a></button>
        </form>
</div>

<script>
// JavaScript
document.addEventListener('DOMContentLoaded', function () {
    var customerBtn = document.querySelector('.customer-btn');
    var supplierBtn = document.querySelector('.supplier-btn');

    customerBtn.addEventListener('click', function () {

    });

    supplierBtn.addEventListener('click', function () {

    });
});
</script>

</body>
</html>
