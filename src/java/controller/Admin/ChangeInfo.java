/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import dao.IAdminDAO;
import dao.impli.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.AdminModel;


/**
 *
 * @author quandba
 */
public class ChangeInfo extends HttpServlet {
 private IAdminDAO adminDao = new AdminDAO();
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangeInfo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangeInfo at " + request.getContextPath() + "</h1>");
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
       String adminId = request.getParameter("id");
        AdminModel adminModel = adminDao.findBy(Long.parseLong(adminId));
        request.setAttribute("adminModel", adminModel);
        request.getRequestDispatcher("views/Admin/ChangeInfo.jsp").forward(request, response);
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String fullname = request.getParameter("fullname");
        String dob = request.getParameter("dob");
        
        String baoLoi = "";
     
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
   
        if(phone.length() >= 10){
          baoLoi = "Lơn hơn 10";
        }

        if (adminDao.updateInfoAdmin(fullname, java.sql.Date.valueOf(dob), phone, address, Long.parseLong(id))) {
            request.setAttribute("mess", "Update profile successfully");  
            request.setAttribute("adminModel", adminDao.findBy(Long.parseLong(id)));
       
        }
        request.setAttribute("baoLoi", baoLoi);
        request.getRequestDispatcher("views/Admin/ChangeInfo.jsp").forward(request, response);

        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
