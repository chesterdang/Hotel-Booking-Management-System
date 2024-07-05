<%-- 
    Document   : DoiMatKhau
    Created on : Mar 8, 2024, 10:37:26 PM
    Author     : quandba
--%>
<%@page import="model.AdminModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đổi Mật Khẩu</title>
        <link rel="shortcut icon" type="image/x-icon" href="images/admin.jpeg">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
		String baoLoi = request.getAttribute("baoLoi")+"";
		if(baoLoi.equals("null")){
		      baoLoi = "";
                }
	%> 

        <div class="container">
            <h1>ĐỔI MẬT KHẨU</h1>
             <span style="color: red">  
                <%=baoLoi%>
            </span>
            <form action="doimatkhau" method="POST">
                <div class="mb-3">
                    <label for="matKhauHienTai" class="form-label">Mật khẩu hiện tại</label>
                    <input type="password" class="form-control" id="matKhauHienTai" name="matKhauHienTai">
                </div>
                <div class="mb-3">
                    <label for="matKhauMoi" class="form-label">Mật khẩu mới</label>
                    <input type="password" class="form-control" id="matKhauMoi" name="matKhauMoi">
                </div>
                <div class="mb-3">
                    <label for="matKhauMoiNhapLai" class="form-label"> Nhập lại mật khẩu mới</label>
                    <input type="password" class="form-control" id="matKhauMoiNhapLai" name="matKhauMoiNhapLai">
                </div>          
                <button type="submit" class="btn btn-primary">Lưu mật khẩu</button>    
            </form>
             <a class="mt-3 btn btn-primary" style="white-space: nowrap;" href="Main_ListController">
                            Go Back
            </a>

        </div>
    </body>
</html>
