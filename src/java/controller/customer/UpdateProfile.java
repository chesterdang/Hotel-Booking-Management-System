/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.customer;

import dao.ICustomerDAO;
import dao.impli.CustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CustomerModel;
import service.IUpdateProfileService;
import service.impli.UpdateProfileService;
import util.EncryptionUtil;
import util.SessionUtil;

/**
 *
 * @author HI
 */
@MultipartConfig
@WebServlet(name = "UpdateProfile", urlPatterns = {"/updateprofile"})
public class UpdateProfile extends HttpServlet {

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
            out.println("<title>Servlet UpdateProfile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProfile at " + request.getContextPath() + "</h1>");
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
        CustomerModel c = (CustomerModel) (request.getSession().getAttribute("user"));
        ICustomerDAO cDao = new CustomerDAO();
        CustomerModel c_updated = cDao.findBy(c.getId());
        request.setAttribute("user", c_updated);
        request.getRequestDispatcher("views/customer/CustomerProfile.jsp").forward(request, response);
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
        throws ServletException, IOException{
        String action = request.getParameter("action");
        CustomerModel c = (CustomerModel) (request.getSession().getAttribute("user"));
        // Xử lý các hành động khác nhau sử dụng switch-case
        switch (action) {
            case "updateprofile":
                ICustomerDAO cDAO = new CustomerDAO();

//        HttpSession session = request.getSession();
//        session.setAttribute("user", cDAO.findBy(1));
//        response.sendRedirect("views/customer/CustomerProfile.jsp");
                try {
                    long id = c.getId();
                    String fullname = request.getParameter("fullname");
                    String email = request.getParameter("email");
                    String dob = request.getParameter("dob");
                    String phone = request.getParameter("phone");
                    String address = request.getParameter("address");
                    Part part = request.getPart("avatar");
                    String realPath = request.getServletContext().getRealPath("/images/avatar");
                    String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();

                    if (!Files.exists(Path.of(realPath))) {
                        Files.createDirectory(Path.of(realPath));

                    }
                    part.write(realPath + "/" + filename);
                    cDAO.updateProfile(fullname, dob, email, phone, address, filename, id);
                    c.setAvatar(filename);
                    SessionUtil.getInstance().putValue(request, "user", c);
                    request.setAttribute("success", "Update Success!");
                    doGet(request, response);
                } catch (Exception e) {
//            request.setAttribute("error", e);
//            request.getRequestDispatcher("list").forward(request, response);
                }
                break;
            case "updatepassword":
                // Xử lý cập nhật dữ liệu
                String oldPass = request.getParameter("oldpassword");
                String newPass = request.getParameter("newpassword");
                String confirmPass = request.getParameter("confirmpassword");

                ICustomerDAO cDao = new CustomerDAO();
                IUpdateProfileService up = new UpdateProfileService();
                if (!up.samePassword(EncryptionUtil.toSHA1(oldPass), cDao.findBy(c.getId()).getPassword())) {
                    request.setAttribute("wrongOldPass", "Wrong Password!");
            try {
                request.getRequestDispatcher("views/customer/CustomerProfile.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(UpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
                } else if (up.samePassword(oldPass, newPass)) {
                    request.setAttribute("wrongNewPass", "Your new password is the same as old password!");
            try {
                request.getRequestDispatcher("views/customer/CustomerProfile.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(UpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
                } else if (!up.samePassword(newPass, confirmPass)) {
                    request.setAttribute("wrongConfirmPass", "Your confirm password is wrong!");
            try {
                request.getRequestDispatcher("views/customer/CustomerProfile.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(UpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
                } else {
                    cDao.updatePassword(EncryptionUtil.toSHA1(newPass), c.getId());
                    request.setAttribute("success", "Update Success!");
            try {
                request.getRequestDispatcher("views/customer/CustomerProfile.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(UpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                break;
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
