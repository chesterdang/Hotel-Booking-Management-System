/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.supplier;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import model.CustomerModel;
import model.SupplierModel;
import service.impli.supplier.SupplierService;
import service.supplier.ISupplierService;
import util.EncryptionUtil;

/**
 *
 * @author MaiGiang
 */
@MultipartConfig(maxFileSize = 1024 * 10)
public class supplierProfileServlet extends HttpServlet {

    private ISupplierService supplierService = new SupplierService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet supplierProfileServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet supplierProfileServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "showUpdateProfile":
                showUpdateProfile(request, response);
                break;
            case "updateProfile":
                updateProfile(request, response);
                break;
        }

    }

    private void showUpdateProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long supplierId = Long.valueOf(String.valueOf(request.getSession().getAttribute("supplierId")));
        SupplierModel supplierModel = supplierService.getSuplierBy(supplierId);
        request.setAttribute("supplier", supplierModel);
        request.getRequestDispatcher("views/supplier/supplierProfile.jsp").forward(request, response);
    }

    private void updateProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String supplierId = request.getParameter("supplierId");
            String fullname = request.getParameter("fullname");
            String email = request.getParameter("email");
            String dob = request.getParameter("dob");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            String avatar = request.getParameter("avatar") + "";
            long id = Long.valueOf(supplierId);

            if (supplierService.updateSupplierProfile(fullname, dob, email, phone, address, avatar, id)) {
                request.setAttribute("success", "Update Success!");
                request.setAttribute("supplier", supplierService.getSuplierBy(id));
                request.getRequestDispatcher("views/supplier/supplierProfile.jsp").forward(request, response);
            } else {
                request.setAttribute("success", "Update Success!");
                request.getRequestDispatcher("views/supplier/error.jsp").forward(request, response);
            }

        } catch (Exception e) {

        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String supplierId = request.getParameter("supplierId");
        String oldPass = request.getParameter("oldPassword");
        String newPass = request.getParameter("newPassword");
        String confirmPass = request.getParameter("confirmPassword");
      
        SupplierModel supplierModel = supplierService.getSuplierBy(Long.valueOf(supplierId));
        String status = "";

        if (!checkPassword(EncryptionUtil.toSHA1(oldPass), supplierModel.getPassword())) {
            status = "Wrong Password";
        } else if (checkPassword(EncryptionUtil.toSHA1(oldPass), EncryptionUtil.toSHA1(newPass))) {
            status = "Your new password is the same as the old password";
        } else if (!checkPassword(newPass, confirmPass)) {
            status = "Your confirm password is wrong";
        } else {
            String newPassEncrupt = EncryptionUtil.toSHA1(newPass);
            supplierService.updatePassword(newPass, Long.valueOf(supplierId));
            status = "Update Success";
        }

        request.setAttribute("status", status);
        request.setAttribute("supplier", supplierService.getSuplierBy(Long.valueOf(supplierId)));
        request.getRequestDispatcher("views/supplier/supplierProfile.jsp").forward(request, response);

    }

    private boolean checkPassword(String password1, String password2) {
        if (!password1.equalsIgnoreCase(password2)) {
            return false;
        }
        return true;
    }

    private String processImage(HttpServletRequest request) {
        try {
            Part part = request.getPart("avatar");
            String realPath = request.getServletContext().getRealPath("/images/supplier");
            String fileName = java.nio.file.Path.of(part.getSubmittedFileName()).getFileName().toString();

            if (!Files.exists(java.nio.file.Path.of(realPath))) {
                Files.createDirectory(java.nio.file.Path.of(realPath));
            }

            part.write(realPath + "/" + fileName);
            return fileName;
        } catch (IOException | ServletException ex) {
            return null;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
